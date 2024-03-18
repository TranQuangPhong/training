package phong;

public class App {
    public static void main(String[] args) {
        BaseClass cl = new ConcreteClass();
        int attr = cl.getAttribute();
        System.out.println("attr = " + attr);

        attr = ((ConcreteClass)cl).getAttr();
        System.out.println("attr = " + attr);

        System.out.println(cl.getClass());
    }
}
