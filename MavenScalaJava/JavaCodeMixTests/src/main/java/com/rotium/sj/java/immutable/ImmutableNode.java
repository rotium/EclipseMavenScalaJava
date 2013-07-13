package com.rotium.sj.java.immutable;

public class ImmutableNode<T> {
	private final T item;
	private final ImmutableNode<T> next;
	
	public ImmutableNode(T item, ImmutableNode<T> next) {
		this.item = item;
		this.next = next;
	}

	public T getItem() {
		return item;
	}

	public ImmutableNode<T> getNext() {
		return next;
	}
	
	public static <T> ImmutableNode<T> create(T item, ImmutableNode<T> next) {
		return new ImmutableNode<T>(item, next);
	}
}
