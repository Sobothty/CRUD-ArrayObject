package model;

import java.util.Arrays;
import java.util.Scanner;

public class Person {
    private final Integer id;
    private final String name;
    private final Gender gender;

    public Integer getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    public Person(Integer id, String name, Gender gender) {
        this.id = id;
        this.name = name;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "User {" + "\n" +
                "\tID = " + id + "\n" +
                "\tName = " + name + "\n" +
                "\tGender = " + gender + "\n" +
                '}';
    }}



