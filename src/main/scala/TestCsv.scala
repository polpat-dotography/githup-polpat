/**
  * Created by polpat on 25/10/2559.
  */
import Utility.FancyLog._

object TestCsv extends App {

  case class PersonData(name: String, age: String, sex: String)
  var listData: List[PersonData] = Nil
  var size = 0

  println("Month, Income, Expenses, Profit")
  val bufferedSource = scala.io.Source.fromFile("/home/polpat/testfile/file1.csv")
  for (line <- bufferedSource.getLines) {
    val cols = line.split(",").map(_.trim).toList
    // do whatever you want with the columns here
    println(s"${cols(0)}|${cols(1)}")

    val person = PersonData(cols(0), cols(1), cols(2))

    // add item at end of list, if add to head use ::
    listData = listData :+ person
  }
  bufferedSource.close

  for(i <- 1 until listData.length) {
    printlnG("name : " + listData(i).name)
    printlnG("age : " + listData(i).age)
    printlnG("sex : " + listData(i).sex)
  }


}
