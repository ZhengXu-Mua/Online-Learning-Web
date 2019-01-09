package com.xms.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.xms.annotation.MyAnnotation;
import com.xms.entity.Car;
import com.xms.entity.Course;
import com.xms.entity.CourseContent;
import com.xms.entity.CourseDirection;
import com.xms.entity.Item;
import com.xms.entity.Order;

@MyAnnotation
public interface MainDao {
	//查询全部课程方向
	List<CourseDirection> findAllCourseDirection();

	List<Course> findAllDemoCourse();

	List<Course> findNewCourse();

	List<Course> findCourse(int content_id);

	List<CourseContent> findCourseContentByCourseDirectionId(
			@Param("courseDirectionId")int courseDirectionId);

	List<Course> findCourseByCourseDirectionIdAndCourseContentId(
			Map<String, Object> map);

	Course findCourseByCourseId(int courseId);

	List<Course> findCourseByCourseDirectionIdAndCourseContentIdAndPage(
			Map<String, Object> map);

	int findCountsByCourseDirectionIdAndCourseContentId(Map<String, Object> map);

	Car findCarByUserId(int userid);

	void saveCar(Car car);

	List<Integer> findCourseIdByCarId(Integer id);

	void saveItem(Item item);

	void saveCarItem(Map<String, Object> map);

	List<Item> findItemByUserId(int userId);

	void deleteCarItem(int itemId);

	void deleteItem(int itemId);

	Item findItemByItemId(Integer itemId);

	void saveOrder(Order order);

	void saveOrderItem(Map<String, Integer> map);
	
}
