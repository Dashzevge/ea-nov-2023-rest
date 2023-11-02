package com.example.lab01.repository;

import com.example.lab01.entity.Course;
import com.example.lab01.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class CourseRepository {

    static List<Course> courses = new ArrayList();

    public List<Course> findAll() {
        return courses;
    }
    public Optional<Course> findById(int id) {
        return courses.stream().filter(course -> course.getId() == id).findFirst();
    }
    public void addCourse(Course course) {
        courses.add(course);
    }

    public void updateCourse(int id, Course updatedStudent) {
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getId() == id) {
                courses.set(i, updatedStudent);
                break;
            }
        }
    }

    public void deleteCourse(int id) {
        courses.removeIf(course -> course.getId() == id);
    }

}
