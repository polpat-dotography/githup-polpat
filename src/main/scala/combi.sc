object comobj {
  println("welcome")

  class Car(_brand:String, val wheel:Int) {
    def run = "ro ro"
    private def brand = "My brand : "+ _brand
  }

  object Car {
    def apply(b:String, w:Int) = new Car(b,w)
  }

  val a = new Car("toyota",40)
}