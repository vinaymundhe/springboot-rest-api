package com.flygenmedia.springboot.controller;

import com.flygenmedia.springboot.bean.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

//    http://localhost:8080/student
    @GetMapping("student")
    public Student getStudent(){
        Student student = new Student(
                1,
                "Vinay",
                "Mundhe"
        );
        return student;
    }

    //    http://localhost:8080/students
    @GetMapping("students")
    public List<Student> getStudents(){
        List<Student> students = new ArrayList<>();
        students.add(new Student(1,"Vinay","Mundhe"));
        students.add(new Student(2,"Tom","Cruise"));
        students.add(new Student(3, "Shah Rukh", "Khan"));
        students.add(new Student(4, "Cristiano", "Ronaldo"));
        return students;
    }

//    Spring Boot REST API with Path Variable
//    {id} - URI Template Variable
//    http://localhost:8080/students/1
    @GetMapping("students/{id}")
    public Student studentPathVariable(@PathVariable("id") int studentId){
        return new Student(studentId, "Ramesh", "Pawar");
    }
}
