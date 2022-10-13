package lambda;

public class MainLambda {

    interface InterfaceString {
        String execute(String s);
    }

    public static void main(String[] args) {
        InterfaceString interfaceString = s -> s + " World";
        print("Hello", interfaceString);
    }

    public static void print(String text, InterfaceString interfaceString) {
        System.out.println(interfaceString.execute(text));
    }

}
