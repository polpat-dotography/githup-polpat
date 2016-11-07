class Car
class Living
class Animal extends Living {
  def sleep = println("Zzz")
}
class Dog extends  Animal {
  override  def sleep = println("Moon moon")
}
class Barn[A <: Animal](animals: A*)

val barnAnimal:Barn[Animal] = new Barn(new Animal(), new Dog())
val barnDog:Barn[Dog] = new Barn(new Dog(), new Dog())