package cn.zbit.controller.develop;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.zbit.pojo.DevUser;
import cn.zbit.service.developer.DevUserService;
import cn.zbit.tools.Constants;
@Controller
@RequestMapping(value="/dev")
public class DevUserController {
	@Resource
	private DevUserService service;
	private Logger logger = Logger.getLogger(DevUserController.class);
	
	@RequestMapping(value="/login")
	public String login(){
		logger.debug("LoginController welcome AppinfoSystem develper============");
		return "devlogin";
	}
	
	@RequestMapping(value="/dologin")
	public String dologin(@RequestParam String devCode, @RequestParam String devPassword
			,HttpSession session,HttpServletRequest request){
		logger.debug("dologin========================");
		DevUser user = null;
		//调用service方法，进行用户匹配
		user = service.login(devCode, devPassword);
		if(null != user){
			//放入session
			session.setAttribute(Constants.DEV_USER_SESSION, user);
			//页面跳转(main.jsp)
			return "redirect:/dev/flatfrom/main";
		}else{
			//保留在devlogin.jsp,带出一些提示信息
			request.setAttribute("error", "用户名或密码不正确！");
			return "devlogin";
		}
	}
	
	@RequestMapping(value="/flatfrom/main")
	public String main(HttpSession session){
		if(session.getAttribute(Constants.DEV_USER_SESSION)==null){
			return "rediect:/dev/login";
		}
		return "developer/main";
	}
	
	@RequestMapping(value="/logout")
	public String logout(HttpSession session){
		//清除session
		session.removeAttribute(Constants.DEV_USER_SESSION);
		return "devlogin";
	}
}
