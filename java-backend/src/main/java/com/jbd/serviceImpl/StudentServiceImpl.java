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
	 * @Description This method is a service method making call to the DAO layer for getting list of students
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
	
	
	
}
