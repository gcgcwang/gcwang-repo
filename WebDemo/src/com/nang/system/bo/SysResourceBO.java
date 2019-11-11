package com.nang.system.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nang.jpa.JpaService;
import com.nang.system.po.SysResourcePO;
import com.nang.system.vo.SysResource;

@Service
public class SysResourceBO extends BaseBO{

	@Autowired
	private SysResourcePO sysResourcePO;
	@Autowired
	private JpaService jpaService;
	
	@Transactional
	public int add() {
		// TODO
		SysResource resource = new SysResource();
		resource.setId(jpaService.getSeq(SysResource.class));
		resource.setName("name06");
		resource.setCode("code06");
		resource.setCreater(10202);

		long res = jpaService.insertUseKey(resource);
		return 1;
	}

	public int remove(SysResource inputDto) {
		// TODO 
		return jpaService.delete(SysResource.class, 453L);
	}
	
	
}
