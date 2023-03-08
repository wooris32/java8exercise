public class Greeting {
    public String getName() {
        return name;
    }

    private String name;

    public Greeting(){
    }

    public Greeting(String name){
        this.name=name;
    }




    public static String staticMethod(String name){
        return name+" call static method";
    }

    public String instanceMethod(String name){
        return name+" call instance method";
    }
}
