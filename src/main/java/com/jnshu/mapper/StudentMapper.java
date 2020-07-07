package com.jnshu.mapper;

import com.jnshu.pojo.Student;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentMapper {

    /**
     * 添加学生数据
     * @param student
     * @return student
     */
    int insertStudent(Student student);

    /**
     * 根据名字删除学生数据
     * @param id
     * @return name
     */
    boolean deleteStudent(long id);

    /**
     * 更新学生数据
     * @param student
     * @return student
     */
    boolean updateStudent(Student student);

    /**
     * 根据id查询学生数据
     * @param id
     * @return id
     */
    Student findStudentById(long id);

    /**
     * 查询所有学生数据
     * @return list
     */
    List<Student> findAllStudent();

 /*   //分页
    List<Student> studentPage(@Param("startNum") int first , @Param("pageSize") int second);

    //数据库里总共有多少条数据
    int selectCount();*/
}

