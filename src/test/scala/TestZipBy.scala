package test

import org.scalatest.junit.JUnitSuite
import _root_.org.junit.Test
import _root_.org.junit.Before

class SimpleSuite extends JUnitSuite {

  import com.xarxaire.griba.ZipBy.toZipBy

  var li: List[Int] = _   // (1 to 3).toList
  var li2: List[Int] = _ // (1 to 4).toList

  def sumInts (x:Int) (y:Int) = x+y
  val sumInts2 : (Int, Int) => Int = _ + _

  @Before def initialize() {
    li= (1 to 3).toList
    li2 = (1 to 4).toList
  }

  @Test def verify() { // Uses ScalaTest assertions
    val it1 = (li.zipBy (sumInts _) (li2)).toList
    val it2 = (li.zipAllBy (sumInts2.curried) (li2, 4, 4)).toList 
    assertResult (List(2,4,6)) (it1)
    assertResult (List(2,4,6,8)) (it2)
  }

}