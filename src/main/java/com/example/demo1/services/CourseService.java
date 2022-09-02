package com.example.demo1.services;

import com.example.demo1.dao.Course;
import com.example.demo1.dao.Course;

import java.util.List;
import java.util.Optional;

public interface CourseService {
    public List<Course> getCourses();
    public Optional<Course> getCourses(long id);
   public Course  addCourses(Course course);
   public void deleteCourse(long id);

   public Course updateCourse(Course course);
}
