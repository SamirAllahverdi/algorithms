package designPatterns.builder;

public class User {
    private final Long id;
    private final String name;
    private final String surname;
    private final Long age;


    public static void main(String[] args) {
        User user = new UserBuilder()
                .age(20L)
                .name("Samir")
                .build();

        System.out.println(user.getName());
    }

    public User(UserBuilder builder) {
        this.id = builder.getId();
        this.name = builder.getName();
        this.surname = builder.getSurname();
        this.age = builder.getAge();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Long getAge() {
        return age;
    }


    public static class UserBuilder {

        private Long id;
        private String name;
        private String surname;
        private Long age;

        public UserBuilder age(Long age) {
            this.age = age;
            return this;
        }

        public UserBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public UserBuilder name(String name) {
            this.name = name;
            return this;
        }

        public UserBuilder surname(String surname) {
            this.surname = surname;
            return this;
        }


        public User build() {
            return new User(this);
        }

        public Long getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getSurname() {
            return surname;
        }

        public Long getAge() {
            return age;
        }
    }

}
