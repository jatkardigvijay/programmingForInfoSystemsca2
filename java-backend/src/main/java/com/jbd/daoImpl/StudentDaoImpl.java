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
	 * @Description This method executes query, connects with the database and gets the lists of students
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

			ps = connection.prepareStatement(Queries.GET_ALL_EMPLOYEES);

			logger.info("executing query : " + Queries.GET_ALL_EMPLOYEES);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				Student student = new Student(rs.getInt("studentId"), rs.getString("firstName"),
						rs.getString("lastName"), rs.getString("emailId"), rs.getInt("studentAge"),
						rs.getString("contactNumber"));

				studentList.add(student);
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new StudentManagementSystemException("Error executing stored procedure",
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

}
