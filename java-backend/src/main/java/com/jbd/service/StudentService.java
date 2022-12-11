package com.jbd.service;

import java.util.List;

import com.jbd.entity.Student;
import com.jbd.exception.StudentManagementSystemException;

public interface StudentService {

	List<Student> getAllStudents() throws StudentManagementSystemException;

	Student getStudentById(int id) throws StudentManagementSystemException;

	boolean deleteStudentById(Integer id) throws StudentManagementSystemException;

	boolean insertStudent(Student student) throws StudentManagementSystemException;

	Student updatedStudent(Student student) throws StudentManagementSystemException;

}
