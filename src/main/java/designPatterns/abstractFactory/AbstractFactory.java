package designPatterns.abstractFactory;

public interface AbstractFactory<T> {
    T create(String animalType);
}
