###Scala utils

Method injection of "zip with function" methods zipBy and zipAllBy

```scala
object ZipBy {
  class ToZipBy[A](col: GenIterable[A]) {
    def zipBy[A1 >: A, B, C] (f: A1 => B => C) (that: GenIterable[B]): Iterator[C]
    def zipAllBy[A1 >: A, B, C] (f: A1 => B => C) (that: GenIterable[B], thisElem: A1, thatElem: B): Iterator[C]
  }
implicit def toZipBy[A](col: GenIterable[A]) = new ToZipBy (col)
}
```