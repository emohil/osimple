package cn.com.norming.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.norming.user.domain.User;
import cn.com.norming.user.service.IUserService;

@Controller
@RequestMapping(value="/user/userList")
public class UserListController {

	@Autowired
	private IUserService userService;

	@RequestMapping(value="/findList")
	public String findList(ModelMap model) {
		List<User> users = userService.findAll();
		model.addAttribute("users", users);
		return "user/userList/list";
	}
	
	@RequestMapping(value="/findList2")
	@ResponseBody
	public List<User> findList2() {
		return userService.findAll();
	}
}
