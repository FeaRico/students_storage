package ru.makhach.studentsstorage.model;

public class Student {
    private final Long id;
    private final String firstName;
    private final String lastName;
    private final String middleName;
    private final String group;
    private final Integer age;

    private Student(Builder builder) {
        this.id = builder.id;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.middleName = builder.middleName;
        this.group = builder.group;
        this.age = builder.age;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Long id;
        private String firstName;
        private String lastName;
        private String middleName;
        private String group;
        private Integer age;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder middleName(String middleName) {
            this.middleName = middleName;
            return this;
        }

        public Builder group(String group) {
            this.group = group;
            return this;
        }

        public Builder age(Integer age) {
            this.age = age;
            return this;
        }

        public Student build() {
            return new Student(this);
        }
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getGroup() {
        return group;
    }

    public Integer getAge() {
        return age;
    }
}
