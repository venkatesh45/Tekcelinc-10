package com.tekcel.assignment.spring;

import org.springframework.jdbc.core.JdbcTemplate;

import com.tekcel.assignment.dao.SubmitDAO;

public class SubmitDAOImplSpring implements SubmitDAO {

	@Override
	public boolean checkAuth(String username, String password) {

		JdbcTemplate jdbcTemplate = DBConnectionDBCP.getJdbcTemplate();

		String pwd = (String) jdbcTemplate.queryForObject("SELECT password FROM login where username=?",
				new Object[] { username }, String.class);

		if (pwd != null && pwd.equals(password))
			return true;

		return false;
	}

}
