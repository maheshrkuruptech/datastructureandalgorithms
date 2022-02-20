package array;

import static java.util.Comparator.comparingInt;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collector;
import java.util.stream.Collectors;

class CountOfHighestInArray {

  public static void main(String[] args) {
    int [] test =  {1,2,3,4,6,7,9,9,7,9,7,7,7,1};

    int res = Arrays.stream(test).boxed().
                collect(Collectors.toMap(integer -> integer , v -> 1 , Integer::sum)).
                  entrySet().stream().
                      sorted(Map.Entry.comparingByKey(Comparator.reverseOrder())).
                          findFirst().get().getValue();

    System.out.println(res);

    System.out.println( Arrays.stream(test).boxed().collect(allMaxBy(
        comparingInt(s -> s), Collectors.counting())));
  }

  public static <T, A, R> Collector<T, ?, R> allMaxBy(Comparator<? super T> cmp, Collector<? super T, A, R> downstream) {
    class AllMax {
      T val;
      A acc = null; // null means empty

      void add(T t) {
        int c = acc == null ? 1 : cmp.compare(t, val);
        if (c > 0) {
          val = t;
          acc = downstream.supplier().get();
          downstream.accumulator().accept(acc, t);
        } else if (c == 0) {
          downstream.accumulator().accept(acc, t);
        }
      }

      AllMax merge(AllMax other) {
        if (other.acc == null) {
          return this;
        } else if (this.acc == null) {
          return other;
        }
        int c = cmp.compare(this.val, other.val);
        if (c == 0) {
          this.acc = downstream.combiner().apply(this.acc, other.acc);
        }
        return c >= 0 ? this : other;
      }

      R finish() {
        return downstream.finisher().apply(acc);
      }
    }

    return Collector.of(AllMax::new, AllMax::add, AllMax::merge, AllMax::finish);
  }
}