package com.nang.system.dao;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.nang.system.common.MyBatisDao;
import com.nang.system.vo.App;
import com.nang.system.vo.MenuVO;
import com.nang.system.vo.SysResource;
import com.nang.system.vo.SysUser;

@MyBatisDao
public interface SystemDao {
	
	public SysUser findUserByUniName(String loginName);
	
	public List<App> findAppByUser(long userID);

	public List<MenuVO> findMenusByUser(@Param("userID")long userID,@Param("appID")long appID);

	public List<SysResource> findUserResources(long userID);

}
