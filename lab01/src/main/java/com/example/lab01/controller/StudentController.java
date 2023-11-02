package com.example.lab01.controller;

import com.example.lab01.entity.Course;
import com.example.lab01.entity.Student;
import com.example.lab01.service.StudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping({"/students"})
@Api(tags = "Student API")
public class StudentController {

    private final StudentService studentService;

    public StudentController(final StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    @ApiOperation("Get a list of all students")
    public List<Student> findAll() {
        return this.studentService.findAll();
    }

    @GetMapping("/getStudentsByMajor")
    @ApiOperation("Get students by major")
    public List<Student> findByMajor(@RequestParam @ApiParam("Major name") String major) {
        return this.studentService.getCoursesByMajor(major);
    }

    @GetMapping("/getCoursesByStudentId")
    @ApiOperation("Get courses by student ID")
    public List<Course> findByStudentId(@RequestParam @ApiParam("Student ID") int studentId) {
        return this.studentService.getCoursesByStudentId(studentId);
    }

    @GetMapping("/{id}")
    @ApiOperation("Get student by ID")
    public Optional<Student> findById(@PathVariable @ApiParam("Student ID") int id) {
        return this.studentService.findById(id);
    }

    @PostMapping
    @ApiOperation("Add a new student")
    public void save(@RequestBody @ApiParam("Student details") Student student) {
        this.studentService.addStudent(student);
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Delete student by ID")
    public void deleteById(@PathVariable @ApiParam("Student ID") int id) {
        this.studentService.deleteStudentById(id);
    }

    @PutMapping("/{id}")
    @ApiOperation("Update student by ID")
    public void update(@RequestBody @ApiParam("Updated student details") Student student,
                       @PathVariable @ApiParam("Student ID") int id) {
        this.studentService.updateStudentById(id, student);
    }
}
