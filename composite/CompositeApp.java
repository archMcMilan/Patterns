import java.util.ArrayList;
import java.util.List;

/**
 * Created by Artem on 15.06.16.
 */
public class CompositeApp {
    public static void main(String[] args) {
        Shape square1=new Square();
        Shape square2=new Square();
        Shape square3=new Square();

        Shape triangle=new Triangle();

        Shape circle1=new Circle();
        Shape circle2=new Circle();
        Shape circle3=new Circle();

        Composite composite1=new Composite();
        Composite composite2=new Composite();
        Composite composite3 =new Composite();

        composite1.addComponent(square1);
        composite1.addComponent(square2);
        composite1.addComponent(triangle);

        composite2.addComponent(square3);
        composite2.addComponent(circle1);
        composite2.addComponent(circle2);
        composite2.addComponent(circle3);

        composite3.addComponent(composite1);
        composite3.addComponent(composite2);

        composite3.addComponent(new Triangle());

        composite3.draw();
    }
}

interface Shape{
    void draw();
}

class Square implements Shape{

    @Override
    public void draw() {
        System.out.println("I'm square");
    }
}

class Triangle implements Shape{

    @Override
    public void draw() {
        System.out.println("I'm triangle");
    }
}

class Circle implements Shape{

    @Override
    public void draw() {
        System.out.println("I'm circle");
    }
}

class Composite implements Shape{
    private List<Shape> components=new ArrayList<>();

    public void addComponent(Shape component){
        components.add(component);
    }

    public void removeComponent(Shape component){
        components.remove( component);
    }

    @Override
    public void draw() {
        for(Shape component:components){
            component.draw();
        }
    }
}