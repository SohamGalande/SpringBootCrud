package com.app.Service.Impl;

import com.app.Entity.Student;
import com.app.Dto.StudentDTO;
import com.app.Mapper.StudentMapper;
import com.app.Repository.StudentRepository;
import com.app.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<StudentDTO> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        return students.stream()
                .map(StudentMapper::studentToStudentDTO)
                .collect(Collectors.toList());
    }

    @Override
    public StudentDTO getStudentById(long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + id));
        return StudentMapper.studentToStudentDTO(student);
    }

    @Override
    public StudentDTO createStudent(StudentDTO studentDTO) {
        Student student = StudentMapper.studentDTOToStudent(studentDTO);
        student = studentRepository.save(student);
        return StudentMapper.studentToStudentDTO(student);
    }

    @Override
    public StudentDTO updateStudent(long id, StudentDTO studentDTO) {
        Student existingStudent = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + id));
        Student updatedStudent = StudentMapper.studentDTOToStudent(studentDTO);
        updatedStudent.setId(existingStudent.getId());
        updatedStudent = studentRepository.save(updatedStudent);
        return StudentMapper.studentToStudentDTO(updatedStudent);
    }

    @Override
    public void deleteStudent(long id) {
        studentRepository.deleteById(id);
    }
}
