import java.io.File
import javax.imageio.ImageIO
import java.awt.image.BufferedImage
import java.awt.Image
import Utility.FancyLog._
/**
  * Created by polpat on 22/8/2559.
  */
object testList extends App {

  def phototest(img: BufferedImage): BufferedImage = {
    // obtain width and height of image
    val w = img.getWidth
    val h = img.getHeight

    // create new image of the same size
    var out = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB)

    // copy pixels (mirror horizontally)
    for (x <- 0 until w) {
      for (y <- 0 until h) {
        //printlnY(img.getRGB(w - x - 1, y).toString)
        //out.setRGB(x, y, img.getRGB(w - x - 1, y) & 0xffffff)

          //0xffffff - img.getRGB(x,y)

        val p = img.getRGB(x, y)

        val a = (p>>24)&0xff
        var r = (p>>16)&0xff
        var g = (p>>8)&0xff
        var b = p&0xff

        //black and white
//        r = getBinary(r)
//        g = getBinary(r)
//        b = getBinary(r)

        //gray
//        r = r
//        g = r
//        b = r


        val cList = getColorValue(r,g,b,"cyan")

        //println("new : "+newRGB)

        val newRGB = (a<<24) | (cList(0)<<16) | (cList(1)<<8) | cList(2)
        out.setRGB(x, y, newRGB)
      }
    }
    println(0xffffff)

    // draw red diagonal line
//    for (x <- 0 until (h min w))
//      out.setRGB(x, x, 0xff0000)


    //crop image
    //out = out.getSubimage(0,0,200,200)

    //resize
    out = resizeImage(out, 400, 400)

    //return
    out
  }

  def resizeImage(img: BufferedImage, width: Int, height: Int): BufferedImage = {
    val tmp = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
    val imgNew = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
    val g2d = imgNew.createGraphics()
    g2d.drawImage(tmp, 0, 0, null)
    g2d.dispose()
    imgNew
  }

  def getBinary(color:Int, threshold:Int):Int = {
      if(color > threshold)
        {
          255
        }
      else
        {
          0
        }
  }
  def getColorValue(red:Int, green:Int, blue:Int, cat:String):List[Int] = {
    cat match {
      case "binary" => List(getBinary(red,127),getBinary(red,127),getBinary(red,127))
      case "gray" => List(red,red,red)
      case "red" => List(255,red,red)
      case "green" => List(green,255,green)
      case "blue" => List(blue,blue,255)
      case "yellow" => List(255,255,red)
      case "magenta" => List(255,red,255)
      case "cyan" => List(red,255,255)
    }
  }

  val li = List(1,2,4)
  println(li)

  val photo1 = ImageIO.read(new File("/home/polpat/pic/001.png"))
  printlnC(photo1.toString)
  printf("Photo size is %d x %d\n", photo1.getWidth, photo1.getHeight)

  val photo2 = phototest(photo1)

  ImageIO.write(photo2, "png", new File("/home/polpat/pic/test.png"))


}

