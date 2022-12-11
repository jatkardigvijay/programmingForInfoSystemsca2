package com.jbd.utils;

public class Queries {

	public static final String GET_ALL_STUDENTS = "select * from student order by studentId";
	public static final String GET_STUDENT_BY_ID = "select * from student where studentId = ?";
	public static final String DELETE_STUDENT_BY_ID = "delete from student where studentId = ?";
	public static final String INSERT_STUDENT = "insert into student values (?,?,?,?,?)";
	public static final String UPDATE_STUDENT = "update student set firstName = ?, lastName = ?, emailId = ?, studentAge = ?, contactNumber = ? where studentId = ?";
}