package com.liferay.service;

import com.liferay.model.Student;
import com.liferay.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    public Student addStudent(Student student){
        return studentRepository.save(student);
    }

    public Boolean updateStudent(Student student,Long studentId){
        Optional<Student> oldStudent=studentRepository.findById(studentId);
        if(oldStudent.isPresent()){
            Student studentToUpdate=oldStudent.get();
            studentToUpdate.setStudentName(student.getStudentName());
            studentToUpdate.setStudentERP(student.getStudentERP());
            studentToUpdate.setStudentGPA(student.getStudentGPA());
            studentToUpdate.setStudentEmail(student.getStudentEmail());
            studentRepository.save(studentToUpdate);
            return true;
        }
        return false;
    }

    public Boolean deleteStudent(Long studentId){
        Student student=studentRepository.findById(studentId).orElse(null);
        if (student!=null){
            studentRepository.deleteById(studentId);
            return true;
        }
        return false;
    }
}
