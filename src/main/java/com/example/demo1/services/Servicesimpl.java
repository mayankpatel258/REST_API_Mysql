package com.example.demo1.services;

import com.example.demo1.dao.Course;
import com.example.demo1.repository.CourseRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Servicesimpl implements CourseService{
    //List<Course> list;
    @Autowired
   private CourseRepository courseRepository;

    @Override
    public List<Course> getCourses() {
        return courseRepository.findAll();
       // return list;
    }

    @Override
    public Optional<Course> getCourses(long id) {
        return courseRepository.findById(id);
//        Course course=null;
//        for(Course c:list){
//            if(c.getId()==id){
//                course=c;
//                break;
//            }
//        }
//        return course;
    }

    @Override
    public Course addCourses(Course course) {
//         list.add(course);
        courseRepository.save(course);
         return course;
    }

    @Override
    public void deleteCourse(long id) {

        courseRepository.deleteById(id);
//        list=this.list.stream().filter(e->e.getId()!=id).collect(Collectors.toList());
    }

    @Override
   public Course updateCourse(Course course){
//        list.forEach(e->{
//            if(e.getId()==course.getId()){
//                e.setName(course.getName());
//                e.setDescription(course.getDescription());
//            }
//        });
        courseRepository.save(course);
        return course;
   }
}
