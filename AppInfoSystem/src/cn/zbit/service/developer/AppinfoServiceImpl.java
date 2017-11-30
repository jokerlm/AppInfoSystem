package cn.zbit.service.developer;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.zbit.dao.appinfo.AppInfoMapper;
import cn.zbit.pojo.AppInfo;

@Service
public class AppinfoServiceImpl implements AppInfoService {
	@Resource
	private AppInfoMapper mapper;
	@Override
	public boolean add(AppInfo appInfo) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modify(AppInfo appInfo) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteAppInfoById(Integer delId) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<AppInfo> getAppInfoList(String querySoftwareName,
			Integer queryStatus, Integer queryCategoryLevel1,
			Integer queryCategoryLevel2, Integer queryCategoryLevel3,
			Integer queryFlatformId, Integer devId, Integer currentPageNo,
			Integer pageSize) throws Exception {
		return mapper.getAppInfoList(querySoftwareName, queryStatus, queryCategoryLevel1, queryCategoryLevel2, queryCategoryLevel3, queryFlatformId, devId, currentPageNo, pageSize);
	}

	@Override
	public int getAppInfoCount(String querySoftwareName, Integer queryStatus,
			Integer queryCategoryLevel1, Integer queryCategoryLevel2,
			Integer queryCategoryLevel3, Integer queryFlatformId, Integer devId)
			throws Exception {
		return mapper.getAppInfoCount(querySoftwareName, queryStatus, queryCategoryLevel1, queryCategoryLevel2, queryCategoryLevel3, queryFlatformId, devId);
	}

	@Override
	public AppInfo getAppInfo(Integer id, String APKName) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteAppLogo(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean appsysdeleteAppById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean appsysUpdateSaleStatusByAppId(AppInfo appInfo)
			throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

}
