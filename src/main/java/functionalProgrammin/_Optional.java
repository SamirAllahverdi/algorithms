package functionalProgrammin;

import java.util.List;
import java.util.Optional;

public class _Optional {
    public static void main(String[] args) {
        List<Pet> pet = List.of(
                new Pet("Dog", "toplan"),
                new Pet("Fish", "alex"),
                new Pet("Dog", "topik"),
                new Pet("Cat", "mestan") );


        Optional.ofNullable(null).ifPresent(System.out::println);
        Optional.ofNullable(null).ifPresentOrElse(System.out::println,()-> System.out.println("empty"));

    }
}
