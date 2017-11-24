package cn.zbit.dao.devuser;

import org.apache.ibatis.annotations.Param;

import cn.zbit.pojo.DevUser;

public interface DevUserMapper {
	/**
	 * 根据devCode获取用户记录
	 * @param devCode
	 * @return
	 */
	public DevUser getLoginUser(@Param("devcode") String devCode);
}
