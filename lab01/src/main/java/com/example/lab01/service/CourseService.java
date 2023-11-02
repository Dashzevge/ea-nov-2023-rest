package com.example.lab01.service;

import com.example.lab01.entity.Course;
import com.example.lab01.entity.Student;
import com.example.lab01.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {
    private final CourseRepository courseRepository;
    public List<Course> findAll(){
        return courseRepository.findAll();
    }
    public Optional<Course> findById(int id){
        return courseRepository.findById(id);
    }

    public void addCourse(Course course){
        courseRepository.addCourse(course);
    }
    public void updateCourseById(int id, Course course){
        courseRepository.updateCourse(id,course);
    }
    public void deleteCourseById(int id){
        courseRepository.deleteCourse(id);
    }
    public CourseService(final CourseRepository courseRepository){
        this.courseRepository = courseRepository;
    }
}
