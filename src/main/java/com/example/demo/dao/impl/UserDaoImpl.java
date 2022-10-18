package com.example.demo.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.aop.ThrowsAdvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.example.demo.dao.UserDao;
import com.example.demo.entity.User;

@Repository
public class UserDaoImpl extends JdbcDaoSupport implements UserDao{

	@Autowired
	private DataSource dataSource;
	
	@PostConstruct
	private void initializer() {
		setDataSource(dataSource);
	}
	
	@Override
	public User getUserById(String userId) {
		String sql = "select cast(aes_decrypt(unhex(password),'secret')as char(45)) from user where user_id =?";
		
		return getJdbcTemplate().queryForObject(sql, new Object[]{userId}, new RowMapper<User>() {
			
			@Override
			public User mapRow(ResultSet rs, int rowNum) throws SQLException{
				User user = new User();
				user.setUserId(userId);
				user.setPassword(rs.getString(1));
				return user;
			}
		});
	}

}
