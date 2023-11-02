package com.example.lab01.service;

import com.example.lab01.entity.Course;
import com.example.lab01.entity.Student;
import com.example.lab01.repository.StudentRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public List<Student> findAll(){
        return studentRepository.findAll();
    }

    public Optional<Student> findById(int id){
        return studentRepository.findById(id);
    }

    public List<Course> getCoursesByStudentId(int studentId){
        return studentRepository.getCoursesByStudentId(studentId);
    }

    public List<Student> getCoursesByMajor(String major){
        return studentRepository.getStudentsByMajor(major);
    }

    public void addStudent(Student student){
        studentRepository.addStudent(student);
    }

    public void updateStudentById(int id, Student student){
        studentRepository.updateStudent(id,student);
    }

    public void deleteStudentById(int id){
        studentRepository.deleteStudent(id);
    }

    public StudentService(final StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }
}
