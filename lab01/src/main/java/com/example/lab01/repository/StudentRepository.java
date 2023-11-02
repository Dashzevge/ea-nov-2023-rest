package com.example.lab01.repository;

import com.example.lab01.entity.Student;
import com.example.lab01.entity.Course;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class StudentRepository {
    static List<Student> students = new ArrayList();
    public List<Student> findAll() {
        return students;
    }
    public Optional<Student> findById(int id) {
        return students.stream().filter(student -> student.getId() == id).findFirst();
    }

    public List<Student> getStudentsByMajor(String major) {
        return students.stream()
                .filter(student -> student.getMajor().equalsIgnoreCase(major))
                .collect(Collectors.toList());
    }
    public List<Course> getCoursesByStudentId(int studentId) {
        Optional<Student> studentOptional = students.stream()
                .filter(student -> student.getId() == studentId)
                .findFirst();

        if (studentOptional.isPresent()) {
            return studentOptional.get().getCouresTaken();
        } else {
            return new ArrayList<>();
        }
    }

    public void addStudent(Student student) {
        students.add(student);
    }
    public void updateStudent(int id, Student updatedStudent) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == id) {
                students.set(i, updatedStudent);
                break;
            }
        }
    }
    public void deleteStudent(int id) {
        students.removeIf(student -> student.getId() == id);
    }


}
