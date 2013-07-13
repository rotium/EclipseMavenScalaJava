package com.rotium.sj.java;

import com.rotium.sj.scala.SimpleScalaStack;

public class JavaMain {

	public void javaStack(int c) {
		Stack<Integer> stack = new SimpleJavaStack<Integer>();
		for (int i = 0; i < c; i++) {
			stack.push(i);
		}
		while (!stack.isEmpty()) {
			stack.pop();
		}
	}
	
	public void scalaStack(int c) {
		Stack<Integer> stack = new SimpleScalaStack<Integer>();
		for (int i = 0; i < c; i++) {
			stack.push(i);
		}
		while (!stack.isEmpty()) {
			stack.pop();
		}
	}
	
	public static void main(String[] args) {
		final int count = 100;
		
		JavaMain javaMain = new JavaMain();
		
		long javaStart = System.currentTimeMillis();
		javaMain.javaStack(count);
		long javaEnd = System.currentTimeMillis();
		
		long scalaStart = System.currentTimeMillis();
		javaMain.scalaStack(count);
		long scalaEnd = System.currentTimeMillis();
		
		System.out.println("Java Stack: "+(javaEnd-javaStart));
		System.out.println("Scala Stack: "+(scalaEnd-scalaStart));
	}
}
