package com.nang.system.action;


import java.util.List;

import javax.jws.WebService;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.nang.jpa.JpaService;
import com.nang.system.bo.AppBO;
import com.nang.system.vo.App;
import com.nang.system.vo.Pager;
import com.nang.system.vo.SysUser;

@Controller
@RequestMapping("/app")
public class AppAction extends BaseAction{

	@Autowired
	private AppBO appBO;
	@Autowired
	private JpaService jpaService;
	
	
	@RequestMapping("/findPageApp.do")
	@ResponseBody
	public Pager<App> findPageApp(Pager<App>  pager,HttpServletRequest req){
		return jpaService.findPager(App.class, pager);
	}
}
