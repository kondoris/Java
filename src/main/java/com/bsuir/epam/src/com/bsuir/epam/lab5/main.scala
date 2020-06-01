package com.bsuir.epam.scala.lab5;

/** part 1 **/
  def power(in: Int, x: Int): Int = x match {
    case 0 => 1
    case x => power(in, x - 1) * in
  }

  @scala.annotation.tailrec
  def power_tail(in: Int, x: Int, acc: Int = 1): Int = x match {
    case 0 => acc
    case x => power_tail(in, x - 1, in * acc)
  }

  /** part 2 **/
  @tailrec
  def foldl[A, B](f: (B, A) => B, a: B, c: List[A]): B = c match {
    case Nil => a
    case r :: rest => foldl(f, f(a, r), rest)
  }

  def filter(in: List[Int], f: Int => Boolean): List[Int] = in match {
    case x :: rest => (if (f(x)) List(x) else List()) ::: filter(rest, f)
    case Nil => List()
  }

  def filter_tail(in: List[Int], f: Int => Boolean): List[Int] =
    foldl[Int, List[Int]]((list, x) => list ::: (if (f(x)) List(x) else List()), List(), in)

  def filter_squares(in: List[Int], from: Int, to: Int): List[Int] =
    filter(in, x => x * x > from && x * x < to)

  def filter_squares_tail(in: List[Int], from: Int, to: Int): List[Int] =
    filter_tail(in, x => x * x > from && x * x < to)

  def main(args: Array[String]): Unit = {
    println(filter_squares(List(1, 2, 3, 4, 5, 6, 7, 8), 24, 61))
    println(filter_squares_tail(List(1, 2, 3, 4, 5, 6, 7, 8), 24, 61))
    println(power(2, 16))
    println(power_tail(2, 16))
  }