package Utility

/**
  * Created by polpat on 14/7/2559.
  */
object ConvertCC {
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
      case "title" => s.toLowerCase.split(' ').map(_.capitalize).mkString(" ")
    }

  }
}
