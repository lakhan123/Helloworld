/**
 * 
 */
package com.nt.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.dao.ProjectDAO;

/**
 * @author Lakhan Patel
 * CodeBreaker
 */
@Service("projService")
public class ProjectServiceImpl implements ProjectService {
	@Autowired
	private ProjectDAO dao;

	@Override
	public int getProjectNumber() {
		
		return dao.getProjectCount();
	}

		@Override
	public String getProjNameById(int id) {
		
		return dao.getProjNameById(id);
	}


		@Override
		public Map<String, Object> getProjDetailsById(int id) {
			
			return dao.getProjDetailsById(id);
		}
		
		@Override
		public List<Map<String, Object>> getProjDetais() {
			
			return dao.getProjDetais();
		}

		@Override
		public String insert(int id, String name, int size, String manager) {
			int count = dao.insert(id, name, size, manager);
			if(count==0)
				return "Insertion Failed";
			else
				return "Inserted Successfully";
		}

		@Override
		public String changeManager(String oldManager, String newManager) {
			int count = dao.update(oldManager, newManager);
			if(count==0)
				return "Manager Not Changed";
			else 
				return "Manager Changed";
		}

		@Override
		public String finishProject(int id) {
			int count = dao.deleteById(id);
			if(count == 0)
				return "Already Finished Or Project Not Available";
			else 
				return "Finished";
		}

		

}
