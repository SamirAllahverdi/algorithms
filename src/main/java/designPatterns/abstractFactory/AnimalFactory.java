package designPatterns.abstractFactory;

public class AnimalFactory implements AbstractFactory<Animal> {
    @Override
    public Animal create(String animalType) {
        if ("Lion".equalsIgnoreCase(animalType)) {
            return new Lion();
        } else if ("Monkey".equalsIgnoreCase(animalType)) {
            return new Monkey();
        } else {
            throw new IllegalArgumentException();
        }
    }
}
