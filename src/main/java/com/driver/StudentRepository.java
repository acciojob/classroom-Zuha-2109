package com.driver;

import org.springframework.stereotype.Repository;

import java.util.*;
//import java.util.HashMap;
//import java.util.List;


@Repository
public class StudentRepository {

    public HashMap<String, Student> studentMap = new HashMap<>();
    public HashMap<String, Teacher> teacherMap = new HashMap<>();

    public HashMap<String, List<String>> StudentTeacherpair = new HashMap<>();

    //1.adding student
    public void addStudentToDb(Student student){
        studentMap.put(student.getName(), student);
    }

    //2.adding teacher
    public void addTeacherToDb(Teacher teacher){
        teacherMap.put(teacher.getName(), teacher);
    }

    //3.pairing student and teacher
    public void addStudentTeacherPairToDb(String student, String teacher){

        if(studentMap.containsKey(student)&&teacherMap.containsKey(teacher)){

            List<String> StudentAndTeacher = new ArrayList<>();

            if(StudentTeacherpair.containsKey(teacher))
                StudentAndTeacher = StudentTeacherpair.get(teacher);
            StudentAndTeacher.add(student);

            StudentTeacherpair.put(teacher, StudentAndTeacher);

        }
    }

    //4.get student by student name
    public Student getStudentByNameFromDb(String student){
        return studentMap.get(student);
    }

    //5.get teacher by teacher name
    public Teacher getTeacherByNameFromDb(String teacher){
        return teacherMap.get(teacher);
    }

    //6.get student by teacher name
    public List<String> getStudentsByTeacherNameFromDb(String teacher){
        List<String> student = new ArrayList<>();

        if(StudentTeacherpair.containsKey(teacher)) student = StudentTeacherpair.get(teacher);
        return student;
    }

    //7.get list of all students added
    public List<String> getAllStudentsFromDb(){
        return new ArrayList<>(studentMap.keySet());
    }

    //8. delete a teacher and its student
    public void deleteTeacherByNameFromDb(String teacher){

        List<String> students = new ArrayList<String>();
        //find student name by teacher from pair
        if(StudentTeacherpair.containsKey(teacher)){
            students = StudentTeacherpair.get(teacher);

            // deleting all the students from studentMap by using student
            for(String student: students){
                if(studentMap.containsKey(student)){
//                    studentMap.remove(student);
                }
            }
            //deleting student and teacher pair
            StudentTeacherpair.remove(teacher);

        }
        //deleting teacher from teacherMap
        if(teacherMap.containsKey(teacher)){
            teacherMap.remove(teacher);
        }

    }

    //9.delete all teacher and student
    public void deleteAllTeachersFromDb(){
        List<String> list = new ArrayList<>();

        //finding all students by teachers combined
        for(String teacher: StudentTeacherpair.keySet()){

            //iterating in list of students by teacher
            for(String student: StudentTeacherpair.get(teacher)){
                list.add(student);
            }

        }
        //deleting the student from studentMap
        for(String student: list){
            if(studentMap.containsKey(student)){
                studentMap.remove(student);
            }
        }
        //clearing the pairs
        StudentTeacherpair = new HashMap<>();
    }

}
