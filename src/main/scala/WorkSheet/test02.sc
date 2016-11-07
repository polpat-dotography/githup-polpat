import scala.util.{Try,Success}
import java.util.Calendar


case class User2(name:String, gender:Option[String])

object UserRepo {
  val users = Map (
    0 -> User2("John", Some("male")),
    1 -> User2("Mary", Some("female")),
    2 -> User2("Cthulu", None)
    )
  def find(idx:Int):Option[User2] = users.lift(idx)
}

//val up = UserRepo.find(0).flatMap {u => u.gender} getOrElse()
//up.toString.toUpperCase()

UserRepo.find(0).flatMap {u => u.gender}.map {_.toUpperCase}

for{
  u <- UserRepo.find(2)
  g <- u.gender
} yield g.toUpperCase()

val numList = Set(1,2,3,4)
numList.take(2)

val numf = 6.7
printf("Number is %f",numf)

val hostPort = ("localhost", 80)
hostPort._1

val l1 = List(1,2,3,4,5,6)
val l2 = List(3,5,7,8)

val r1 = l1.map((i:Int) => i+10)

val r2 = l1 filter {
  x => x > 4
} map ((y:Int) => y*y)

val r3 = l1.foldLeft("0"){(x,y) => x + ":" + y}
val r4 = l1.reduce {(x,y) => x+y}
val r5 = l1.reduceLeft{(x,y) => x+y}

def mathTest(x:Int):String = x match {
  case 1 => "one"
  case 2 => "two"
  case _ => "what"
}
val r6 = mathTest(3)

val df = new java.text.SimpleDateFormat("dd/MM/yyyy HH:mm:ss")
val calendar = Calendar.getInstance()
//calendar.clear()
calendar.set(Calendar.MONTH, 7)
calendar.set(Calendar.YEAR, 2014)
val dt = calendar.getTime()
//val dd = df.format(new java.util.Date())
val dd = df.format(dt)


val t1 = Calendar.getInstance()
t1.set(2016,0,31,0,0,0)
t1.getTime

val t2 = Calendar.getInstance()
t2.set(2016,0,32,0,0,0)
t2.getTime

