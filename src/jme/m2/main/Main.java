package jme.m2.main;

import java.io.IOException;

import jme.m2.core.CodeParser;

public class Main
{

	public static void main(String[] args) throws IOException
	{
		Option option=new Option();
		option.setOption(args);
		String filePath=args[args.length-1];
		System.out.println(filePath);
		if(!(isJavaFile(filePath)&&CodeParser.parsing(filePath,option))){
			// error occured
		}
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

}
