package com.liferay.controller;

import com.liferay.model.Student;
import com.liferay.service.StudentService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/students")
public class StudentController {
    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    @GetMapping()
    public ResponseEntity<List<Student>> getAllStudents(){

        List<Student> students=studentService.getAllStudents();

        return new ResponseEntity<>(students, HttpStatus.OK);
    }
    @PostMapping()
    public ResponseEntity<Student> addStudent(@RequestBody Student student){
        Student studentDetails =studentService.addStudent(student);
        return new ResponseEntity<>(studentDetails,HttpStatus.CREATED);
    }

    @PutMapping("/{studentId}")
    public ResponseEntity<String> updateStudent(@RequestBody Student student,@PathVariable("studentId")Long studentId){
        if(studentService.updateStudent(student,studentId)){

            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>("Student Not Found ",HttpStatus.NOT_FOUND);
    }
   @DeleteMapping("/{studentId}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long studentId){
       if(studentService.deleteStudent(studentId)){

           return new ResponseEntity<>(HttpStatus.OK);
       }
       return new ResponseEntity<>("Student Not Found ",HttpStatus.NOT_FOUND);
    }


}
