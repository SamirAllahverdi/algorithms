package designPatterns.prototype;


//cloning of an existing object instead of creating new one and can also be customized as per the requirement.
public class Car implements Prototype {

    private String name;

    @Override
    public Prototype clone() {
        return new Car();
    }
}
