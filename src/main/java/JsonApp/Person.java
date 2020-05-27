package JsonApp;

import java.util.List;

public class Person {
    String name;
    String surname;
    int age;
    List<Integer> days;

    public Person() {
    }

    public Person(String name, String surname, int age, List<Integer> days) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.days = days;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public List<Integer> getDays() {
        return days;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setDays(List<Integer> days) {
        this.days = days;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", days=" + days +
                '}';
    }
}
