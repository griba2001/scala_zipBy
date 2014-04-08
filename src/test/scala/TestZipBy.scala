package test

object TestZipBy extends Application {

  import com.xarxaire.griba.ZipBy.toZipBy
  
  val li= (1 to 3).toList
  val li2 = li
  def sumInts (x:Int) (y:Int) = x+y 
  val res1 = li.zipBy (sumInts _) (li2)
  val res2 = li.zipBy ((x:Int) => (y:Int) => x+y) (li2)
  println( res1)  
  println( res2)  
}