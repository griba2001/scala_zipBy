package com.xarxaire.griba

object ZipBy {

  import scala.collection.GenIterable
  // import scala.collection.mutable.ListBuffer

  /** 
   * zipBy method injection
   */
  implicit def toZipBy[A](col: GenIterable[A]) = new {

    /** 
     * implementation adapted from Scala.collection library GenIterable.zip()
     *
     * @param f curried function to zip with
     * @param that 
     * @return an Iterator with the f-zipped values
     */
    def zipBy[A1 >: A, B, C] (f: A1 => B => C) (that: GenIterable[B]): Iterator[C] = new Iterator[C] {

        private val these = col.iterator
        private val those = that.iterator
        def hasNext = these.hasNext && those.hasNext
        def next() = f(these.next) (those.next)
      }
  }
}