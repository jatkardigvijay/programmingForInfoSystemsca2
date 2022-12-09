package com.jbd.controller;

import java.util.List;

import javax.validation.constraints.Min;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jbd.config.Response;
import com.jbd.entity.Student;
import com.jbd.exception.StudentManagementSystemException;
import com.jbd.service.StudentService;

@RestController
@Validated
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("student")
public class StudentController {

	private static final Logger logger = LoggerFactory.getLogger(StudentController.class.getName());

	@Autowired
	private StudentService studentService;

	/**
	 * @author Digvijay.Jatkar
	 * @Description This method gets the list all the students by connecting with
	 *              the database
	 * @param
	 * @return List of all students
	 * @throws StudentManagementSystemException
	 * @Created 17/11/2022
	 * @Updated
	 **/
	@RequestMapping(path = "api/v1", method = RequestMethod.GET)
	public ResponseEntity<Response> getAllStudents() throws StudentManagementSystemException {

		List<Student> studentList = studentService.getAllStudents();

		if (studentList == null || studentList.isEmpty()) {

			logger.info("No data found or list is empty");
			throw new StudentManagementSystemException("", HttpStatus.OK, studentList);
		}

		return new ResponseEntity<Response>(new Response("success", studentList, null), HttpStatus.OK);
	}

	/**
	 * @author Vishal.Singh
	 * @Description This method gets the student data by student id from the DB
	 * 
	 * @param
	 * @return Student data by Id
	 * @throws StudentManagementSystemException
	 * @Created 23/11/2022
	 * @Updated
	 **/
	@GetMapping("/api/v1/{id}")
	public ResponseEntity<Response> getEmployeeById(@PathVariable("id") int id)
			throws StudentManagementSystemException {

		Student student = studentService.getStudentById(id);

		if (student == null) {
			logger.info("Employee with id = " + id + " not found");
			throw new StudentManagementSystemException("No data found", HttpStatus.OK, student);
		} else {
			logger.info("Received employee with id = " + id);
			return new ResponseEntity<Response>(new Response("success", student, null), HttpStatus.OK);
		}
	}

	/**
	 * @author Digvijay.Jatkar
	 * @Description This method deletes the student data from the database on
	 *              passing the id
	 * 
	 * @param Student id
	 * @return Student id of which the student data is removed/deleted
	 * @throws StudentManagementSystemException
	 * @Created 05/12/2022
	 * @Updated
	 **/
	@RequestMapping(path = "api/v1/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Integer> deleteStudentById(
			@Min(value = 1, message = "minimum value should be 1") @PathVariable("id") Integer id)
			throws StudentManagementSystemException {

		boolean isRemoved = studentService.deleteStudentById(id);

		if (!isRemoved) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Integer>(id, HttpStatus.OK);

	}

	/**
	 * @author Digvijay.Jatkar
	 * @Description This method inserts data into the database
	 * 
	 * @param Student
	 * @return boolean of which the student data is inserted
	 * @throws StudentManagementSystemException
	 * @Created 09/12/2022
	 * @Updated
	 **/
	@PostMapping("/api/v1/add")
	public boolean insertEmployee(@RequestBody Student student) throws StudentManagementSystemException {

		logger.info("executing insertEmployee() method from employee controller");
		return studentService.insertEmployee(student);
	}
}
