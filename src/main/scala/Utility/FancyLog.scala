package Utility

/**
  * Created by polpat on 14/9/2559.
  */
object FancyLog {
  private def printlnColored( color: String, msg: String ): Unit = println(color + msg + Console.RESET)

  def printlnR(msg: String): Unit = printlnColored(Console.RED, msg)
  def printlnB(msg: String): Unit = printlnColored(Console.BLUE, msg)
  def printlnG(msg: String): Unit = printlnColored(Console.GREEN, msg)
  def printlnY(msg: String): Unit = printlnColored(Console.YELLOW, msg)
  def printlnC(msg: String): Unit = printlnColored(Console.CYAN, msg)
  def printlnM(msg: String): Unit = printlnColored(Console.MAGENTA, msg)


  def printWarn(msg: String): Unit = printlnY("WARN: " + msg)
  def printInfo(msg: String): Unit = printlnB("INFO: " + msg)
  def printErr(msg: String): Unit = printlnR("ERRO: " + msg)
  def printSucc(msg: String): Unit = printlnG("SUCC: " + msg)
}