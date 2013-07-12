package com.rotium.sj.java;

import java.util.Iterator;

public interface Stack<T> extends Iterable<T> {

	int size();
	T pop();
	void push(T t);
	void clear();
	boolean isEmpty();
	T top();
	Iterator<T> iterator();
}
