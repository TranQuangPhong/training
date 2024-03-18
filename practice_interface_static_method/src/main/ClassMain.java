package main;

public class ClassMain {
    public static void main(String[] args) {
        ClassTest classTest = new ClassTest();
        classTest.method();
        System.out.println("call static method of interface...");
        int x = InterfaceTest.staticMethod();
        System.out.println("x = " + x);
    }
}
