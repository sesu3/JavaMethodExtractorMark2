package jme.m2.main;

import java.util.Arrays;
import java.util.Iterator;

public class Option
{
	public Option()
	{
		this.optC=false;
		this.optS=false;
	}
	
	public void setOption(String[] args)
	{
		for(Iterator<String> iter=Arrays.asList(args).iterator();iter.hasNext();){
			String option=iter.next();
			if(option.equals(OPT_SORT)){
				this.optS=true;
			}
			if(option.equals(OPT_CONSTRUCTOR)){
				this.optC=true;
			}
		}
	}
	
	public boolean exeSort()
	{
		return this.optS;
	}
	
	public boolean lookConstructor()
	{
		return this.optC;
	}
	
	private boolean optC;
	private boolean optS;
	private static final String OPT_SORT="-s";
	private static final String OPT_CONSTRUCTOR="-c";
}
