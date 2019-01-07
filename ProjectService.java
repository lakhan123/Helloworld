/**
 * 
 */
package com.nt.service;

import java.util.List;
import java.util.Map;

/**
 * @author Lakhan Patel
 * CodeBreaker
 */
public interface ProjectService {
	public int getProjectNumber();
	public String getProjNameById(int id);
	public Map<String ,Object> getProjDetailsById(int id);
	public List<Map<String, Object>> getProjDetais();
	public String insert(int id, String name,int size,String manager);
	public String changeManager(String oldManager, String newManager);
	public String finishProject(int id);
}
