package cn.zbit.controller.develop;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.zbit.service.developer.DevUserService;
@Controller
@RequestMapping(value="/dev")
public class DevUserController {
	@Resource
	private DevUserService service;
	private Logger logger = Logger.getLogger(DevUserController.class);
}
