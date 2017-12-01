package cn.zbit.service.developer;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.zbit.dao.datadictionary.DataDictionaryMapper;
import cn.zbit.pojo.DataDictionary;

@Service
public class DataDictionaryServiceImpl implements DataDictionaryService {
	
	@Resource
	private DataDictionaryMapper mapper;
	@Override
	public List<DataDictionary> getDataDictionaryList(String typeCode)
			throws Exception {
		return mapper.getDataDictionaryList(typeCode);
	}

}
