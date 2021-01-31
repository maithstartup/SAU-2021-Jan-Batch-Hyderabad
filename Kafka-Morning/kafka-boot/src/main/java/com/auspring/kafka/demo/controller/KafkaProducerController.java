package com.auspring.kafka.demo.controller;

import com.auspring.kafka.demo.model.Assignment;
import com.auspring.kafka.demo.model.Student;
import com.auspring.kafka.demo.model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.auspring.kafka.demo.service.KafKaProducerService;

import java.util.Date;

@RestController
@RequestMapping(value = "/api")
public class KafkaProducerController {
	private final KafKaProducerService producerService;
	private static int rank = 0;

	@Autowired
	public KafkaProducerController(KafKaProducerService producerService) {
		this.producerService = producerService;
	}

	@PostMapping(value = "/student")
	public void createStudent(@RequestBody Student student) {
		this.producerService.saveStudent(student);
	}
	@PostMapping(value = "/teacher")
	public void createStudent(@RequestBody Teacher teacher) {
		this.producerService.saveTeacher(teacher);
	}
	@PostMapping(value = "/assignment")
	public void createStudent(@RequestBody Assignment assignment) {
		assignment.setSubmissionDate(new Date());
		assignment.setRank(++this.rank);
		this.producerService.saveAssignment(assignment);
	}
}
