package com.college.repository;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.college.bean.StudentEntity;

@Repository
@Transactional
public class StudentRepository 
{
	@Autowired
	private HibernateTemplate hibernetTemplate;
	
	public void save(StudentEntity student) {
		hibernetTemplate.save(student);
	}
	public void update(StudentEntity student) {
		hibernetTemplate.update(student);
	}
	public Optional<StudentEntity> get(Long id) {
		StudentEntity student = hibernetTemplate.get(StudentEntity.class, id);
		return Optional.ofNullable(student);
	}
	public List<StudentEntity> getAll(){
		return hibernetTemplate.loadAll(StudentEntity.class);
	}

}
