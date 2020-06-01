package com.bsuir.epam.scala.lab6;
@tailrec
  def foldl[A, B](f: (B, A) => B, a: B, c: List[A]): B = c match {
    case Nil => a
    case r :: rest => foldl(f, f(a, r), rest)
  }

  def filter[A](in: List[A], pred: A => Boolean): List[A] = in match {
    case a :: rest if pred(a) => a :: filter(rest, pred)
    case _ :: rest => filter(rest, pred)
    case Nil => List()
  }

  def reduce[A](in: List[A], f: (A, A) => A): A = in match {
    case Nil => throw new RuntimeException("Reduce on empty list")
    case a :: rest => foldl[A, A](f, a, rest)
  }

  /** part 1. depends on *foldl* **/
  def to_set[A](in: List[A]): List[A] =
    foldl[A, List[A]]((list, x) => if (!list.contains(x)) list.appended(x) else list, List(), in)

  /** part 2. depends on foldl **/
  def size[A](in: List[A]): Int =
    foldl[A, Int]((x, _) => x + 1, 0, in)

  def mean(in: List[Double]): Double =
    foldl[Double, Double]((x, y) => x + y, 0.0, in) / size(in).toDouble

  /** part 3. depends on foldl, reduce and filter **/
  def join_text(in: List[String]): String =
    reduce[String](
      filter[String](in, x => x.nonEmpty && x.head.isUpper), (x, y) => x + " " + y)

  def main(args: Array[String]): Unit = {
    println(mean(List(1,2, 3)))
    println(to_set(List(1,2, 3, 2, 3, 1, 2,3)))
    println(join_text(List("Hey!", "I am a", "lazy but", "Clever", "Guy!")))
  }