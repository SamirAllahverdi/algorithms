package FreeMarker;

public class Student {
  final String name;
  final int age;
  final String group;

  public Student(String name, int age, String group) {
    this.name = name;
    this.age = age;
    this.group = group;
  }

  public String getName() {
    return name;
  }
  public String uName() {
    return name.toUpperCase();
  }

  public int getAge() {
    return age;
  }

  public String getGroup() {
    return group;
  }
}
