/**
  * Created by polpat on 19/10/2559.
  */
import Utility.FancyLog._
import Utility.ConvertCC._


object TestStringCase extends App {

  printlnG("abc")


  var tmp = "id: Option[Long] = None,\n  category: Int,\n  address_1: String,\n  address_2: String,\n  address_3: String,\n  city: String,\n  state: String,\n  country: Int,\n  post_code: String,\n  is_primary: Boolean = false"

  tmp = tmp.filter(_ >= ' ')

  println("tmp : " + tmp)

  val result = convertCC(tmp, "title")
  printlnC("camel : " + result)
  val result2 = convertCC(result, "snake")
  printlnM("snake : " + result2)

}
