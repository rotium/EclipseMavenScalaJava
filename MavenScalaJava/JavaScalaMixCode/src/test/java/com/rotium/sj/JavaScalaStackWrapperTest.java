package com.rotium.sj;

import static org.hamcrest.core.Is.is;

import java.util.NoSuchElementException;

import org.junit.Assert;
import org.junit.Test;

import com.rotium.sj.java.ScalaStackWrapper;
import com.rotium.sj.java.Stack;

public class JavaScalaStackWrapperTest {

	private Stack<String> getStack(int c) {
		Stack<String> s = new ScalaStackWrapper<String>();
		for (int i = 1; i <= c; i++) {
			s.push("i"+i);
		}
		Assert.assertThat(s.size(), is(c));
		return s;
	}
	
	@Test
	public void pushPop() {
		Stack<String> s = new ScalaStackWrapper<String>();
		Assert.assertThat(s.size(), is(0));
		Assert.assertThat(s.isEmpty(), is(true));
		
		s.push("i1");
		Assert.assertThat(s.size(), is(1));
		Assert.assertThat(s.isEmpty(), is(false));
		
		s.push("i2");
		Assert.assertThat(s.size(), is(2));
		Assert.assertThat(s.isEmpty(), is(false));
		
		String pop2 = s.pop();
		Assert.assertThat(s.size(), is(1));
		Assert.assertThat(s.isEmpty(), is(false));
		Assert.assertThat(pop2, is("i2"));
		
		String pop1 = s.pop();
		Assert.assertThat(s.size(), is(0));
		Assert.assertThat(s.isEmpty(), is(true));
		Assert.assertThat(pop1, is("i1"));
	}
	
	@Test
	public void clear() {
		Stack<String> s = getStack(3);
		
		s.clear();
		Assert.assertThat(s.size(), is(0));
		Assert.assertThat(s.isEmpty(), is(true));
	}
	
	@Test
	public void top() {
		Stack<String> s = getStack(3);
		String top = s.top();
		Assert.assertThat(s.size(), is(3));
		Assert.assertThat(s.isEmpty(), is(false));
		Assert.assertThat(top, is("i3"));
	}
	
	@Test(expected=NoSuchElementException.class)
	public void popEmpty() {
		Stack<String> s = new ScalaStackWrapper<String>();
		s.pop();
	}
	
	@Test(expected=NoSuchElementException.class)
	public void topEmpty() {
		Stack<String> s = new ScalaStackWrapper<String>();
		s.top();
	}
}
