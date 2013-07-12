package com.rotium.sj.java;

import static com.rotium.sj.java.immutable.ImmutableNode.ImmutableNode;

import java.util.Iterator;
import java.util.NoSuchElementException;

import com.rotium.sj.java.immutable.ImmutableNode;

public class SimpleJavaStack<T> implements Stack<T> {
	

	private ImmutableNode<T> head;

	public int size() {
		ImmutableNode<T> p = head;
		int c = 0;
		while (p != null) {
			c++;
			p = p.getNext();
		}
		return c;
	}

	public T pop() {
		T t = null;
		if (!isEmpty()) {
			t = head.getItem();
			head = head.getNext();
		} else {
			throw new NoSuchElementException ("Stack is empty");
		}
		return t;
	}

	public void push(T t) {
		head = ImmutableNode(t, head);
	}

	public void clear() {
		head = null;
	}

	public boolean isEmpty() {
		return (head == null);
	}

	public T top() {
		if (!isEmpty()) {
			return head.getItem();
		} else {
			throw new NoSuchElementException("Stack is empty");
		}
	}
	
	public Iterator<T> iterator() {
		return new Iterator<T>() {
			private ImmutableNode<T> itrHead = head;

			public boolean hasNext() {
				return itrHead != null;
			}

			public T next() {
				T t = null;
				if (itrHead != null) {
					t = itrHead.getItem();
					itrHead = itrHead.getNext();
				} else {
					throw new NoSuchElementException("Stack is empty");
				}
				return t;
			}

			public void remove() {
				next();
			}
		};
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("SimpleStack [");
		if (head != null) {
			sb.append(head.getItem());
			ImmutableNode<T> p = head.getNext();
			while (p != null) {
				sb.append(",").append(p.getItem());
				p = p.getNext();
			}
		}
		return sb.toString();
	}

}
