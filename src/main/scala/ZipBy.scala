package com.xarxaire.griba

object ZipBy {

  import scala.collection.GenIterable
  import scala.collection.generic.CanBuildFrom

  /** 
   * zipBy method injection
   */
  implicit def toZipBy[A](col: GenIterable[A]) = new {

    /** 
     * implementation adapted from Scala.collection library GenIterable.zip()
     *
     * @param f curried function to zip with
     * @param that 
     * @return a collection of the same type with the f-zipped values
     */
    def zipBy[A1 >: A, B, C, That] (f: A1 => B => C) (that: GenIterable[B])(implicit bf: CanBuildFrom[col.type, C, That]): That = {
        val b = bf(col.repr.asInstanceOf[col.type]) 
        val these = col.iterator
        val those = that.iterator
        while (these.hasNext && those.hasNext)
          b += (f(these.next) (those.next))
        b.result
      }
  }
}
