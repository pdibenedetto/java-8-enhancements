package com.hh.test.model;

import lombok.*;

//@AllArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class Student
{
    @Getter @Setter private String name;

    public Student(String name)
    {
        this.name = name;
    }
}
