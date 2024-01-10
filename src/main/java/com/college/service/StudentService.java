package com.college.service;

import java.util.List;

import com.college.bean.StudentEntity;


public interface StudentService 
{
	StudentEntity save(StudentEntity student);
	StudentEntity update(StudentEntity student);
	StudentEntity get(Long id);
	List<StudentEntity>getAll();
	

}
