package cn.zbit.service.developer;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.zbit.pojo.DataDictionary;

public interface DataDictionaryService {
	public List<DataDictionary> getDataDictionaryList(String typeCode)throws Exception;
}
