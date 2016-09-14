import java.io.File
import javax.imageio.ImageIO
import java.awt.image.BufferedImage
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
    val out = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB)

    // copy pixels (mirror horizontally)
    for (x <- 0 until w)
      for (y <- 0 until h)
        out.setRGB(x, y, img.getRGB(w - x - 1, y) & 0xffffff)

    // draw red diagonal line
    for (x <- 0 until (h min w))
      out.setRGB(x, x, 0xff0000)

    out
  }

  val li = List(1,2,4)
  println(li)

  val photo1 = ImageIO.read(new File("/home/polpat/pic/001.png"))
  printlnC(photo1.toString)
  printf("Photo size is %d x %d\n", photo1.getWidth, photo1.getHeight)

  val photo2 = phototest(photo1)

  ImageIO.write(photo2, "png", new File("/home/polpat/pic/test.png"))


}

