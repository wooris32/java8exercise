import java.util.function.*;

public class Main {
    public static void main(String[] args) {
        Function<Integer,Integer>plus1 = (i) -> i+1;
        Function<Integer,Integer>multiply2 = (i) -> i*2;

        System.out.println(plus1.apply(2));
        System.out.println(multiply2.apply(2));

        Function<Integer,Integer>andThenEx = plus1.andThen(multiply2);
        System.out.println(andThenEx.apply(3));

        Function<Integer,Integer>composeEx = plus1.compose(multiply2);
        System.out.println(composeEx.apply(3));

        BiFunction<Integer,Integer,Integer> plus2Integer = (i,j)->i+j;
        System.out.println(plus2Integer.apply(2,4));

        Consumer<String> printMyName = (s)-> System.out.println(s);
        printMyName.accept("Wooris");

        Supplier<String> returnName = ()->"Wooris";
        System.out.println(returnName.get());

        Predicate<Integer> isNegative = (i)->i<0;
        System.out.println(isNegative.test(-1));

        Predicate<Integer> isNegativeAnd = (i)-> i>-10;
        System.out.println(isNegativeAnd.and(isNegativeAnd).test(-11));

    }
}