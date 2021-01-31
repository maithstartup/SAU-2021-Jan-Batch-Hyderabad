package com.auspring.kafka.demo.model;

public class Teacher {
    private long teacherId;
    private String teacherName;
    private String teacherDesig;

    public Teacher() {
    }

    public Teacher(long teacherId, String teacherName, String teacherDesig) {
        this.teacherId = teacherId;
        this.teacherName = teacherName;
        this.teacherDesig = teacherDesig;
    }

    public long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(long teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getTeacherDesig() {
        return teacherDesig;
    }

    public void setTeacherDesig(String teacherDesig) {
        this.teacherDesig = teacherDesig;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "teacherId=" + teacherId +
                ", teacherName='" + teacherName + '\'' +
                ", teacherDesig='" + teacherDesig + '\'' +
                '}';
    }
}
