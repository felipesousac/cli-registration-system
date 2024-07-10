package com.projeto.entity;

public class User {

    private String name;
    private String email;
    private String age;
    private String height;

    public User(String name, String email, String height, String age) {
        this.name = name;
        this.email = email;
        this.height = height;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getAge() {
        return age;
    }

    public String getHeight() {
        return height;
    }

    @Override
    public String toString() {
        return "===" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", age='" + age + '\'' +
                ", height='" + height + '\'' +
                "===";
    }
}
