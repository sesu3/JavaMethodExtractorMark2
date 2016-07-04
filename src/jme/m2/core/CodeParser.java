package jme.m2.core;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;

import jme.m2.main.Option;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.compiler.IProblem;
import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.CompilationUnit;

public class CodeParser
{

	public static boolean parsing(String sourcePath,Option option) throws IOException
	{
		String sourceFile=new String(Files.readAllBytes(Paths.get(sourcePath)),StandardCharsets.UTF_8);
		ASTParser parser=ASTParser.newParser(AST.JLS8);
		@SuppressWarnings("unchecked")
		Map<String, String> compilerOptions = JavaCore.getOptions();
		compilerOptions.put(JavaCore.COMPILER_SOURCE, JavaCore.VERSION_1_8);
		parser.setCompilerOptions(compilerOptions);
		parser.setSource(sourceFile.toCharArray());
		CompilationUnit unit=(CompilationUnit)parser.createAST(new NullProgressMonitor());
		IProblem[] ip=unit.getProblems();
		for(Iterator<IProblem> iter=Arrays.asList(ip).iterator();iter.hasNext();){
			IProblem tmp=iter.next();
			if(tmp.isError()){
				return false;
			}
		}
		unit.accept(new CodeVisitor());
		return true;
	}

}
