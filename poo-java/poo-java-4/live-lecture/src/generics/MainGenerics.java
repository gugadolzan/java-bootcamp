package generics;

import java.util.ArrayList;
import java.util.List;

public class MainGenerics {

    public static void main(String[] args) {
        MyClass<Integer> obj1 = new MyClass<>(222);
        MyClass<String> obj2 = new MyClass<>("Text");

        System.out.println(obj1.getObj());
        System.out.println(obj2.getObj());

        // List of unknown type, not recommended
        List<?> list = new ArrayList<>();
    }
}
