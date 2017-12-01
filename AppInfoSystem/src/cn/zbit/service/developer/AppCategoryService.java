package cn.zbit.service.developer;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.zbit.pojo.AppCategory;

public interface AppCategoryService {
	public List<AppCategory> getAppCategoryListByParentId(Integer parentId)throws Exception;
}
