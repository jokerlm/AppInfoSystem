package cn.zbit.controller.develop;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.zbit.pojo.DevUser;
import cn.zbit.service.developer.AppInfoService;
import cn.zbit.tools.Constants;

@Controller
@RequestMapping(value="/dev/flatform/app")
public class AppInfoController {
	@Resource
	private AppInfoService appInfoService;
	
	private Logger logger = Logger.getLogger(DevUserController.class);
	
	@RequestMapping(value="/list")
	public String getAppInfoList(Model model,HttpSession session,
			@RequestParam(value="querySoftwareName",required=false) String querySoftwareName,
			@RequestParam(value="queryStatus",required=false) String _queryStatus,
			@RequestParam(value="queryCategroyLeve1",required=false) String _queryCategroyLeve1,
			@RequestParam(value="queryCategroyLeve2",required=false) String _queryCategroyLeve2,
			@RequestParam(value="queryCategroyLeve3",required=false) String _queryCategroyLeve3,
			@RequestParam(value="queryFlatformId",required=false) String _queryFlatformId,
			@RequestParam(value="pageIndex",required=false) String pageIndex){
		logger.info("getAppInfoList-->querySoftwareName:"+querySoftwareName);
		logger.info("getAppInfoList-->querySoftwareName:"+_queryStatus);
		logger.info("getAppInfoList-->querySoftwareName:"+_queryCategroyLeve1);
		logger.info("getAppInfoList-->querySoftwareName:"+_queryCategroyLeve2);
		logger.info("getAppInfoList-->querySoftwareName:"+_queryCategroyLeve3);
		logger.info("getAppInfoList-->querySoftwareName:"+_queryFlatformId);
		logger.info("getAppInfoList-->querySoftwareName:"+pageIndex);
		
		Integer devId = ((DevUser)session.getAttribute(Constants.DEV_USER_SESSION)).getId();
	}
}















