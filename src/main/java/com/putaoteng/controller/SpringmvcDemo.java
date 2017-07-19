package com.putaoteng.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.putaoteng.dao.UserDao;
import com.putaoteng.model.User;

@Controller
public class SpringmvcDemo {
	@Resource (name="userDao")
	private UserDao userDao;
	
	//直接返回jackson数据
/*	
	@RequestMapping (value="/a/user/list", method=RequestMethod.GET)
	//查询所有用户信息,默认参数可以加也可以不加,都不影响,返回ModelAndView,也可以直接返回String类型,返回值是要跳转的页面的jsp文件的路径名
	public @ResponseBody List<User> queryUserAll(){
		List<User> list = new ArrayList<User>();

		list = userDao.queryUserAll();
		
		return list;
	}*/
	
	@RequestMapping (value="/a/user/list", method=RequestMethod.GET)
	public String queryUserAll(Model model){
		List<User> list = new ArrayList<User>();
		
		list = userDao.queryUserAll();
		model.addAttribute("userList", list);
		 
		return "usersList";
	}
	//直接返回jackson数据的根据ID查询用户
	/*
	@RequestMapping (value="/a/user/{id}", method=RequestMethod.GET)
	public @ResponseBody User queryUserById(@PathVariable (value="id") Integer id){
		User user = userDao.queryUserById(id);
		
		return user;
	}*/
	
	@RequestMapping (value="/a/user/id/{id}", method=RequestMethod.GET)
	public String queryUserById(@PathVariable (value="id") Integer id, Model model){
		User user = userDao.queryUserById(id);
		List<User> list = new ArrayList<User>();
		
		list.add(user);
		
		model.addAttribute("userList", list);
		
		return "user";
	}
	
	@RequestMapping (value="/a/user/name/{name}", method=RequestMethod.GET)
	public String queryUserByName(@PathVariable (value="name") String name, Model model){
		List<User> list = new ArrayList<User>();
		list = userDao.queryUserByName(name);
		
		model.addAttribute("userList", list);
		
		return "user";
	}

	
	@RequestMapping (value="/a/user/id/{id}/update", method=RequestMethod.GET)
	public String updateUser(@PathVariable (value="id") Integer id, Model model){
		User user = userDao.queryUserById(id);
		
		model.addAttribute("user", user);
		
		return "editUser";
	}
	
	@RequestMapping(value="/a/user/id/{id}/update", method=RequestMethod.POST)
	public String updateUser(@PathVariable (value="id") Integer id, User user, Model model){
		userDao.updateUser(user);
		
		model.addAttribute("userList", user);
		
		return "success";
	}
	
	@RequestMapping(value="/a/user/id/{id}/delete", method=RequestMethod.GET)
	public String deleteUser(@PathVariable (value="id") Integer id, Model model){
		userDao.deleteUser(id);
		
		return "success";
	}

	@RequestMapping (value="/a/user/add", method=RequestMethod.GET)
	public String addUser(){
		
		return "addUser";
	}

	
	@RequestMapping (value="/a/user/add", method=RequestMethod.POST)
	public String addUser(User user, Model model){
		userDao.addUser(user);
		
		model.addAttribute("user", user);
		
		return "success";
	}
}
