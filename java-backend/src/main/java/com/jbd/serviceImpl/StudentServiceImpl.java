package com.jbd.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jbd.dao.StudentDao;
import com.jbd.entity.Student;
import com.jbd.exception.StudentManagementSystemException;
import com.jbd.service.StudentService;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {

	private static final Logger logger = LoggerFactory.getLogger(StudentServiceImpl.class.getName());

	@Autowired
	private StudentDao studentDao;

	/**
	 * @author Digvijay.Jatkar
	 * @Description This method is a service method making call to the DAO layer for
	 *              getting list of students
	 * @param
	 * @return List of all students
	 * @throws StudentManagementSystemException
	 * @Created 17/11/2022
	 * @Updated
	 **/
	@Override
	public List<Student> getAllStudents() throws StudentManagementSystemException {

		logger.info("executing getAllStudents() from StudentServiceImpl");
		return studentDao.getAllStudents();
	}

	@Override
	public Student getStudentById(int id) throws StudentManagementSystemException {

		logger.info("executing getStudentById() from StudentServiceImpl with id= " + id);
		return studentDao.getStudentById(id);
	}

	@Override
	public boolean deleteStudentById(Integer id) throws StudentManagementSystemException {

		logger.info("executing deleteById() from StudentServiceImpl with id= " + id);
		return studentDao.deleteStudentById(id);
	}

	@Override
	public boolean insertStudent(Student student) throws StudentManagementSystemException {

		logger.info("executing insertStudent() from StudentServiceImpl with id= " + student);
		return studentDao.insertStudent(student);
	}

	@Override
	public Student updatedStudent(Student student) throws StudentManagementSystemException {

		logger.info("executing updatedStudent() from StudentServiceImpl with id= " + student);
		return studentDao.updateStudent(student);
	}
	
	
}
