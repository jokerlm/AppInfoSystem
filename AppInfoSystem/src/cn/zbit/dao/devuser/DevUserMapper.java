package cn.zbit.dao.devuser;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import cn.zbit.pojo.DevUser;

@Repository("devUserMapper")
public interface DevUserMapper {
	/**
	 * 根据devCode获取用户记录
	 * @param devCode
	 * @return
	 */
	public DevUser getLoginUser(@Param("devCode") String devCode);
}
