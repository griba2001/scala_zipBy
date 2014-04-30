package com.xarxaire.griba

/** 
  * zipBy method injection
  *
  * zip methods implementation adapted from Scala.collection library GenIterable.zip()
  */
object ZipBy {

  import scala.collection.GenIterable


  class ToZipBy[A](col: GenIterable[A]) {

    /** 
     *
     * @param f curried function to zip with
     * @param that 
     * @return an Iterator with the f-zipped values
     */
    def zipBy[A1 >: A, B, C] (f: A1 => B => C) (that: GenIterable[B]): Iterator[C] = new Iterator[C] {

        private val these = col.iterator
        private val those = that.iterator

        def hasNext = these.hasNext && those.hasNext

        def next() = f (these.next) (those.next)
      }

    def zipAllBy[A1 >: A, B, C] (f: A1 => B => C) (that: GenIterable[B], thisElem: A, thatElem: B): Iterator[C] = new Iterator[C] {

        private val these = col.iterator
        private val those = that.iterator

        def hasNext = these.hasNext || those.hasNext

        def next() = {
             val x = if (these.hasNext) these.next else thisElem
             val y = if (those.hasNext) those.next else thatElem
          
             f (x) (y)
             } 
      }
  }

  implicit def toZipBy[A](col: GenIterable[A]) = new ToZipBy (col)
}