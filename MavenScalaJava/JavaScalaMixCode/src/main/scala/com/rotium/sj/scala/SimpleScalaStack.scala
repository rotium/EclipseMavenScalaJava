package com.rotium.sj.scala

import scala.annotation.tailrec
import com.rotium.sj.java.immutable.ImmutableNode
import com.rotium.sj.java.Stack

/**
 * This is far from idiomatic scala code. IT it just a copy of the Java code, so 
 * the tests will be the same.
 */
class SimpleScalaStack[T] extends Stack[T] {
  private var head: ImmutableNode[T] = null

  def clear(): Unit = head = null

  def isEmpty(): Boolean = (head == null)

  def iterator(): java.util.Iterator[T] = ???

  def pop(): T =
    if (!isEmpty()) {
      val t = head.getItem();
      head = head.getNext();
      t
    } else throw new NoSuchElementException("Stack is empty");

  def push(t: T): Unit = head = ImmutableNode.create(t, head);

  def size(): Int = {
    @tailrec
    def calcSize(p: ImmutableNode[T], c: Int): Int =
      if (p != null) calcSize(p.getNext(), c + 1) else c
    calcSize(head, 0)
  }

  def top(): T =
    if (!isEmpty()) {
      return head.getItem();
    } else throw new NoSuchElementException("Stack is empty");

}