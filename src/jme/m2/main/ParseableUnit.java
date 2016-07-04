package jme.m2.main;

import java.io.IOException;
import java.sql.SQLException;

import jme.m2.core.CodeParser;

class ParseableUnit
{
	ParseableUnit(String fileName, Option option)
	{
		this.fileName=fileName;
		this.option=option;
	}
	
	boolean execute()
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException, SQLException, InterruptedException
	{
		if(isJavaFile(this.fileName)){
			return false;
		}
		CodeParser.parsing(this.fileName,option);
		return true;
	}
	
	private static boolean isJavaFile(String fileName)
	{
		int position=fileName.lastIndexOf(".");
		if(position==-1){
			return false;
		}else{
			String extension=fileName.substring(position);
			if(extension.equals(".java")){
				return true;
			}else{
				return false;
			}
		}
	}
	
	private String fileName;
	private Option option;
}
