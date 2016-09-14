val word = "M"

val Pattern = "([a-zA-Z])".r
word match {
  case Pattern(c) => List(c.toString)
  case _ => List("err")
}



//val a = Range(1,10)
//val k = a.filter(x => x>5)
//k.toList
//var st = "fsdlkfgbA"
//st = st.replaceAll("sd","ww")
//st = st.reverse
//st.charAt(3)
//st.codePointAt(0)
//st.indexOf("ww")
//
//val li = List("c")
//li(0).toInt


//val myMap = Map("MI" → "Michigan", "OH" → "Ohio", "WI" → "Wisconsin", "MI" → "Michigan")
//
//val mapValues = myMap.values
//mapValues.head
//mapValues.last
//myMap("MI")


//val someNumbers = Range(0, 10)
//val second = someNumbers(1)
//val last = someNumbers.last


//def multiply(x: Int, y: Int) = x * y
//(multiply _).isInstanceOf[Function2[_, _, _]]

//def howMuchCanIMake(hours: Int)(implicit dollarsPerHour: BigDecimal) = dollarsPerHour * hours
//implicit val hourlyRate = BigDecimal(34.00)
//howMuchCanIMake(30)


//val s = "Hello World"
//"Application %s".format(s)
//
//val c = '\u0061' //unicode for a
//val d = '\141' //octal for a
//val e = '\"'
//val f = '\\'
//
//val secondElement = List(1, 2, 3) match {
//  case x :: xs ⇒ xs.head
//  case _ ⇒ 0
//}
//val secondElement2 = List(1,2) match {
//  case x :: y :: xs ⇒ xs
//  case _ ⇒ 0
//}
//val r = List(1, 2, 3) match {
//  case x :: y :: Nil ⇒ y
//  case _ ⇒ 0
//}


//val a = List(1, 2, 3)
//val b = List(1, 2, 3)

//val d = Nil
//val c = 3 :: d
//val b = 2 :: c
//val a = 1 :: b
//
//a.tail
//b.tail
//c.tail


//class Living {}
//class Animal extends Living {}
//class Dog extends Animal {}
//
//class Cage[+A] (a: A) {
//  def release: A  = a
//}
//
//val dog = new Dog()
//val animal = new Animal()
//val cAnimal: Cage[Animal] = new Cage(animal)
//val cDog: Cage[Dog] = new Cage(dog)
//
//def uncageAnimal(c: Cage[Animal]):Animal = c.release
//
//uncageAnimal(cAnimal)
//uncageAnimal(cDog)
//
//class Doc[-A] {
//  def treat(a:A) = println("treating "+a.toString)
//}
//val docLiving = new Doc[Living]
//val docAnimal = new Doc[Animal]
//val docDog = new Doc[Dog]
//
//def treatAnimal[A](doc:Doc[A], a:A) = doc.treat(a)
//treatAnimal(docDog,new Animal)