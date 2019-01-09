package com.xms.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xms.dao.MainDao;
import com.xms.entity.Car;
import com.xms.entity.Course;
import com.xms.entity.CourseContent;
import com.xms.entity.CourseDirection;
import com.xms.entity.Item;
import com.xms.entity.Order;

@Service
public class MainService {
	
	@Resource
	private MainDao mainDao;
	
	//查询全部课程方向
	public List<CourseDirection> findAllCourseDirection(){
		List<CourseDirection> courseDirections = mainDao.findAllCourseDirection();
		return courseDirections;
	}
	
	//查询实战推荐课程(5个)
	public List<Course> findDemoCourse(){
		List<Course> demoCourses = mainDao.findAllDemoCourse();
		List<Course> listCourses = new ArrayList<Course>();
		Random random = new Random();
		if(demoCourses.size()<=5){
			return listCourses;
		}else{
			for (int i = 0; i < 5; i++) {
				int index = random.nextInt(demoCourses.size());
				Course course = demoCourses.remove(index);
				listCourses.add(course);
			}
		}
		return listCourses;
	}
	
	//查询新手入门课程(10个)
	public List<Course> findNewCourse(){
		List<Course> demoCourses = mainDao.findNewCourse();
		List<Course> listCourses = new ArrayList<Course>();
		Random random = new Random();
		if(demoCourses.size()<=5){
			return listCourses;
		}else{
			for (int i = 0; i < 10; i++) {
				int index = random.nextInt(demoCourses.size());
				Course course = demoCourses.remove(index);
				listCourses.add(course);
			}
		}
		return listCourses;
	}

	public List<Course> findCourse(String string ,int num) {
		List<Course> listCourses = new ArrayList<Course>();
		List<Course> Courses = null;
		Random random = new Random();
		if(string.equals("Demo")){
			int id=2; 
			Courses=mainDao.findCourse(id);
		}else if(string.equals("New")){
			int id=1;
			Courses=mainDao.findCourse(id);
		}
		if(Courses.size()<=num){
			return listCourses;
		}else{
			for (int i = 0; i < num; i++) {
				int index = random.nextInt(Courses.size());
				Course course = Courses.remove(index);
				listCourses.add(course);
			}
		}
		return listCourses;
	}

	public List<CourseContent> findCourseContentByCourseDirectionId(
			int courseDirectionId) {
		
		return mainDao.findCourseContentByCourseDirectionId(courseDirectionId);
	}

	public List<Course> findCourseByCourseDirectionIdAndCourseContentId(
			int courseDirectionId, int courseContentId) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("courseDirectionId", courseDirectionId);
		map.put("courseContentId", courseContentId);
		return mainDao.findCourseByCourseDirectionIdAndCourseContentId(map);
	}
	
	public List<Course> findCourseByCourseDirectionIdAndCourseContentIdAndPage(
			int courseDirectionId, int courseContentId, int page, int pagsNums) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("courseDirectionId", courseDirectionId);
		map.put("courseContentId", courseContentId);
		map.put("page", page);
		map.put("pagsNums", pagsNums);
		return  mainDao.findCourseByCourseDirectionIdAndCourseContentIdAndPage(map);
	}

	public Course findCourseByCourseId(int courseId) {
		return mainDao.findCourseByCourseId(courseId);
	}

	public int findCountsByCourseDirectionIdAndCourseContentId(
			int courseDirectionId, int courseContentId) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("courseDirectionId", courseDirectionId);
		map.put("courseContentId", courseContentId);
		return mainDao.findCountsByCourseDirectionIdAndCourseContentId(map);
	}

	public Car findCarByUserId(int userid) {
		
		return mainDao.findCarByUserId(userid);
	}
	//创建购物车对象
	public void saveCar(Car car) {
		mainDao.saveCar(car);
		
	}

	public List<Integer> findCourseIdByCarId(Integer id) {
		
		return mainDao.findCourseIdByCarId(id);
	}

	public void saveItem(Item item) {
		mainDao.saveItem(item);
		
	}

	public void saveCarItem(int c_id, int i_id) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("c_id", c_id);
		map.put("i_id", i_id);
		mainDao.saveCarItem(map);
	}

	public List<Item> findItemByUserId(int userId) {
		
		return mainDao.findItemByUserId(userId);
	}

	public void deleteCarItem(int itemId) {
		mainDao.deleteCarItem(itemId);
	}

	public void deleteItem(int itemId) {
		mainDao.deleteItem(itemId);
		
	}

	public Item findItemByItemId(int itemId) {
		return mainDao.findItemByItemId(itemId);
	}

	public void saveOrder(Order order) {
		mainDao.saveOrder(order);
		
	}

	public void saveOrderItem(int orderId, int itemId) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("orderId", orderId);
		map.put("itemId", itemId);
		mainDao.saveOrderItem(map);
	}

	

}
