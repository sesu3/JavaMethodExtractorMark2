package jme.m2.main;

public class Main
{

	public static void main(String[] args)
	{
		Option option=new Option();
		option.setOption(args);
		String filePath=args[args.length-1];
		System.out.println(filePath);
		//ParseExecutable pe=new ParseExecutable();
		//pe.setConfig(Arrays.asList(args));
		//pe.execute();

	}
	
	
	
}
