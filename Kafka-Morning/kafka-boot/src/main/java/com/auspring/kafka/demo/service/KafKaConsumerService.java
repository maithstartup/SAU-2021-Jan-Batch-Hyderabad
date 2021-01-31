package com.auspring.kafka.demo.service;

import com.auspring.kafka.demo.model.Assignment;
import com.auspring.kafka.demo.model.Student;
import com.auspring.kafka.demo.model.Teacher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.auspring.kafka.demo.common.AppConstants;

@Service
public class KafKaConsumerService 
{
	private final Logger logger 
		= LoggerFactory.getLogger(KafKaConsumerService.class);

	@KafkaListener(topics = AppConstants.TOPIC_NAME_STUDENT, groupId = AppConstants.GROUP_ID)
	public void consume(Student student) {
		logger.info(String.format("Student created -> %s", student));
	}

	@KafkaListener(topics = AppConstants.TOPIC_NAME_TEACHER, groupId = AppConstants.GROUP_ID)
	public void consume(Teacher teacher) {
		logger.info(String.format("Teacher created -> %s", teacher));
	}

	@KafkaListener(topics = AppConstants.TOPIC_NAME_ASSIGNMENT, groupId = AppConstants.GROUP_ID)
	public void consume(Assignment assignment) {
		logger.info(String.format("Assignment created -> %s", assignment));
	}
}
