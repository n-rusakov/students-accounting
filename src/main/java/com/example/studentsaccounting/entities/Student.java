package com.example.studentsaccounting.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.text.MessageFormat;

@Getter
@AllArgsConstructor
public class Student {
    private int id;

    private String firstName;
    private String lastName;
    private int age;

    @Override
    public String toString() {
        return MessageFormat.format("{0} {1}, {2}",firstName, lastName, age);
    }


}
