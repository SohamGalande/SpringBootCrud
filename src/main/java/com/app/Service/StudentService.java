package com.app.Service;

import com.app.Dto.StudentDTO;

import java.util.List;

public interface StudentService {
    List<StudentDTO> getAllStudents();

    StudentDTO getStudentById(long id);

    StudentDTO createStudent(StudentDTO studentDTO);

    StudentDTO updateStudent(long id, StudentDTO studentDTO);

    void deleteStudent(long id);
}
