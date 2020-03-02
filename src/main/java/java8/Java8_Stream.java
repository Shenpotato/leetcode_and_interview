package java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Java8_Stream {

    public static void main(String[] args) {

        /*
         * Predicate
         * */
        Predicate<Integer> intBigger6 = x -> x > 6;
        Predicate<Integer> intBigger4 = x -> x > 4;
        System.out.println("------------------ Predicate ------------------");
        System.out.println(intBigger6.test(5));
        System.out.println(intBigger6.or(intBigger4).test(5));
        System.out.println();

        /*
         * BinaryOperator
         * */
        BinaryOperator<Integer> minusInteger = (x, y) -> x - y;
        BinaryOperator<Integer> minusAbsInteger = (x, y) -> {
            if (y > x) {
                return y - x;
            }
            return x - y;
        };
        System.out.println("------------------ BinaryOperator ------------------");
        System.out.println(minusInteger.apply(2, 3));
        System.out.println(minusAbsInteger.apply(2, 3));
        System.out.println();

        /*
         * stream.filter
         * Stream<T> filter(Predicate<? super T> predicate);
         * get the boolean result of expression in filter and return the result
         * filter means less number result.
         * */
        String[] arrayStr = {"a", "b", "c", "abc"};
        Stream<String> stringStream = Arrays.stream(arrayStr);
        long strContainA = stringStream.filter(x -> x.contains("a")).count();
        System.out.println("------------------ Stream.filter ------------------");
        System.out.println(strContainA);
        System.out.println();

        /*
         * stream.map
         * <R> Stream<R> map(Function<? super T, ? extends R> mapper);
         * get T and return R
         * the former size equals to latter size
         * */

        List<Student> students = new ArrayList<>();
        students.add(new Student("张三", "男", 18));
        students.add(new Student("李四", "男", 20));
        students.add(new Student("韩梅梅", "女", 18));
        students.add(new Student("小红", "女", 45));

        // List of Objects -> List of String
        List<String> results = students.stream().map(x -> x.getName()).collect(Collectors.toList());
        System.out.println("------------------ Stream.map ------------------");
        System.out.println(results);
        System.out.println();

        /*
         * flatmap
         * <R> Stream<R> flatMap(Function<? super T, ? extends Stream<? extends R>> mapper);
         * same as map, get Function Interface, return Stream
         * means combine two streams into one.
         * */

        String[] strs = {"aaa", "bbb", "ccc"};
        System.out.println("------------------ Stream.flatmap ------------------");
        Arrays.stream(strs)
                .map(str -> str.split(""))
                .forEach(System.out::println);// Ljava.lang.String;@53d8d10a
        Arrays.stream(strs)
                .map(str -> str.split(""))
                .flatMap(Arrays::stream)
                .forEach(System.out::print);// aaabbbccc
        System.out.println();
        Arrays.stream(strs)
                .map(str -> str.split(""))
                .flatMap(str -> Arrays.stream(str))
                .forEach(System.out::print);// aaabbbccc
        System.out.println();
        System.out.println();

        /*
         * Stream.reduce
         * */
        System.out.println("------------------ Stream.reduce ------------------");
        int sumAll = Stream.of(1, 2, 3, 4)
                .reduce(0, (sum, element) -> sum + element);
        System.out.println(sumAll);
        sumAll = Stream.of(1, 2, 3, 4).reduce(0, Integer::sum);
        System.out.println(sumAll);

        /*
         * Stream.mapToInt
         * */
        List<Student> students1 = new ArrayList<>();
        students1.add(new Student("张三", "男", 18));
        students1.add(new Student("李四", "男", 20));
        students1.add(new Student("韩梅梅", "女", 18));
        students1.add(new Student("小红", "女", 45));
        System.out.println("------------------ Stream.mapToInt ------------------");
        IntSummaryStatistics intSummaryStatistics = students1.stream().mapToInt(student -> student.getAge()).summaryStatistics();
        System.out.println("max age: " + intSummaryStatistics.getMax());
        System.out.println("min age: " + intSummaryStatistics.getMin());
        System.out.println("average age: " + intSummaryStatistics.getAverage());
        System.out.println("sum age: " + intSummaryStatistics.getSum());
        System.out.println("students num: " + intSummaryStatistics.getCount());


        ToIntFunction<Student> studentToIntFunction = new ToIntFunction<Student>() {
            @Override
            public int applyAsInt(Student student) {
                return student.getAge();
            }
        };

        IntSummaryStatistics intSummaryStatistics1 = students1.stream().mapToInt(studentToIntFunction).summaryStatistics();
        System.out.println("max age: " + intSummaryStatistics1.getMax());

        ToIntFunction<Student> studentToIntFunction1 = student -> student.getAge();
        IntSummaryStatistics intSummaryStatistics2 = students1.stream().mapToInt(studentToIntFunction1).summaryStatistics();
        System.out.println("max age: " + intSummaryStatistics2.getMax());

    }

}

