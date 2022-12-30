package com.driver;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    //1. adding student
    public void addStudentService(Student student){
        studentRepository.addStudentToDb(student);
    }
    //2.adding teacher
    public void addTeacherService(Teacher teacher){
        studentRepository.addTeacherToDb(teacher);
    }
    //3. adding pairs
    public void addStudentTeacherPairService(String student, String teacher){
        studentRepository.addStudentTeacherPairToDb(student, teacher);
    }
    //4. getting student
    public Student getStudentByNameService(String name){
        return studentRepository.getStudentByNameFromDb(name);
    }
    //5. getting teacher
    public Teacher getTeacherByNameService(String name){
        return studentRepository.getTeacherByNameFromDb(name);
    }
    //6. get students from teacher
    public List<String> getStudentsByTeacherNameService(String teacher){
        return studentRepository.getStudentsByTeacherNameFromDb(teacher);
    }
    //7. get all students
    public List<String> getAllStudentsService(){
        return studentRepository.getAllStudentsFromDb();
    }
    //8. delete a teacher and its student
    public void deleteTeacherByNameService(String teacher){
        studentRepository.deleteTeacherByNameFromDb(teacher);
    }
    //9. delete all teacher and student
    public void deleteAllTeachersService(){
        studentRepository.deleteAllTeachersFromDb();

    }
}
