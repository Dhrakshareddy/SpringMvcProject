package com.college.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.college.bean.StudentEntity;
import com.college.repository.StudentRepository;
@Service
public class StudentServiceImpl  implements StudentService{
	private static Logger log=LoggerFactory.getLogger(StudentServiceImpl.class.getSimpleName());
	
	@Autowired
	private StudentRepository studentRepository;

	@Override
	public StudentEntity save(StudentEntity student) {
		studentRepository.save(student);
		return student;
	}

	@Override
	public StudentEntity update(StudentEntity student) {
		studentRepository.update(student);
		return student;
	}

	@Override
	public StudentEntity get(Long id) {
		Optional<StudentEntity> person = studentRepository.get(id);
		StudentEntity personEntity = person
				.orElseThrow(() -> new IllegalArgumentException("Recored not found"));
		return personEntity;
	}


	@Override
	public List<StudentEntity> getAll() {
		List<StudentEntity>student=studentRepository.getAll();
		return student;
	}


	

}
