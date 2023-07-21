package com.project.springbootrestapi.controller;

import com.project.springbootrestapi.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.Style;
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
    /*
    //Using ResponseEntity
    @GetMapping("student")  //returns java bean as JSON
    public ResponseEntity<Student> getStudent(){
        Student student=new Student(1,"Jiggy","Shah");
        return new ResponseEntity<>(student,HttpStatus.OK);
        return ResponseEntity.ok(student);//either way both are same
    }
*/


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
    //http://localhost:8080/students/query?id=1&firstName=Jiggy&lastName=Giri

    @GetMapping("students/query")
    public Student studentRequestVariable(@RequestParam int id,@RequestParam String firstName, @RequestParam String lastName){
       return new Student(id, firstName,lastName);
    }

    //Spring Boot REST API that handles HTTP POST Request - creating new resource
    //@PostMapping and @RequestBody
    @PostMapping("students/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Student  createStudent(@RequestBody Student student){
        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return student;
    }


    //Spring Boot REST API that handles HTTP PUT Request - updating existing resource
    @PutMapping("students/{id}/update")
    public Student updateStudent(@RequestBody Student student,@PathVariable("id") int studentId){
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return student;
    }

    //Spring Boot REST API that handles HTTP DELETE Request - delete existing resource
@DeleteMapping("students/{id}/delete")
    public String deleteStudent(@PathVariable("id") int studentId){
    System.out.println(studentId);
       return  "Student deleted successfully";
    }

}
