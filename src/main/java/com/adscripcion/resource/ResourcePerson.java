package com.adscripcion.resource;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import com.adscripcion.model.Student;

public class ResourcePerson {
    

    public List<Student> getPersons() {
        Student p1= new Student();
        Student p2= new Student();
        Student p3= new Student();

       
        p1.setName("Marcos");
        p1.setEmail("marc@adscripcion.org");
        p1.setBirthDate(LocalDate.of(2000,Month.FEBRUARY,23));
       
        p2.setName("lukas");
        p2.setEmail("luk@adscripcion.es");
        p2.setBirthDate(LocalDate.of(2010,Month.DECEMBER,2));
      
        p3.setName("tedy");
        p3.setEmail("tedy@gmail.org");
        p3.setBirthDate(LocalDate.of(2020,Month.JANUARY,15));
        return List.of(p1,p2,p3);
    }
}
