package com.example.lab01.controller;

import com.example.lab01.entity.Course;
import com.example.lab01.entity.Student;
import com.example.lab01.service.CourseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping({"/courses"})
public class CourseController {

    private final CourseService courseService;

    @GetMapping
    public List<Course> findAll() {
        return this.courseService.findAll();
    }

    @GetMapping({"/{id}"})
    public Optional<Course> findById(@PathVariable int id) {
        return this.courseService.findById(id);
    }

    @PostMapping
    public void save(@RequestBody Course course) {
        this.courseService.addCourse(course);
    }
    @DeleteMapping({"/{id}"})
    public void deleteById(@PathVariable int id) {
        this.courseService.deleteCourseById(id);
    }
    @PutMapping({"/{id}"})
    public void update(@RequestBody Course course, @PathVariable int id) {
        this.courseService.updateCourseById(id, course);
    }
    public CourseController(final CourseService courseService) {
        this.courseService = courseService;
    }
}
