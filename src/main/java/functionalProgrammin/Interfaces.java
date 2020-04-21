package functionalProgrammin;

import org.w3c.dom.ls.LSOutput;

import java.util.List;
import java.util.function.*;
import java.util.stream.Collectors;

public class Interfaces {
    public static <pet2> void main(String[] args) {
        List<Pet> pet = List.of(
                new Pet("Dog", "toplan"),
                new Pet("Fish", "alex"),
                new Pet("Dog", "topik"),
                new Pet("Cat", "mestan") );
        List<Pet> dogPet = pet.stream().filter(pet1 -> "Dog".equals(pet1.getSpecies())).collect(Collectors.toList());
        dogPet.forEach(System.out::println);
        System.out.println("////////////////////////////////");
//
        System.out.println(strinFunction.apply("ay Azerbaycan"));
        System.out.println("////////////////////////////////");

//
        System.out.println(combineWithStringFunction.apply(strinFunction.apply("ay Azerbaycan")));
        System.out.println("////////////////////////////////");
//
        Function<String, String> doubleS = strinFunction.andThen(combineWithStringFunction);
        System.out.println(doubleS.apply("ay Azerbaycan"));
        System.out.println("////////////////////////////////");
//
        System.out.println(useToEnter2Input.apply(22, "Qafqaz"));
        System.out.println("////////////////////////////////");

//
        BiFunction<Integer, String, String> doublesS = useToEnter2Input.andThen(strinFunction);
        System.out.println(doublesS.apply(33, "Qafqaz"));
        System.out.println("////////////////////////////////");
//
        Pet pet2 = new Pet("Bear", "Medmed");
        consumeAProses.andThen(consumeAProses2).accept(pet2);
        System.out.println("////////////////////////////////");
//
        consumeProsesByBiConsumer.accept(pet2,true);
        System.out.println("////////////////////////////////");
//
        System.out.println(checkPredicate.test(6));
        System.out.println("////////////////////////////////");
//
        System.out.println(checkBiPredicate.test(2,"Samir"));
        System.out.println("////////////////////////////////");
//
        System.out.println(supplier.get());
        System.out.println("////////////////////////////////");
//

    }

    static Function<String, String> strinFunction = a -> "Azerbaycan " + a;
    static Function<String, String> combineWithStringFunction = a -> a + ", Sanli Azerbaycan";
    static BiFunction<Integer, String, String> useToEnter2Input = (registrationNumber, OtelName) -> registrationNumber + ". in the otel of " + OtelName;
    static Consumer<Pet> consumeAProses = consumer -> System.out.println("The species type is " + consumer.species + " And The name of this beatufil " + consumer.species + " is " + consumer.name);
    static Consumer<Pet> consumeAProses2 = consumer ->  System.out.println(consumer.species + " name is " + consumer.name);
    static BiConsumer<Pet,Boolean> consumeProsesByBiConsumer= (consumer,a) ->
            System.out.println(consumer.species + " type of species registration can not be accepted " + "because of "
            +(a ? "Savage level" : "Financial problem" ) );
    static Predicate<Integer> checkPredicate = a -> a>5;
    static BiPredicate<Integer,String> checkBiPredicate = (a,b) -> a<5 && b.length()>3;
    static Supplier<String> supplier = ()-> "this is supplier";

}

