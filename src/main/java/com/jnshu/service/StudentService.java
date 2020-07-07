package com.jnshu.service;

import com.jnshu.mapper.StudentMapper;
import com.jnshu.pojo.Student;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
public interface StudentService  {


    public int insertStudent(Student student);



    public boolean deleteStudent(long id);



    public boolean updateStudent(Student student) ;


    public Student findStudentById(long id);


    public List<Student> findAllStudent();


}
