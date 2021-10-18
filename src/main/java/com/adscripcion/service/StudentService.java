package com.adscripcion.service;

import java.util.List;
import com.adscripcion.model.Student;
import com.adscripcion.repository.StudentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository personRepository;
    
    public List<Student> getPersons() {
        
        return personRepository.findAll();
    }

    public void save(Student person) {
        personRepository.save(person);
    }

    public void delete(Long personId) {
        personRepository.deleteById(personId);
    }

    @Transactional
    public void update(Long personId, String name, String email) {
        Student person = personRepository.findById(personId).orElseThrow(
          () -> new IllegalStateException("Person with id "+personId+" does not exist")  
        );
        person.setName(name);
        person.setEmail(email);
    }
    
}
