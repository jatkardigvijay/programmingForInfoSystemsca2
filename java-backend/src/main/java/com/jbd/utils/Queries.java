package com.jbd.utils;

public class Queries {

	public static final String GET_ALL_EMPLOYEES = "select * from student order by studentId";
	public static final String GET_EMPLOYEE_BY_ID = "select * from student where id = ?";
	public static final String DELETE_EMPLOYEE_BY_ID = "delete from student where id = ?";
	public static final String INSERT_EMPLOYEE = "insert into student values (?,?,?)";
	public static final String UPDATE_EMPLOYEE = "update student set firstName = ?, lastName = ?, email = ? where id = ?";
}