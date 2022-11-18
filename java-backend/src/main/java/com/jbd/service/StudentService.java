package com.jbd.service;

import java.util.List;

import com.jbd.entity.Student;
import com.jbd.exception.StudentManagementSystemException;

public interface StudentService {

	public List<Student> getAllStudents() throws StudentManagementSystemException;

}
