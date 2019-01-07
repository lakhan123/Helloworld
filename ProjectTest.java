/**
 * 
 */
package com.nt.test;

import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.config.AppConfig;
import com.nt.service.ProjectService;

/**
 * @author Lakhan Patel
 * CodeBreaker
 */
public class ProjectTest {

	public static void main(String[] args) {
		ApplicationContext ctx = null;
		ProjectService service = null;
		ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		service = ctx.getBean("projService",ProjectService.class);
		
		System.out.println("Number of project "+service.getProjectNumber());
		System.out.println("Name of Project : "+service.getProjNameById(101));
		System.out.println("Details for 101 : "+service.getProjDetailsById(101));
		System.out.println("Details for all project "+service.getProjDetais());
		//using java 8 lambda expression
		service.getProjDetais().forEach(map->map.entrySet().forEach(System.out::println));
		//using java 8 method refrence
		service.getProjDetais().forEach(ProjectTest::displayMap);
//		System.out.println(service.insert(1001, "JRP", 7, "Lakhan"));
		System.out.println(service.changeManager("abc", "xyz"));
		System.out.println(service.finishProject(1001));
		((AbstractApplicationContext) ctx).close();
	}
	public static void displayMap(Map<?,?> map) {
		map.keySet().forEach(key->{
			System.out.print(key +"::"+map.get(key)+"  ");
		});
		System.out.println();
	}

}
