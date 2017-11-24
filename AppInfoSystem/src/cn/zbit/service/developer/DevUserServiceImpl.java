package cn.zbit.service.developer;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.zbit.dao.devuser.DevUserMapper;
import cn.zbit.pojo.DevUser;
@Service
public class DevUserServiceImpl implements DevUserService {
	@Resource
	private DevUserMapper mapper;
	@Override
	public DevUser login(String devCode, String password) {
		DevUser user = null;
		user = mapper.getLoginUser(devCode);
		if(null !=user){
			if(!user.getDevPassword().equals(password)){
				user = null;
			}
		}
		return user;
	}

}
