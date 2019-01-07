/**
 * 
 */
package com.nt.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import com.zaxxer.hikari.HikariDataSource;

/**
 * @author Lakhan Patel
 * CodeBreaker
 */
@Configuration
@ComponentScan(basePackages="com.nt.dao")
public class PersistenceConfig {
	
	@Bean
	public DataSource createDS() {
		HikariDataSource ds = null;
		
		ds = new HikariDataSource();
		ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		ds.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:xe");
		ds.setUsername("system");
		ds.setPassword("123456");
		return ds;
	}
	@Bean
	public JdbcTemplate createJT() {
		return new JdbcTemplate(createDS());
	}
}
