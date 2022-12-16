package com.jbd.serviceImpl.test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.jbd.daoImpl.StudentDaoImpl;
import com.jbd.entity.Student;
import com.jbd.exception.StudentManagementSystemException;
import com.jbd.serviceImpl.StudentServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class StudentServiceImplTest {

	@Mock
	private StudentDaoImpl studentDaoImpl;

	@InjectMocks
	private StudentServiceImpl studentServiceImpl;

	private Student student;

	private List<Student> expectStudentList;

	private List<Student> actualStudentList;

	@Before
	public void setUp() {

		student = new Student(1, "Digvijay", "Jatkar", "jatkardigvijay@gmail.com", 28, "+353 87 719 7021");

		expectStudentList = new ArrayList<>();
		expectStudentList.add(student);
		actualStudentList = new ArrayList<>();
		actualStudentList.add(student);

	}

	@Test
	public void getProcessImprovementRecommendationsListPositiveTest() throws StudentManagementSystemException {

		when(studentDaoImpl.getAllStudents()).thenReturn(expectStudentList);
		List<Student> studentList = studentServiceImpl.getAllStudents();
		assertEquals(actualStudentList.size(), studentList.size());
	}
	
	@Test
	public void getProcessImprovementRecommendationsListNegativeTest() throws StudentManagementSystemException {

		when(studentDaoImpl.getAllStudents()).thenReturn(expectStudentList);
		List<Student> studentList = studentServiceImpl.getAllStudents();
		assertNotEquals(actualStudentList.size(), studentList.size());
	}
}
