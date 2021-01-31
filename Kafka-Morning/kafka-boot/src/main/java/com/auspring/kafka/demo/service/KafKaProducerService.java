package com.auspring.kafka.demo.service;

import com.auspring.kafka.demo.model.Assignment;
import com.auspring.kafka.demo.model.Student;
import com.auspring.kafka.demo.model.Teacher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.auspring.kafka.demo.common.AppConstants;

import java.util.ArrayList;
import java.util.List;

@Service
public class KafKaProducerService 
{
	private static final Logger logger = LoggerFactory.getLogger(KafKaProducerService.class);
	private static List<Student> studentList = new ArrayList<>();
	private static List<Teacher> teacherList = new ArrayList<>();
	private static List<Assignment> assignmentList = new ArrayList<>();
	private static int rank = 0;
	
	@Autowired
	private KafkaTemplate<String, Object> kafkaTemplate;

	public void saveStudent(Student student)
	{
		logger.info(String.format("Student created -> %s", student));
		studentList.add(student);
		this.kafkaTemplate.send(AppConstants.TOPIC_NAME_STUDENT, student);
	}
	public void saveTeacher(Teacher teacher)
	{
		logger.info(String.format("Teacher created -> %s", teacher));
		teacherList.add(teacher);
		this.kafkaTemplate.send(AppConstants.TOPIC_NAME_TEACHER, teacher);
	}
	public void saveAssignment(Assignment assignment)
	{
		logger.info(String.format("Assignment created -> %s", assignment));
		assignmentList.add(assignment);
		this.kafkaTemplate.send(AppConstants.TOPIC_NAME_ASSIGNMENT, assignment);
	}
}