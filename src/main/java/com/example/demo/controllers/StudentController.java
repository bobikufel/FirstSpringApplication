
package com.example.demo.controllers;

import com.example.demo.entities.Student;
import com.example.demo.repositories.StudentRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pierwszaAplikacja")
public class StudentController {
    
    @Autowired
    StudentRepository studentRepository;
    Integer wiek;
    @GetMapping("/students")
    public List<Student> getAllNotes() {
        return studentRepository.findAll();
    }
    
    @GetMapping("/students/ages")
    public List<Integer> getAllAges() {
        List<Student> students = studentRepository.findAll();
        List<Integer> ages = new ArrayList();
        for(int i=0;i<students.size();i++)
        {
            ages.add(students.get(i).getAge());
        }
        return ages;
    }

     @GetMapping("/students/names")
    public List<String> getAllStrings() {
        List<Student> students = studentRepository.findAll();
        List<String> names = new ArrayList();
        for(int i=0;i<students.size();i++)
        {
            names.add(students.get(i).getName());
        }
        return names;
    }

}
