package designPatterns.factory;

public class CarFactory {

    public static void main(String[] args) {
        Object o = new Object();
        System.out.println(o.hashCode());

        Object object = new Object();
        System.out.println(object.hashCode());
    }
    public Car getCar(int numberOfSides) {
        if (numberOfSides == 1) {
            return new Mercedes();
        } else if (numberOfSides == 2) {
            return new Bmw();
        } else if (numberOfSides == 3) {
            return new Nissan();
        } else {
            throw new IllegalArgumentException();
        }
    }


}
