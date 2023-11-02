package com.example.lab01.controller;

import com.example.lab01.entity.Course;
import com.example.lab01.entity.Student;
import com.example.lab01.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping({"/students"})
public class StudentController {

    private final StudentService studentService;

    public StudentController(final StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> findAll() {
        return this.studentService.findAll();
    }

    @GetMapping("/getStudentsByMajor")
    public List<Student> findByMajor(@RequestParam String major) {
        return this.studentService.getCoursesByMajor(major);
    }

    @GetMapping("/getCoursesByStudentId")
    public List<Course> findByStudentId(@RequestParam int studentId) {
        return this.studentService.getCoursesByStudentId(studentId);
    }

    @GetMapping("/{id}")
    public Optional<Student> findById(@PathVariable int id) {
        return this.studentService.findById(id);
    }

    @PostMapping
    public void save(@RequestBody Student student) {
        this.studentService.addStudent(student);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id) {
        this.studentService.deleteStudentById(id);
    }

    @PutMapping("/{id}")
    public void update(@RequestBody Student student,
                       @PathVariable int id) {
        this.studentService.updateStudentById(id, student);
    }
}
