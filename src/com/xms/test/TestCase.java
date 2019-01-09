package com.xms.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xms.entity.Course;
import com.xms.entity.CourseContent;
import com.xms.entity.CourseDirection;
import com.xms.service.MainService;

public class TestCase {
	
	ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
	MainService mainService = ac.getBean("mainService",MainService.class);
	
	//查询全部课程方向
	@Test
	public void testOne(){
		System.out.println(ac);
		List<CourseDirection> courseDirections = mainService.findAllCourseDirection();
		for (CourseDirection courseDirection : courseDirections) {
			System.out.println(courseDirection.getId());
			System.out.println(courseDirection.getName());
			System.out.println(courseDirection.getPicture_url());
			System.out.println("==============================");
		}
	}
	
	@Test
	public void testTwo(){
		List<Course> courses = mainService.findDemoCourse();
		for (Course course : courses) {
			System.out.println(course.getId());
			System.out.println(course.getName());
			System.out.println(course.getPrice());
			System.out.println("==============================");
		}
	}
	@Test
	public void testThree(){
		List<Course> courses = mainService.findNewCourse();
		for (Course course : courses) {
			System.out.println(course.getId());
			System.out.println(course.getName());
			System.out.println(course.getPrice());
			System.out.println("==============================");
		}
	}
	@Test
	public void testFour(){
		List<Course> courses = mainService.findCourse("New",10);
		for (Course course : courses) {
			System.out.println(course.getId());
			System.out.println(course.getName());
			System.out.println(course.getPrice());
			System.out.println("==============================");
		}
	}
	
	@Test
	public void testFive(){
//		List<CourseContent> courseContents = mainService.findCourseContentByCourseDirectionId(0);
//		for (CourseContent courseContent : courseContents) {
//			System.out.println(courseContent.getId());
//			System.out.println(courseContent.getName());
//			System.out.println("==============================");
//		}
		int counts = mainService.findCountsByCourseDirectionIdAndCourseContentId(0,0);
		int pages = counts%15==0?counts/15:counts/15+1;
		System.out.println(pages);
		
		List<Course> courses = mainService.findCourseByCourseDirectionIdAndCourseContentIdAndPage(0, 0, 0, 15);
		for (Course course : courses) {
			System.out.println(course.getId());
			System.out.println(course.getName());
			System.out.println("==============================");
		}
	}
	
}
