package com.xms.controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xms.entity.Car;
import com.xms.entity.Course;
import com.xms.entity.CourseContent;
import com.xms.entity.CourseDirection;
import com.xms.entity.Item;
import com.xms.entity.Order;
import com.xms.entity.User;
import com.xms.service.MainService;

@Controller
@RequestMapping("/main")
public class MainController {
	
	int pagsNums = 15;
	
	@Resource
	private MainService mainService;
	
	@RequestMapping("/toIndex.do")
	public String toIndex(Model model){
		//查询全部课程方向
		List<CourseDirection> courseDirections = mainService.findAllCourseDirection();
		model.addAttribute("courseDirections",courseDirections);
		//查询实战推荐课程(5个)
		List<Course> demoCourses = mainService.findDemoCourse();
		model.addAttribute("demoCourses",demoCourses);
		//查询新手入门课程(10个)
		List<Course> newCourses = mainService.findNewCourse();
		model.addAttribute("newCourses",newCourses);
		
		List<Course> Courses = mainService.findCourse("Demo",5);
		
		return "index";
	}
	
	@RequestMapping("/toCar.do")
	public String toCar(HttpServletRequest request,Model model){
		User user = (User)request.getSession().getAttribute("User");
		
		//根据用户ID找到对应的购物车中商品条目信息
		List<Item> items = mainService.findItemByUserId(user.getId());
		model.addAttribute("items",items);
		
		return "car";
	}
	
	@RequestMapping("/delete.do")
	public String delete(@RequestParam("item_id")int id){
		
		//从cx_car_item表中删除购物车与此商品条目的对应关系
		mainService.deleteCarItem(id);
		//从xc_item表中删除对应的商品条目数据
		mainService.deleteItem(id);
		//重定向到购物车页面
		return "redirect:/main/toCar.do";
	}
	
	@RequestMapping("/deleteAll.do")
	public String deleteAll(@RequestParam("item_ids")int[] ids){
		for (int i : ids) {
			mainService.deleteCarItem(i);
			mainService.deleteItem(i);
		}
		return "redirect:/main/toCar.do";
	}
	
	@RequestMapping("/toCourse.do")
	public String toCourse(@ModelAttribute("courseDirectionId")int courseDirectionId, @ModelAttribute("courseContentId")int courseContentId,Model model,
			@ModelAttribute("page")int page){
		//查询全部课程方向
		List<CourseDirection> courseDirections = mainService.findAllCourseDirection();
		
		model.addAttribute("courseDirections", courseDirections);
		//根据课程方向ID查询对应的课程内容
		List<CourseContent> courseContents = mainService.findCourseContentByCourseDirectionId(courseDirectionId);
		
		model.addAttribute("courseContents", courseContents);
		//根据课程方向ID和课程内容ID来查询对应的课程,查询第page页,每次查询pageNums条数据
		List<Course> courses = mainService.findCourseByCourseDirectionIdAndCourseContentIdAndPage(courseDirectionId,courseContentId,page-1,pagsNums);
		model.addAttribute("courses", courses);
		
		int counts = mainService.findCountsByCourseDirectionIdAndCourseContentId(courseDirectionId,courseContentId);
		int pages = counts%pagsNums==0?counts/pagsNums:counts/pagsNums+1;
		model.addAttribute("pages", pages);
		return "course";
	}
	
	//视频播放
	@RequestMapping("/toVideo.do")
	public String toVideo(int courseId , Model model) {
		//根据课程ID查找课程信息
		Course course = mainService.findCourseByCourseId(courseId);
		model.addAttribute("course", course);
		return "video";
	}
	
	//购买操作
	@RequestMapping("/buy.do")
	@ResponseBody
	public boolean buy(int id,HttpServletRequest request){
		
		User user = (User) request.getSession().getAttribute("User");
		
		//根据用户的ID查找其购物车,如果存在,直接用,如果不存在则创建
		Car car = mainService.findCarByUserId(user.getId());
		if(car == null){
			car = new Car();
			car.setU_id(user.getId());
			mainService.saveCar(car);
		}
		
		List<Integer> ids = mainService.findCourseIdByCarId(car.getId());
		
		if(ids.contains(id)){
			
			return false;
		}else{
			Course course = mainService.findCourseByCourseId(id);
			
			Item item = new Item();
			item.setC_id(course.getId());
			item.setC_name(course.getName());
			item.setC_picture_url(course.getPicture_url());
			item.setC_price(course.getPrice());
			item.setAdd_time(new Timestamp(System.currentTimeMillis()));
			item.setRemove_time(null);
			
			mainService.saveItem(item);
			
			
			mainService.saveCarItem(car.getId(),item.getId());
			
			return true;
		}
	}
	
	@RequestMapping("/toOrder.do")
	public String toOrder(@RequestParam("item_ids")Integer itemIds[],Model model){
		double totalPrice = 0.0;
		
		//根据商品ID查询商品条目
		List<Item> items = new ArrayList<Item>();
		for (Integer itemId : itemIds) {
			Item item = mainService.findItemByItemId(itemId);
			totalPrice += item.getC_price();
			items.add(item);
		}
		model.addAttribute("items", items);
		model.addAttribute("totalPrice", totalPrice);
		return "order";
	}
	
	@RequestMapping("/order.do")
	public String order(Integer[] itemIds,HttpServletRequest request,Model model){
		double totalPrice = 0.0;
		List<Item> items = new ArrayList<Item>();
		
		//根据商品条目ID将购买的商品条目信息从购物车中删除
		for (int i = 0; i < itemIds.length; i++) {
			Item item = mainService.findItemByItemId(itemIds[i]);
			totalPrice += item.getC_price();
			mainService.deleteCarItem(item.getId());
			items.add(item);
		}
		model.addAttribute("totalPrice",totalPrice);
		
		//生成订单
		Order order = new Order();
		User user = (User) request.getSession().getAttribute("User");
		order.setU_id(user.getId());
		order.setOrder_time(new Timestamp(System.currentTimeMillis()));
		order.setTotal_price(totalPrice);
		order.setPay_type("Y");
		//保存订单
		mainService.saveOrder(order);
		//将订单与商品条目关联
		for (Item item : items) {
			mainService.saveOrderItem(order.getId(),item.getId());
		}
		return "success";
	}
	
}
