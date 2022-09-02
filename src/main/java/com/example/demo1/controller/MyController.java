package com.example.demo1.controller;

import com.example.demo1.dao.Course;
import com.example.demo1.services.Servicesimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class MyController {
    @Autowired
    private Servicesimpl course;
    @GetMapping("/home")
    public String home(){
        return "Welcome to springboot project";
    }
    //get list of course



    @GetMapping("/courses")
    public List<Course> getCourses(){
        return course.getCourses();
    }
    @GetMapping("/courses/{id}")
    public Optional<Course> getCourses(@PathVariable String id){
        return course.getCourses(Long.parseLong(id));
    }
    @PostMapping("/courses")
    public Course addCourses(@RequestBody Course coursedto)
    {
        return course.addCourses(coursedto);
    }
    @PutMapping("/courses")
    public Course updateCourse(@RequestBody Course coursedto){
        return course.updateCourse(coursedto);
    }

    @DeleteMapping("/courses/{id}")
    public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String id){
        try{
            course.deleteCourse(Long.parseLong(id));
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
