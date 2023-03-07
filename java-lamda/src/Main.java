import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        main.run();

    }

    private void run() {
        final int localVar = 10;

        //Local Class
        class LocalClass {
            void printVar(){
                int localVar  = 20; // 쉐도윙 Test
                System.out.println(localVar);
            }
        }

        LocalClass localClass = new LocalClass();
        localClass.printVar();

        //익명 클래스
        Consumer<Integer> printVar = new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                int localVar = 100; // 쉐도윙 Test
                System.out.println(localVar+integer);
            }
        };

        printVar.accept(10);

        //람다.
        Consumer<Integer> printLamda = i-> {
            //int localVar = 20; 쉐도윙 Test : 같은 Scope에 같은 이름의 변수 선언 불가!
            System.out.println(i+localVar);
        };
        printVar.accept(5);

    }
}