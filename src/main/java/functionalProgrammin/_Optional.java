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


        Optional.ofNullable(null).ifPresent(a-> System.out.println(a));
        Optional.ofNullable(null).ifPresentOrElse(a-> System.out.println(a) ,()-> System.out.println("empty"));

    }
}
