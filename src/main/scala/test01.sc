import java.util.Date

import com.sun.corba.se.spi.orbutil.fsm.Guard.Result


//def multiply(m:Int)(n:Int):Int = m*n
//implicit val k = 10
//val j = multiply(4)

//def makeUpper(xs: List[String]) = xs map {
//  _.toUpperCase
//}
//def makeWhatEverYouLike(xs: List[String], sideEffect: String ⇒ String) = {
//  xs map sideEffect
//}
//
//val upCase = makeUpper(List("abc","xyz","123"))
//val downCase = makeWhatEverYouLike(List("ABC", "XYZ", "123"), {
//  x ⇒ x.toLowerCase
//})
//val mapL = List("Scala", "Erlang", "Clojure") map {
//  _.length
//}
//val li1 = upCase(1)


//def lamda = { x:Int => x +1 }
//def lamda2 = (x:Int) => x + 1
//def lamda3 = (x:Int) => x + 1
//
//val lamda4 = new Function1[Int, Int] {
//  def apply(v1:Int):Int = v1 + 1
//}
//
//def lamda5(x:Int) = x + 1
//
//val result = lamda(3)
//val `result1andhalf` = lamda.apply(3)
//val result2 = lamda2(3)
//val result3 = lamda3(3)
//val result4 = lamda4(3)
//val result5 = lamda5(3)


//def summation(x:Int, y:Int => Int) = y(x)
//var incrementer = 3
//def closure = (x:Int) => x + incrementer
//val result = summation(10,closure)
//
//incrementer = 4
//val result2 = summation(10,closure)


//val tuple = ("apple","dog")
//val fruit = tuple._1
//val animal = tuple._2
//val tuple2 = ("a", 1, 2.2, new Date(), "five")
//val tp1 = tuple2._4
//val student = ("sean Rogers", 21, 3.5)
//val (name, age, gpa) = student


//object Greeting {
//  def english = "Hi"
//  def espanol = "Hola"
//  def deutsch = "Hallo"
//  def magyar = "Szia"
//}
//Greeting.english
//val x = Greeting
//val y = x
//x eq y
//val z = Greeting
//x eq z


//def maybeItWillReturnSomething(flag: Boolean): Option[String] = {
//  if (flag) Some("Found value") else None
//}
//val value1 = maybeItWillReturnSomething(true)
//val value2 = maybeItWillReturnSomething(false)
//value1 getOrElse "No value"
//value2 getOrElse "No value"
//value2 getOrElse {
//  "default function"
//}


//val someValue: Option[Double] = Some(20.0)
//val value = someValue match {
//  case Some(v) => v
//  case None => 0.0
//}
//val noValue: Option[Double] = None
//val value1 = noValue match {
//  case Some(v) => v
//  case None => 0.0
//}


//val number:Option[Int] = Some(3)
//val noNumber:Option[Int] = None
////val result1 = number.map(_ * 1.5)
////val result2 = noNumber.map(_ * 1.4)
//val result1 = number.fold(0)(_ * 3)
//val result2 = noNumber.fold(2)(_ * 3)


//val a = Option(5)
//def optMatch(x:Option[Any]) = x match {
//  case Some(x:Int) => x
//  case _ => -1
//}
//val b = optMatch(Option("a"))


//val f = getFac(600)
//def getFac(n:BigInt, result:BigInt = 1):BigInt = {
//  if(n == 1) result
//  else getFac(n-1,n*result)
//}








///**
//  * Created by polpat on 24/6/2559.
//  */
//    println("abc")
//
//    def mup(s:String):String =
//    {
//      s.toUpperCase()
//    }
//
//    val fup:String => String = {
//      s => s.toUpperCase()
//    }
//
//    println(fup("ab"))
//
//    val nev = new Person("nev",20)
//    println(nev.intro)
//
//    val max = 10
//    for(i <- 0 to max)
//    {
//      //println("num is " + i)
//    }
//
//    val arr = Array(1,2,3)
//    for(n <- arr)
//    {
//      //println(n)
//    }
//
//    val a = Array(1,2)
//    val Array(one,two) = a
//    println(one+":"+two)
//
//    val Array(o,_) = a
//
//    def concat (a: String, b: String = "cheezburger") =
//      s"$a $b"
//    def greet (greeting: String = "Oh hai", name: String) =
//      s"$greeting, $name"
//
//    println(concat("longcat","sdlkfajsdlkf"))
//
//    println(greet(name="df"))
//
//  val sq1 = Seq(1,2,3)
//  val sq2 = Seq(3,2,1)
//  sq1 == sq2
//
//  //def getGenderUppder(u:User2):String = u.gender.map{_.toUpperCase}.getOrElse("unspecified")
//
//  def process(x:Int) : String = x match
//  {
//    case 1 => "a"
//    case 2 => "b"
//    case i => (i+10).toString()
//    case _ => "Not Found"
//  }
//
//  def process2 (xs:Seq[Int]):String = xs match {
//    case x if x.length > 3 => "Long seq"
//    case x if x.length >= 4 => "got 4: "+x(3)
//    case x @ Seq(a,b,_*) => s"Sequence: $x"
//    case Seq(a,b, _*) => s"Got $a"
//    case Seq(a,b) => s"got $a and $b"
//    case x @ Seq(a:Int,_*) => "List Int"
//    case _ => "whatever"
//  }
//
//
// process2(Seq(1,2,3,4))
//
//  def pr3 (xs: List[Int]) :String = xs match {
//    case x :: y :: _ if x > 2 => s"xs is $xs got $x and $y"
//  }
//  pr3(List(4,2,3))
//
//  def pr4 (xs:Option[Int]) : String  = xs match {
//    case Some(x) => "got something: " +x
//    case None => "nothing"
//
//      pr4(Some(5))
//  }
//
//
//
//class Person(name:String, age:Int) {
//  //def intro = s"Hi $name and $age years"
//  def intro =
//  {
//    def n = name
//    def a = age
//    s"Hi $n andd $a years"
//  }
//}
//
//class User2(name:String, gender:Option[String])
//{
//  //val john = User2("John", Some("Male"))
//
//}
//
//class User(name:String, age:Int) {
//
//}