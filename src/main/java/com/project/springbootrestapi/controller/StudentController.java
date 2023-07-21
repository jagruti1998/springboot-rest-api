package com.project.springbootrestapi.controller;

import com.project.springbootrestapi.bean.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    //http://localhost:8080/student
   @GetMapping("student")  //returns java bean as JSON
    public Student getStudent(){
        Student student=new Student(1,"Jiggy","Shah");
        return student;
    }

    //http://localhost:8080/students
    @GetMapping("students")
    public List<Student> getStudents(){  //returns list as JSON
        List<Student> students=new ArrayList<>();
        students.add(new Student(1,"piku","k"));
        students.add(new Student(2,"tinu","DK"));
        students.add(new Student(3,"RK","G"));
        return students;

    }

    //Spring boot REST API with PathVariable
    //{id}-URI template variable
    //http://localhost:8080/students/1
    @GetMapping("students/{id}/{first-Name}")
    public Student studentPathVariable(@PathVariable("id") int studentId,@PathVariable("first-Name") String firstName){
       return new Student(studentId,firstName,"JAd");

    }

    //Spring Boot REST API with Request Param
    //http://localhost:8080/students/query?id=1
    //http://localhost:8080/students/query?id=1
    @GetMapping("students/query")
    public Student studentRequestVariable(@RequestParam int id){
       return new Student(id, "Remm","KK");
    }

}
