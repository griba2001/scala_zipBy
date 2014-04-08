###Scala utils


```scala
object ZipBy {

  implicit def toZipBy[A](col: GenIterable[A]) = new {

    def zipBy[A1 >: A, B, C, That] (f: A1 => B => C) (that: GenIterable[B])(implicit bf: CanBuildFrom[col.type, C, That]): That
}
```