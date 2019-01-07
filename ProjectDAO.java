/**
 * 
 */
package com.nt.dao;

import java.util.List;
import java.util.Map;

/**
 * @author Lakhan Patel
 * CodeBreaker
 */
public interface ProjectDAO {
	public int getProjectCount();
	public String getProjNameById(int id);
	public Map<String ,Object> getProjDetailsById(int id);
	public List<Map<String ,Object>> getProjDetais();
	public int insert(int id,String name,int size,String manager);
	public int update(String oldManager,String newManager);
	public int deleteById(int id);
}
