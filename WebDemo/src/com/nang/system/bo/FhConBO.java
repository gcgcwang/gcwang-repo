package com.nang.system.bo;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nang.system.po.FhConPO;


@Service
public class FhConBO extends BaseBO{
	
	@Autowired
	//private  FhConDao fhConDao;
	private  FhConPO fhConPO;
	
	
	
	/*public   FhConVO  findById(String cid){
		FhConVO fhConVO = fhConPO.findByID(cid);
		
		return fhConVO;
		
	}
	
	public   List<FhConVO>  findList(FhConVO  fhConVO){
		List<FhConVO> fhConVOList = fhConPO.findList(fhConVO);
		return fhConVOList;
	}*/

	/*public static void main(String[] args) {
		
		FhConDao dao=(FhConDao) ContextLoaderListener.getCurrentWebApplicationContext().getBean("FhConDao");
		System.out.println(dao);
	}*/
	
}
