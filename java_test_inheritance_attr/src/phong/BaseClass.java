package phong;

public class BaseClass {
    protected int attribute;

    public int getAttribute() {
        System.out.println("BaseClass");
        return attribute;
    }

    public void setAttribute(int attribute) {
        this.attribute = attribute;
    }
}
