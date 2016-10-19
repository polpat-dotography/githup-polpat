/**
  * Created by polpat on 19/10/2559.
  */
import Utility.FancyLog._


object TestStringCase extends App {

  printlnG("abc")

  var tmp = "id: Option[Long] = None,\n  category: Int,\n  address_1: String,\n  address_2: String,\n  address_3: String,\n  city: String,\n  state: String,\n  country: Int,\n  post_code: String,\n  is_primary: Boolean = false"

  tmp = tmp.filter(_ >= ' ')

  println("tmp : " + tmp)

  val result = convertCC(tmp, "camel")
  printlnC("camel : " + result)
  val result2 = convertCC(result, "snake")
  printlnM("snake : " + result2)


  def convertCC(source: String, t: String): String = {
    val arr = source.split(",").map{ x => convert(x.split(":")(0), t) + ":" + x.split(":")(1) + ","}
    val res1 = arr.mkString("")
    val res2 = res1.substring(0, res1.length-1)
    //printlnG(res2)
    res2
  }

  def convert(s: String, t: String): String = {
    t match {
      case "upper" => s.toUpperCase
      case "lower" => s.toLowerCase
      case "snake" => s.replaceAll("([A-Z]+)([A-Z][a-z])", "$1_$2").replaceAll("([a-z\\d])([A-Z])", "$1_$2").toLowerCase
      case "camel" => {
        def loop(x : List[Char]): List[Char] = (x: @unchecked) match {
          case '_' :: '_' :: rest => loop('_' :: rest)
          case '_' :: c :: rest => Character.toUpperCase(c) :: loop(rest)
          case '_' :: Nil => Nil
          case c :: rest => c :: loop(rest)
          case Nil => Nil
        }
        if (s == null)
          ""
        else
          loop('_' :: s.toList).mkString
      }
    }

  }
}
