package com.nang.system.dao;

import java.util.List;

import com.nang.system.common.MyBatisDao;
import com.nang.system.vo.FhConVO;

@MyBatisDao
public interface FhConDao {
	
	public FhConVO findByID(String cid);
	
	
	public List<FhConVO> findList(FhConVO fhConVO);
}
