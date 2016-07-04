package jme.m2.core;

import jme.m2.output.OutputIndicator;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.TypeDeclaration;


class CodeVisitor extends ASTVisitor
{
	
	public CodeVisitor()
	{
		this.output=new OutputIndicator();
	}
	
	public boolean visit(TypeDeclaration node)
	{
		this.output.printDeclarationState(node);
		return super.visit(node);
	}
	
	private OutputIndicator output;
}
