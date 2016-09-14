package Utility

/**
  * Created by polpat on 14/7/2559.
  */
object MetricService {
  val um = -6
  val mm = -3
  val cm = -2
  val m = 0
  val km = 3

  def convertDistance(distance:BigDecimal, u1: String, u2: String): BigDecimal = {
    val num1 = getPowDis(u1)
    val num2 = getPowDis(u2)
    return distance * num1 / num2
  }

  def getPowDis(us:String):BigDecimal = us match {
    case "um" => Math.pow(10,um)
    case "mm" => Math.pow(10,mm)
    case "cm" => Math.pow(10,cm)
    case "m" => Math.pow(10,m)
    case "km" => Math.pow(10,km)
  }

}
