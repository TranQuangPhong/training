package phong;

public class ConcreteClass extends BaseClass{
    @Override
    public int getAttribute() {
        System.out.println("ConcreteClass");
        return super.getAttribute();
    }

    public int getAttr(){
//        return this.attribute;
        return attribute;
    }
}
