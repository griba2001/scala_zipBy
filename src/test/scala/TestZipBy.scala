package test

object TestZipBy extends Application {

  import com.xarxaire.griba.ZipBy.toZipBy
  
  val li= (1 to 3).toList
  val li2 = li

  def sumInts (x:Int) (y:Int) = x+y
  val sumInts2 : (Int, Int) => Int = _ + _
 
  val res1 = li.zipBy (sumInts _) (li2)
  val res2 = li.zipBy (sumInts2.curried) (li2)

  println( res1.toList)  
  println( res2.toList)  
}