package com.nt.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.nt.model.User;
import com.nt.util.HibernateUtils;
@Repository
public class UserDAOImpl implements UserDAO {
	
	public int saveUser(User user) {
		Session ses = null;
		int id = 0;
		ses = HibernateUtils.getSession();
		id = (Integer) ses.save(user);
		return id;
	}

	public List<String> getCountry() {
		Session ses = null;
		List<String> country = null;
		String []countryCode = null;
		
		countryCode = Locale.getISOCountries();
		country = new ArrayList<String>();
		for(String code : countryCode) {
			Locale locale = new Locale("", code);
			country.add(locale.getDisplayCountry());
		}
		ses = HibernateUtils.getSession();
		return country;
	}

	

	public List<User> getUser() {
		Session ses = HibernateUtils.getSession();
		Query query = null;
		List<User> users = null;
		
		query = ses.createQuery("from User");
		users = query.list();
		return users;
	}

	public List<String> getState(String country) {
		List<String> state = null;
		Map<String,List<String>>states=null;
		
		state = new ArrayList<String>();
		states = new HashMap<String, List<String>>();
		state.add("MadhayaPradesh");
		state.add("AndhraPradesh");
		state.add("Bihar");
		states.put("India", state);
				
		return states.get(country);
	}

	public List<String> getCity(String state) {
		// TODO Auto-generated method stub
		return null;
	}

}
