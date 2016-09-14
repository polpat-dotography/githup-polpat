import Utility.Movie
import Utility.Person.Person

/**
  * Created by polpat on 24/6/2559.
  */
object main
{
  def main(args:Array[String]):Unit=
  {
    val ms = Utility.MetricService
    val km = 10
    val distance = ms.convertDistance(km, "um", "m")
    println(distance)

    val mv = Utility.Movie.academyAward(1932).get
    println("name : "+mv.name + ", year : "+mv.year)

    val clark = new Utility.Person.Person("Clark Kent", "Superman")
    val sp = Utility.Person.showSecret(clark)
    println("Hero : "+sp)


  }



}