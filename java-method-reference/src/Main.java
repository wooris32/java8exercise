import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class Main {
    public static void main(String[] args) {
        //Greeting 을 구현하고 staticMethod를 쓰겠다 선언
        UnaryOperator<String>staticMethod = Greeting::staticMethod;
        System.out.println(staticMethod.apply("wooris"));

        Greeting greeting = new Greeting();
        Function<String, String> instanceMethod= greeting::instanceMethod;
        System.out.println(instanceMethod.apply("wooris"));

        //입력값이 없는 생성자
        //이 자체로는 인스턴스를 만든 것이 아니다. => Just Supplier
        Supplier<Greeting>constructorRefernce = Greeting::new;
        //이 시점에 인스턴스 생성
        Greeting greeting2 = constructorRefernce.get();
        System.out.println(greeting2.getName());

        //입력값이 있는 생성자
        Function<String, Greeting>constructorWithInput = Greeting::new;
        Greeting greeting3 = constructorWithInput.apply("wooris");
        System.out.println(greeting3.getName());

        //=> 위의 new와 아래 new는 다른 Consturctor를 참조한다!


        String[] names = {"wooris", "sunghun" , "whoareu"};

        //이전에 사용법
        Arrays.sort(names, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return 0;
            }
        });

        //람다를 쓸수도
        Arrays.sort(names,(o1, o2) -> 0);

        //임이의 객체(String) 인스턴스메소드 (compare.... ) 메소드 레퍼런스를 쓸수도 있다.
        Arrays.sort(names,String::compareToIgnoreCase);


    }
}