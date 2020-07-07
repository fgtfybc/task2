package com.jnshu.pojo;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;

@Component
public class Student {

    @NotBlank(message = "姓名不能为空")
    private String name;
    private long qq;
    private String subject;
    private long joinTime;
    private String school;
    private long id;
    private String wish;
    private String instructor;
    private String knowFrom;
    private long createAt;
    private long updateAt;

    public Student(){
    }

    public Student(String name, long qq, String subject, long joinTime, String school, long id, String wish, String instructor, String knowFrom, long createAt, long updateAt) {
        this.name = name;
        this.qq = qq;
        this.subject = subject;
        this.joinTime = joinTime;
        this.school = school;
        this.id = id;
        this.wish = wish;
        this.instructor = instructor;
        this.knowFrom = knowFrom;
        this.createAt = createAt;
        this.updateAt = updateAt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getQq() {
        return qq;
    }

    public void setQq(long qq) {
        this.qq = qq;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public long getJoinTime() {
        return joinTime;
    }

    public void setJoinTime(long joinTime) {
        this.joinTime = joinTime;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getWish() {
        return wish;
    }

    public void setWish(String wish) {
        this.wish = wish;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public String getKnowFrom() {
        return knowFrom;
    }

    public void setKnowFrom(String knowFrom) {
        this.knowFrom = knowFrom;
    }

    public long getCreateAt() {
        return createAt;
    }

    public void setCreateAt(long createAt) {
        this.createAt = createAt;
    }

    public long getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(long updateAt) {
        this.updateAt = updateAt;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", qq=" + qq +
                ", subject='" + subject + '\'' +
                ", joinTime=" + joinTime +
                ", school='" + school + '\'' +
                ", id=" + id +
                ", wish='" + wish + '\'' +
                ", instructor='" + instructor + '\'' +
                ", knowFrom='" + knowFrom + '\'' +
                ", createAt=" + createAt +
                ", updateAt=" + updateAt +
                '}';
    }
}