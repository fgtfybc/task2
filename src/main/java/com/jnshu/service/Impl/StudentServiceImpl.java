package com.jnshu.service.Impl;

import com.jnshu.mapper.StudentMapper;
import com.jnshu.pojo.Student;
import com.jnshu.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class StudentServiceImpl implements StudentService {


    @Autowired
    StudentMapper studentMapper;

    @Override
    public int insertStudent(Student student) {
        return studentMapper.insertStudent(student);
    }

    @Override
    public boolean deleteStudent(long id) {
        return studentMapper.deleteStudent(id);
    }

    @Override
    public boolean updateStudent(Student student) {
        return studentMapper.updateStudent(student);
    }

    @Override
    public Student findStudentById(long id) {
        return studentMapper.findStudentById(id);
    }

    @Override
    public List<Student> findAllStudent() {
        return studentMapper.findAllStudent();
    }
}
