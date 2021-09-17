package com.neeladri.demoProjectForMongoDB.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.neeladri.demoProjectForMongoDB.model.Student;
import com.neeladri.demoProjectForMongoDB.service.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentController {
    
    @Autowired
    StudentService studentService;

    // Crud Operations Using MongoDB Template
    @PostMapping("/")
    public Student save(@RequestBody Student student){
        return studentService.save(student);
    }

    @GetMapping("/")
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    } 

    @PutMapping("/")
    public Student changeStudent(@RequestBody Student student){
        return studentService.changeStudent(student);
    }

    @DeleteMapping("/")
    public Map<String,Long> deleteStudent(@RequestParam(value = "studentid") String id){
        Map<String,Long> response = new HashMap<>();
        response.put("The Number Of Deleted Documents", studentService.deleteStudent(id));
        return response;
    }
    // _________________________________________________________________________________________

    // Getting Students that are above a certain salary range(Implemented in the Repository Layer)
    @GetMapping("/getStudent/")
    public List<Student> getStudentBySalary(@RequestParam(value ="studentsalary") long salary){
        return studentService.getStudentBySalary(salary);
    }
}
