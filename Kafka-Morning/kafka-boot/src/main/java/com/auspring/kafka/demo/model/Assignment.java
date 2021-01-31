package com.auspring.kafka.demo.model;

import java.util.Date;

public class Assignment {
    private long studentId;
    private String studentName;
    private Date submissionDate;
    private int rank;

    public Assignment() {
    }

    public Assignment(long studentId, String studentName, Date submissionDate) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.submissionDate = submissionDate;
    }

    public Assignment(long studentId, String studentName, Date submissionDate, int rank) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.submissionDate = submissionDate;
        this.rank = rank;
    }

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Date getSubmissionDate() {
        return submissionDate;
    }

    public void setSubmissionDate(Date submissionDate) {
        this.submissionDate = submissionDate;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "Assignment{" +
                "studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", submissionDate=" + submissionDate +
                ", rank=" + rank +
                '}';
    }
}
