package test

import org.scalatest.junit.JUnitSuite
import org.junit.Test
import org.junit.Before

class SimpleSuite extends JUnitSuite {

  import com.xarxaire.griba.ZipBy.toZipBy

  var li: List[Int] = Nil
  var li2: List[Int] = Nil

  def sumInts (x:Int) (y:Int) = x+y
  val sumInts2 : (Int, Int) => Int = _ + _

  @Before def initialize() {
    li= (1 to 3).toList
    li2 = (1 to 4).toList
  }

  @Test def verify() { // Uses ScalaTest assertions
    val iter1 = li.zipBy (sumInts _) (li2)
    val iter2 = li.zipAllBy (sumInts2.curried) (li2, 4, 4)
    assertResult (List(2,4,6)) (iter1.toList)
    assertResult (List(2,4,6,8)) (iter2.toList)
  }

}