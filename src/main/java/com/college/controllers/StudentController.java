package com.college.controllers;

import java.util.List;

import javax.servlet.ServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.college.bean.StudentEntity;
import com.college.service.StudentService;


@Controller
public class StudentController {
	public static Logger log = LoggerFactory.getLogger(StudentController.class.getSimpleName());

	@Autowired
	private StudentService studentService;

	@RequestMapping(path = "/student", method = RequestMethod.GET)
	public ModelAndView studentEntity() {
		return new ModelAndView("student", "stude", new StudentEntity());

	}

	@RequestMapping(path = "/student", method = RequestMethod.POST)
	public ModelAndView createStudent(@ModelAttribute(name = "stude") StudentEntity studentEntity)
	{
		log.info(studentEntity.toString());
		studentService.save(studentEntity);
		return new ModelAndView("student", "stude", studentEntity);

	}
	@RequestMapping(path = "/all", method = RequestMethod.GET)
	public ModelAndView getAll(ServletRequest servlet, ModelMap map)
	{
		List<StudentEntity>student=studentService.getAll();
		map.put("headerName","view Record");
		map.put("student", student);
		map.put("stand", new StudentEntity());

		return new ModelAndView("stude").addAllObjects(map);
	


	}
}
