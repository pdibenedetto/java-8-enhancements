package com.hh.test;

import com.hh.test.model.Student;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

public class Streams
{
    @Getter
    @Setter
    private List<Student> studentList;

    public Streams(){this.buildStudentsCollection();}

    private void buildStudentsCollection()
    {
        studentList = new ArrayList<Student>();
        studentList.add(new Student("Adam"));
        studentList.add(new Student("Ace"));
        studentList.add(new Student("Mike"));
        studentList.add(new Student("Paul"));
        studentList.add(new Student("Jimmy"));
        studentList.add(new Student("Ashley"));
    }

}
