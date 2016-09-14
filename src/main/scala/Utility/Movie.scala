package Utility

/**
  * Created by polpat on 14/7/2559.
  */


  object Movie {
    def academyAward(x:Short) = {
      x match {
        case 1930 => Some(new Movie("All Quiet On the Western Front", 1930))
        case 1931 => Some(new Movie("Cimarron", 1931))
        case 1932 => Some(new Movie("Grand Hotel", 1932))
        case _ => None
      }
    }

    case class Movie (val name: String, val year: Short)
  }

  object Person {

    def showSecret(x: Person) = x.superheroName

    case class Person(val name: String, val superheroName: String)
  }


