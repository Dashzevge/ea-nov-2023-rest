package com.example.lab01.controller;

import com.example.lab01.entity.Course;
import com.example.lab01.service.CourseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/courses")
@Api(tags = "Course API")
public class CourseController {

    private final CourseService courseService;

    public CourseController(final CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    @ApiOperation("Get a list of all courses")
    public List<Course> findAll() {
        return this.courseService.findAll();
    }

    @GetMapping("/{id}")
    @ApiOperation("Get course by ID")
    public Optional<Course> findById(@PathVariable @ApiParam("Course ID") int id) {
        return this.courseService.findById(id);
    }

    @PostMapping
    @ApiOperation("Add a new course")
    public void save(@RequestBody @ApiParam("Course details") Course course) {
        this.courseService.addCourse(course);
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Delete course by ID")
    public void deleteById(@PathVariable @ApiParam("Course ID") int id) {
        this.courseService.deleteCourseById(id);
    }

    @PutMapping("/{id}")
    @ApiOperation("Update course by ID")
    public void update(@RequestBody @ApiParam("Updated course details") Course course,
                       @PathVariable @ApiParam("Course ID") int id) {
        this.courseService.updateCourseById(id, course);
    }
}
