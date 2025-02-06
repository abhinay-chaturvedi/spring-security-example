package com.chaturvedi.spring_security_example.controller;

import com.chaturvedi.spring_security_example.model.Student;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class Hello {

    List<Student> students = new ArrayList<>(List.of(
            new Student(1, "abhinay", 50),
            new Student(2, "anuj", 60),
            new Student(3, "ravi", 70)
            ));
    @RequestMapping("")
    public String greet(HttpServletRequest request) {
        return "HI there." + request.getSession().getId();
    }
    @RequestMapping("/private")
    public String admin() {
        return "This is private route";
    }
    @GetMapping("/students")
    List<Student> getUsers() {
        return this.students;
    }
    @PostMapping("/students")
    Student addStudent(@RequestBody Student student) {
        students.add(student);
        return student;
    }
    @GetMapping("/csrf-token")
    CsrfToken getToken(HttpServletRequest request) {
        return (CsrfToken) request.getAttribute("_csrf");
    }
}
