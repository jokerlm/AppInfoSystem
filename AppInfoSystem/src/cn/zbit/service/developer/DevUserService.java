package cn.zbit.service.developer;

import cn.zbit.pojo.DevUser;

public interface DevUserService {
	/**
	 * 登录验证
	 * @param devCode
	 * @param password
	 * @return
	 */
	public DevUser login(String devCode, String password);
}
