/**
  * Created by OS on 23-Sep-16.
  */
import Utility.FancyLog._


object TestRepeatLevel extends App {

  val str = "hello"
  levelForward(str,2)
  levelBackward(str,2)



  def levelForward(src: String, repeat: Int): Unit = {
    var result = ""
    var count = 0
    for(i <- 0 until src.length*repeat) {
      printlnC(result + src.charAt(count))
      result += src.charAt(count)
      count += 1
      if(count == src.length)
        count = 0
    }
  }

  def levelBackward(src: String, repeat: Int): Unit = {
    var result = src
    for(i <- 0 until repeat-1)
    {
      result = result.concat(result)
    }
    val size = result.length -1
    for(i <- size to 0 by - 1) {
      printlnM(result)
      result = (result.splitAt(result.length - 1))._1
    }
  }

}
