/**
 * 
 */
package com.nt.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author Lakhan Patel
 * CodeBreaker
 */
@Repository
public class ProjectDAOImpl implements ProjectDAO {
	private static final String INSERT_PROJECT = "INSERT INTO PROJECT VALUES(?,?,?,?)";
	private static final String UPDATE_MANAGER = "UPDATE PROJECT SET MANAGER = ? WHERE MANAGER = ?";
	private static final String DELETE_MANAGER = "DELETE FROM PROJECT WHERE PROJID = ?";
	@Autowired
	private JdbcTemplate jt;

	@Override
	public int getProjectCount() {
		int count = 0;
		count = jt.queryForObject("SELECT count(*) from PROJECT", Integer.class);
		return count;
	}
	
	@Override
	public String getProjNameById(int id) {
		String name = jt.queryForObject("SELECT PROJNAME FROM PROJECT WHERE PROJID = ?", String.class,id);
		return name;
	}
	
	@Override
	public Map<String, Object> getProjDetailsById(int id) {
		
		return jt.queryForMap("SELECT PROJID , PROJNAME, TEAMSIZE, MANAGER FROM PROJECT WHERE PROJID=?", id);
	}

	@Override
	public List<Map<String, Object>> getProjDetais() {
	
		return jt.queryForList("SELECT PROJID , PROJNAME, TEAMSIZE, MANAGER FROM PROJECT");
	}

	@Override
	public int insert(int id, String name, int size, String manager) {
		int count = jt.update(INSERT_PROJECT,id,name,size,manager);
		return count;
	}
	
	@Override
	public int update(String oldManager, String newManager) {
		int count = jt.update(UPDATE_MANAGER, newManager, oldManager);
		return count;
	}

	@Override
	public int deleteById(int id) {
		int count = jt.update(DELETE_MANAGER,id);
		return count;
	}

}
