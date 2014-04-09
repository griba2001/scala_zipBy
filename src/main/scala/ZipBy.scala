package com.xarxaire.griba

object ZipBy {

  import scala.collection.GenIterable
  import scala.collection.mutable.ListBuffer

  /** 
   * zipBy method injection
   */
  implicit def toZipBy[A](col: GenIterable[A]) = new {

    /** 
     * implementation adapted from Scala.collection library GenIterable.zip()
     *
     * @param f curried function to zip with
     * @param that 
     * @return a ListBuffer with the f-zipped values
     */
    def zipBy[A1 >: A, B, C] (f: A1 => B => C) (that: GenIterable[B]): ListBuffer[C] = {
        val b = ListBuffer.empty[C]
        val these = col.iterator
        val those = that.iterator
        while (these.hasNext && those.hasNext)
          b += (f(these.next) (those.next))
        b
      }
  }
}