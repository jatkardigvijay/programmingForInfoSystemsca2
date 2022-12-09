package com.jbd.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import com.jbd.dao.StudentDao;
import com.jbd.entity.Student;
import com.jbd.exception.StudentManagementSystemException;
import com.jbd.utils.Queries;

@Repository
public class StudentDaoImpl implements StudentDao {

	private static final Logger logger = LoggerFactory.getLogger(StudentDaoImpl.class.getName());

	@Autowired
	private DataSource dataSource;

	/**
	 * @author Digvijay.Jatkar
	 * @Description This method executes query, connects with the database and gets
	 *              the lists of students
	 * @param
	 * @return List of all students
	 * @throws StudentManagementSystemException
	 * @Created 17/11/2022
	 * @Updated
	 **/
	@Override
	public List<Student> getAllStudents() throws StudentManagementSystemException {

		List<Student> studentList = new ArrayList<Student>();

		PreparedStatement ps = null;

		try (Connection connection = dataSource.getConnection()) {

			ps = connection.prepareStatement(Queries.GET_ALL_STUDENTS);

			logger.info("executing query : " + Queries.GET_ALL_STUDENTS);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				Student student = new Student(rs.getInt("studentId"), rs.getString("firstName"),
						rs.getString("lastName"), rs.getString("emailId"), rs.getInt("studentAge"),
						rs.getString("contactNumber"));

				studentList.add(student);
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new StudentManagementSystemException("Error executing stored procedure" + Queries.GET_ALL_STUDENTS,
					HttpStatus.INTERNAL_SERVER_ERROR);
		}

		finally {
			try {
				if (ps != null) {
					ps.close();
				}
			} catch (SQLException ee) {
				logger.error(ee.getMessage());
				ee.printStackTrace();
			}
		}

		return studentList;
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
	@Override
	public Student getStudentById(int id) throws StudentManagementSystemException {

		Student student = null;
		PreparedStatement ps = null;

		try (Connection connection = dataSource.getConnection()) {

			ps = connection.prepareStatement(Queries.GET_STUDENT_BY_ID);

			ps.setObject(1, id);

			logger.info("executing query = " + Queries.GET_STUDENT_BY_ID);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

				student = new Student(rs.getInt("studentId"), rs.getString("firstName"), rs.getString("lastName"),
						rs.getString("emailId"), rs.getInt("studentAge"), rs.getString("contactNumber"));

				return student;
			}

		} catch (Exception e) {
			logger.error("error executing query = " + Queries.GET_STUDENT_BY_ID);
			e.printStackTrace();
			throw new StudentManagementSystemException("Error executing query" + Queries.GET_STUDENT_BY_ID,
					HttpStatus.INTERNAL_SERVER_ERROR);
		}

		finally {
			try {
				if (ps != null) {
					ps.close();
				}
			} catch (SQLException ee) {
				logger.error(ee.getMessage());
				ee.printStackTrace();
			}
		}

		return student;
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
	@Override
	public boolean deleteStudentById(Integer id) throws StudentManagementSystemException {

		PreparedStatement ps = null;

		try (Connection connection = dataSource.getConnection()) {

			ps = connection.prepareStatement(Queries.DELETE_STUDENT_BY_ID);

			ps.setObject(1, id);

			boolean rs = ps.execute();

			if (rs == true) {
				return true;
			}

		} catch (Exception e) {
			logger.error("Error executing query : " + Queries.DELETE_STUDENT_BY_ID);
			e.printStackTrace();
			throw new StudentManagementSystemException("Error executing stored procedure" + Queries.GET_ALL_STUDENTS,
					HttpStatus.INTERNAL_SERVER_ERROR);
		} finally {
			try {
				if (ps != null) {
					ps.close();
				}
			} catch (SQLException ee) {
				logger.error(ee.getMessage());
				ee.printStackTrace();
			}
		}

		return true;
	}

	@Override
	public boolean insertEmployee(Student student) throws StudentManagementSystemException {

		PreparedStatement ps = null;

		try (Connection connection = dataSource.getConnection()) {

			ps = connection.prepareStatement(Queries.INSERT_STUDENT);

			logger.info("executing query : " + Queries.INSERT_STUDENT);

			ps.setString(1, student.getFirstName());
			ps.setString(2, student.getLastName());
			ps.setInt(3, student.getStudentAge());
			ps.setString(4, student.getEmailId());
			ps.setString(5, student.getContactNumber());

			int rs = ps.executeUpdate();

			if (rs == 1) {

				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new StudentManagementSystemException("Error executing query " + Queries.INSERT_STUDENT,
					HttpStatus.INTERNAL_SERVER_ERROR);
		}

		finally {
			try {
				if (ps != null) {
					ps.close();
				}
			} catch (SQLException ee) {
				logger.error(ee.getMessage());
				ee.printStackTrace();
			}
		}

		return true;
	}

}
