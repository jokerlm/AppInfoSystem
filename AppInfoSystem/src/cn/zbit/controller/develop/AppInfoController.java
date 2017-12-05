package cn.zbit.controller.develop;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.zbit.pojo.AppCategory;
import cn.zbit.pojo.AppInfo;
import cn.zbit.pojo.DataDictionary;
import cn.zbit.pojo.DevUser;
import cn.zbit.service.developer.AppCategoryService;
import cn.zbit.service.developer.AppInfoService;
import cn.zbit.service.developer.DataDictionaryService;
import cn.zbit.tools.Constants;
import cn.zbit.tools.PageSupport;

@Controller
@RequestMapping(value="/dev/flatform/app")
public class AppInfoController {
	@Resource
	private AppInfoService appInfoService;
	@Resource
	private DataDictionaryService dataDictionaryService;
	@Resource
	private AppCategoryService appCategoryService;
	
	private Logger logger = Logger.getLogger(DevUserController.class);
	

	
	@RequestMapping(value="/list")
	public String getAppInfoList(Model model,HttpSession session,
			@RequestParam(value="querySoftwareName",required=false) String querySoftwareName,
			@RequestParam(value="queryStatus",required=false) String _queryStatus,
			@RequestParam(value="queryCategroyLeve1",required=false) String _queryCategoryLeve1,
			@RequestParam(value="queryCategroyLeve2",required=false) String _queryCategoryLeve2,
			@RequestParam(value="queryCategroyLeve3",required=false) String _queryCategoryLeve3,
			@RequestParam(value="queryFlatformId",required=false) String _queryFlatformId,
			@RequestParam(value="pageIndex",required=false) String pageIndex){
		logger.info("getAppInfoList-->querySoftwareName:"+querySoftwareName);
		logger.info("getAppInfoList-->querySoftwareName:"+_queryStatus);
		logger.info("getAppInfoList-->querySoftwareName:"+_queryCategoryLeve1);
		logger.info("getAppInfoList-->querySoftwareName:"+_queryCategoryLeve2);
		logger.info("getAppInfoList-->querySoftwareName:"+_queryCategoryLeve3);
		logger.info("getAppInfoList-->querySoftwareName:"+_queryFlatformId);
		logger.info("getAppInfoList-->querySoftwareName:"+pageIndex);
		
		Integer devId = null;
		try {
			devId = ((DevUser)session.getAttribute(Constants.DEV_USER_SESSION)).getId();
		} catch (Exception e1) {
			return "index";
		}
		
		List<AppInfo> appInfoList = null;
		List<DataDictionary> statusList = null;
		List<DataDictionary> flatFormList = null;
		//列出一级分类列表，注：二级和三级分类类别通过ajax异步获取
		List<AppCategory> categoryLevel1List = null;
		List<AppCategory> categoryLevel2List = null;
		List<AppCategory> categoryLevel3List = null;
		//页面容量
		int pageSize = Constants.pageSize;
		//当前页码
		Integer currentPageNo = 1;
		if(pageIndex != null){
			try {
				currentPageNo = Integer.valueOf(pageIndex);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		Integer queryStatus = null;
		if(_queryStatus != null && !("").equals(_queryStatus)){
			queryStatus = Integer.parseInt(_queryStatus);
		}
		Integer queryCategoryLevel1 = null;
		if(_queryCategoryLeve1 != null && !_queryCategoryLeve1.equals("")){
			queryCategoryLevel1 = Integer.parseInt(_queryCategoryLeve1);
		}
		Integer queryCategoryLevel2 = null;
		if(_queryCategoryLeve2 != null && !_queryCategoryLeve2.equals("")){
			queryCategoryLevel2 = Integer.parseInt(_queryCategoryLeve2);
		}
		Integer queryCategoryLevel3 = null;
		if(_queryCategoryLeve3 != null && !_queryCategoryLeve3.equals("")){
			queryCategoryLevel3 = Integer.parseInt(_queryCategoryLeve3);
		}
		Integer queryFlatformId = null;
		if(_queryFlatformId != null && !_queryFlatformId.equals("")){
			queryFlatformId = Integer.parseInt(_queryFlatformId);
		}
		
		//总数量(表)
		int totalCount = 0;
		try {
			totalCount = appInfoService.getAppInfoCount(querySoftwareName, queryStatus, queryCategoryLevel1, queryCategoryLevel2, queryCategoryLevel3, queryFlatformId, devId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//总页数
		PageSupport pages = new PageSupport();
		pages.setCurrentPageNo(currentPageNo);
		pages.setPageSize(pageSize);
		pages.setTotalCount(totalCount);
		int totalPageCount = pages.getTotalPageCount();
		//控制首页和尾页
		if(currentPageNo < 1){
			currentPageNo = 1;
		}else if(currentPageNo > totalPageCount){
			currentPageNo = totalPageCount;
		}
		try {
			appInfoList = appInfoService.getAppInfoList(querySoftwareName, queryStatus, queryCategoryLevel1, queryCategoryLevel2, queryCategoryLevel3, queryFlatformId, devId, currentPageNo, pageSize);
			statusList = this.getDataDictionaryList("APP_STATUS");
			flatFormList = this.getDataDictionaryList("APP_FLATFORM");
			categoryLevel1List = appCategoryService.getAppCategoryListByParentId(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("appInfoList",appInfoList);
		model.addAttribute("statusList",statusList);
		model.addAttribute("flatFormList",flatFormList);
		model.addAttribute("categoryLevel1List",categoryLevel1List);
		model.addAttribute("pages",pages);
		model.addAttribute("queryStatus",queryStatus);
		model.addAttribute("querySoftwareName",querySoftwareName);
		model.addAttribute("queryCategoryLevel1",queryCategoryLevel1);
		model.addAttribute("queryCategoryLevel2",queryCategoryLevel2);
		model.addAttribute("queryCategoryLevel3",queryCategoryLevel3);
		model.addAttribute("queryFlatformId",queryFlatformId);
		
		return "developer/appinfolist";
	}
	
	public List<DataDictionary> getDataDictionaryList(String typeCode){
		List<DataDictionary> dataDictionaryList = null;
		try {
			dataDictionaryList = dataDictionaryService.getDataDictionaryList(typeCode);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dataDictionaryList;
	}
	
	/**
	 * 根据parentId查询出相应的分类级别列表
	 * @param pid
	 * @return
	 */
	@RequestMapping(value="/categorylevellist.json",method=RequestMethod.GET)
	@ResponseBody
	public List<AppCategory> getAppCategoryList(@RequestParam String pid){
		logger.debug("getAppCategoryList pid==================" + pid);
		if((pid).equals("")) pid = null;
		return getCategoryList(pid);
	}
	
	
	public List<AppCategory> getCategoryList(String pid){
		List<AppCategory> categoryLevelList = null;
		try {
			categoryLevelList = appCategoryService.getAppCategoryListByParentId(pid==null?null:Integer.parseInt(pid));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return categoryLevelList;
	}
}