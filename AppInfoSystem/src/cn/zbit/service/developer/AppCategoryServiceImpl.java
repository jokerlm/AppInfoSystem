package cn.zbit.service.developer;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.zbit.dao.appcategory.AppCategoryMapper;
import cn.zbit.pojo.AppCategory;

@Service
public class AppCategoryServiceImpl implements AppCategoryService {

	@Resource
	private AppCategoryMapper mapper;
	
	@Override
	public List<AppCategory> getAppCategoryListByParentId(Integer parentId)
			throws Exception {
		return mapper.getAppCategoryListByParentId(parentId);
	}

}
