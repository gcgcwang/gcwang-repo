package com.nang.system.dao;

import java.util.List;

import com.nang.system.common.MyBatisDao;
import com.nang.system.vo.App;
import com.nang.system.vo.Pager;

@MyBatisDao
public interface AppDao {
	
	public long selectTotal();
	
	public List<App> findList(Pager<App> pager);
}
