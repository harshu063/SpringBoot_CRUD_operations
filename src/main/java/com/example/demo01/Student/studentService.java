package com.example.demo01.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class studentService {

    private final studentRepository studentRepository;

    @Autowired
    public studentService(studentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<student> getStudents() {
        return studentRepository.findAll();


    }

    public void addNewStudent(student student) {
        Optional<student> studentByEmail = studentRepository.findstudentByEmail(student.getEmail());
        if(studentByEmail.isPresent()){
            throw new IllegalStateException("email taken");
        }
        studentRepository.save(student);
    }

    public void deleteStudent(Long studentId) {
       boolean exists= studentRepository.existsById(studentId);
       if (!exists){
           throw new IllegalStateException("student with Id"+ studentId+ "Id doesnt exists");
       }
       studentRepository.deleteById(studentId);
    }
}
