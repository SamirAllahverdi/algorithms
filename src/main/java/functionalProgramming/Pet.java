package functionalProgramming;

public class Pet {
   final String species;
   final  String name;

    public Pet(String species, String name) {
        this.species = species;
        this.name = name;
    }

    public String getSpecies() {
        return species;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "species='" + species + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
