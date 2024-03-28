package com.app.Mapper;

import com.app.Entity.Student;
import com.app.Dto.StudentDTO;

public class StudentMapper {

    public static StudentDTO studentToStudentDTO(Student student) {
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(student.getId());
        studentDTO.setFullName(student.getFull_name());
        studentDTO.setEmail(student.getEmail());
        studentDTO.setAddress(student.getAddress());
        studentDTO.setAge(student.getAge());
        return studentDTO;
    }

    public static Student studentDTOToStudent(StudentDTO studentDTO) {
        Student student = new Student();
        student.setId(studentDTO.getId());
        student.setFull_name(studentDTO.getFullName());
        student.setEmail(studentDTO.getEmail());
        student.setAddress(studentDTO.getAddress());
        student.setAge(studentDTO.getAge());
        return student;
    }
}
