package com.adscripcion.controller;

import java.util.List;

import com.adscripcion.model.Student;
import com.adscripcion.service.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
    
    @Autowired
    private StudentService personService;

    @GetMapping("/students")
    public List<Student> getPersons() {
        
        return personService.getPersons();
    }

    @PostMapping("/student/save")
    public String save(@RequestBody Student person) {
        String message = "";
        try {
            personService.save(person);
            message  = "Successfully saved!";

        } catch (Exception e) {
           message = e.getMessage();
        }
        return message;
    }

    @DeleteMapping("/student/deleted/{studentId}")
    public String delete(@PathVariable("studentId") Long studentId) {
        String message = "";
        try {
            personService.delete(studentId);
            message  = "Successfully deleted!";

        } catch (Exception e) {
           message = e.getMessage();
        }
        return message;
    }

    @PutMapping("/student/update/{studentId}")
    public String update(@PathVariable("studentId") Long studentId,
                         @RequestParam (required = false) String name,
                         @RequestParam (required = false) String email){
        String message = "";
        try {
            personService.update(studentId,name,email);
            message  = "Successfully updated person!";
        } catch (Exception e) {
            message = e.getMessage();
        }                    

        return message;
    }

}
