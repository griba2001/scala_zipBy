package com.xarxaire.griba

object ZipBy {

  import scala.collection.GenIterable
  import scala.collection.generic.CanBuildFrom

  implicit def toZipBy[A](col: GenIterable[A]) = new {

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
