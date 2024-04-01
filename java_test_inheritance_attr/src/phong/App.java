package phong;

public class App {
    public static void main(String[] args) {
        BaseClass cl = new ConcreteClass();
        int attr = cl.getAttribute();
        System.out.println("super attr 0 = " + attr);

        attr = ((ConcreteClass)cl).getAttr();
        System.out.println("concrete attr 0 = " + attr);

        //Set attr again
        cl.setAttribute(1);
        attr = cl.getAttribute();
        System.out.println("super attr 1 = " + attr);

        attr = ((ConcreteClass)cl).getAttr();
        System.out.println("concrete attr 1 = " + attr);

        //Set attr again
        ((ConcreteClass) cl).setAttr(2);
        attr = cl.getAttribute();
        System.out.println("super attr 2 = " + attr);

        attr = ((ConcreteClass)cl).getAttr();
        System.out.println("concrete attr 2 = " + attr);

        System.out.println(cl.getClass());
    }
}
