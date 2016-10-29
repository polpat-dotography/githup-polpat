import Utility.FancyLog._
import scala.concurrent.ExecutionContext.Implicits.global

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


    // curry
    def getPerson(name: String)(sex: String = "male"): String = name + " " + sex
    val c = getPerson("abc")()
    val d = getPerson("Mary")("female")
    printlnM("C : " + c + ", D : " + d)


    // partially
    def wrap(prefix: String, html: String, suffix: String) = {
      prefix + html + suffix
    }
    def wrapWithDiv = wrap("<div>", _: String, "</div>")
    printlnG(wrapWithDiv("<p>hello</p>"))


    // partial
    val more100: PartialFunction[Int, String] = {
      case x if x > 100 => x+" is > 100"
    }
    val isEven: PartialFunction[Int, String] = {
      case x if x % 2 == 0 => x+" is even"
    }
    val isOdd: PartialFunction[Int, String] = {
      case x if x % 2 == 1 => x+" is odd"
    }
    val even = List(1, 2, 3, 4, 5, 200) map (more100 orElse isEven orElse isOdd)
    printlnC("Even : " + even.toString)


    // compose
    def compose[A,B,C](f: B => C, g: A => B): A => C = {
      a: A => f(g(a))
    }
    val composeNumber = compose((x: Int) => x+1, (y: Int) => y-1)(_: Int)
    val partNumber = composeNumber(20)
    val numResult = compose((x: Int) => x+1, (y: Int) => y-1)(10)
    printlnY("Num : " + numResult + ", Part : " + partNumber)

  }



}