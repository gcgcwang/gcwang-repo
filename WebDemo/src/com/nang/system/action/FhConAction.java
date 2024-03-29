package com.nang.system.action;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nang.core.DataWrapper;
import com.nang.jpa.JpaService;
import com.nang.jpa.sql.OrderBy;
import com.nang.jpa.sql.Where;
import com.nang.system.bo.FhConBO;
import com.nang.system.vo.FhConVO;

@Controller
@RequestMapping("/fhCon")
public class FhConAction extends BaseAction{

	@Autowired
	private FhConBO fhConBO;
	@Autowired
	private JpaService jpaService;
	
	@RequestMapping("/findById.do")
	@ResponseBody
	public DataWrapper  findById(Long  Id,HttpServletRequest req){
		
		FhConVO fhConVO = jpaService.findById(FhConVO.class,new Where().and("cid", "= ", 12312)
				.and("cno", "=", 2));
		return this.success(fhConVO);
	}
	

	@RequestMapping("/findList.do")
	@ResponseBody
	public DataWrapper  findList(HttpServletRequest req){
		List<FhConVO> list=null;
		try {
			
			list = jpaService.findList(FhConVO.class,
				new Where().and("cstatus", "=", 2).or("cstatus", "=", 1),
				new OrderBy().add("cid", "asc"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this.success(list);
	}
	
}
