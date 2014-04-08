package test

object TestZipBy extends Application {

  import com.xarxaire.griba.ZipBy._
  
  val li: List[Int] = List(1,2,3)
  val li2 = li
  def sumInts (x:Int) (y:Int) = x+y 
  // val res = li.zipBy (sumInts _) (li2)
  val res = li.zipBy ((x:Int) => (y:Int) => x+y) (li2)
  println( res)  
}