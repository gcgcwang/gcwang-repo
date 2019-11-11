package com.nang.jpa;



import com.nang.jpa.enums.PkGeneratorEnum;
import com.nang.jpa.sql.TableAsso;

public interface EntryMapper {

	 abstract String getEntryTableName(Class<?> clazz);
	
	 
	 abstract String[] getPKFieldName(Class<?> clazz);
		
	
	 abstract String getSequenceName(Class<?> clazz);
	  
	 abstract PkGeneratorEnum getPkGenerator(Class<?> clazz);
	 
	 abstract TableAsso getTableAsso(Class<?> clazz);
}
