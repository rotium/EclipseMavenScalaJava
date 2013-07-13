package com.rotium.sj.scala

import com.rotium.sj.java.SimpleJavaStack

object ScalaMain extends App {
  def javaStack(c: Int): Unit = {
    val stack = new SimpleJavaStack[Int]();

    (1 to c) foreach { i => stack.push(i) }
    while (!stack.isEmpty()) {
      stack.pop();
    }
  }

  def scalaStack(c: Int): Unit = {
    val stack = new SimpleScalaStack[Int]();

    (1 to c) foreach { i => stack.push(i) }
    while (!stack.isEmpty()) {
      stack.pop();
    }
  }

  val count = 100000;

  val scalaStart = System.currentTimeMillis();
  scalaStack(count)
  val scalaEnd = System.currentTimeMillis();
  println("Scala Stack: " + (scalaEnd - scalaStart) + " ms.")

  val javaStart = System.currentTimeMillis();
  javaStack(count)
  val javaEnd = System.currentTimeMillis();
  println("Java Stack: " + (javaEnd - javaStart) + " ms.")
}