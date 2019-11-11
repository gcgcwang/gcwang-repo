package com.nang.system.action;


import java.util.List;

import javax.jws.WebService;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.nang.jpa.EntryMapper;
import com.nang.jpa.JpaService;
import com.nang.system.vo.DicVO;
import com.nang.system.vo.Pager;
import com.nang.system.vo.SysUser;
import com.nang.system.vo.UserResource;

@Controller
@RequestMapping("/dic")
public class DicAction extends BaseAction{

	
	@Autowired
	private JpaService jpaService;
	@Autowired
	private EntryMapper entryMapper;
	
	@RequestMapping("/findDicPager.do")
	@ResponseBody
	public Pager<DicVO> findPagedic(Pager<DicVO>  pager,HttpServletRequest req){
		
		jpaService.findCascededAll( UserResource.class);
		return jpaService.findPager(DicVO.class, pager);
		
	}
	
}
