package jme.m2.core;

import java.util.Arrays;
import java.util.Iterator;

import jme.m2.core.object.Variable;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.SingleVariableDeclaration;
import org.eclipse.jdt.core.dom.TypeDeclaration;


class CodeVisitor extends ASTVisitor
{

	public boolean visit(TypeDeclaration node)
	{
		System.out.printf("[%s]%n",ASTTool.getKind(node));
		System.out.printf("name:%s%n",ASTTool.getFullyQualifiedClassName(node));
		System.out.print("modifier:");
		for(Iterator<String> iter=ASTTool.getModifiers(node).iterator();iter.hasNext();){
			String mod=iter.next();
			if(iter.hasNext()){
				System.out.print(mod+",");
			}else{
				System.out.print(mod);
			}
		}
		System.out.printf("%nrange:%d,%d%n",ASTTool.getStartLineNumber(node),ASTTool.getEndLineNumber(node));
		System.out.printf("super:%s%n",ASTTool.getSuperclassType(node));
		System.out.print("field:");
		for(Iterator<Variable> iter=ASTTool.getFields(node).iterator();iter.hasNext();){
			Variable v=iter.next();
			for(Iterator<String> iter2=ASTTool.getModifiers(v.getModifiers()).iterator();iter2.hasNext();){
				System.out.print(iter2.next()+" ");
			}
			if(iter.hasNext()){
				System.out.print(v.getType()+" "+v.getName()+",");
			}else{
				System.out.print(v.getType()+" "+v.getName());
			}
		}
		System.out.println();
		System.out.println();
		for(Iterator<MethodDeclaration> iter=Arrays.asList(node.getMethods()).iterator();iter.hasNext();){
			printDeclarationState(iter.next());
		}
		return super.visit(node);
	}

	private void printDeclarationState(MethodDeclaration node)
	{
		System.out.printf("[%s]%n",ASTTool.getKind(node));
		System.out.printf("name:%s%n",ASTTool.getFullyQualifiedClassName(node));
		System.out.printf("returnType:%s%n",ASTTool.getReturnType(node));
		System.out.print("modifier:");
		for(Iterator<String> iter=ASTTool.getModifiers(node).iterator();iter.hasNext();){
			String mod=iter.next();
			if(iter.hasNext()){
				System.out.print(mod+",");
			}else{
				System.out.print(mod);
			}
		}
		System.out.printf("%narguments:");
		for(Iterator<SingleVariableDeclaration> iter=node.parameters().iterator();iter.hasNext();){
			SingleVariableDeclaration argument=iter.next();
			if(iter.hasNext()){
				System.out.print(argument.getType()+" "+argument.getName()+",");
			}else{
				System.out.print(argument.getType()+" "+argument.getName());
			}
		}
		System.out.printf("%nrange:%d,%d%n%n",ASTTool.getStartLineNumber(node),ASTTool.getEndLineNumber(node));
	}

}
