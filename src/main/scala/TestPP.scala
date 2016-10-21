import java.util.Date

/**
  * Created by polpat on 21/10/2559.
  */
object TestCC extends App{

  case class user(name: String , lastName: String, age: Int = 25)

  val a = user("john", "k")
  val b = user("mark", "m", 50)

  println("a : " + a + " : " + toUpper(a))
  println("b : " + b + " : " + b.name)

  println(new Date().getTime)
  println(0 until 4)

  def toUpper(user: user): String =
  {
    user.name.toUpperCase
  }

}
