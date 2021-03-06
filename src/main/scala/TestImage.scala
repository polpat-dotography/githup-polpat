import java.io.File
import javax.imageio.ImageIO
import java.awt.{Color, Font, Image}
import java.awt.image.BufferedImage
import java.util.Date

import Utility.MetricService._
import Utility.FancyLog._
/**
  * Created by polpat on 22/8/2559.
  */
object testImage extends App {

//  val photo1 = ImageIO.read(new File("/home/polpat/pic/004.jpg"))
//  val overlay = ImageIO.read(new File("/home/polpat/pic/002.jpg"))

//  printlnC(photo1.toString)
//  printf("Photo size is %d x %d\n", photo1.getWidth, photo1.getHeight)

  val f1 = "/home/polpat/pic/Pentagon_shape_black2.png"
  val f2 = "/home/polpat/pic/flame_PNG13218.png"
  val f3 = "/home/polpat/pic/004.jpg"

  val photo1 = f3
  val overlay = f2


  // set list of path/effect
  val effectList = List("default", "gray", "inverse", "red", "green", "blue")


  // make photo effect
  //val photo2 = photoEffect(photo1, "gray")
  val photo2 = mergeImage(apply(f1), apply(f2))
  //val photo2 = concatImage(List(photo1,photo1,photo1,photo1), effectList, 3, 2, 400, 300)
  //val photo2 = borderOutImage(apply(photo1), 2, 2)



  //write image
  ImageIO.write(photo2, "png", new File("/home/polpat/pic/" + randomName("pae") + ".png"))






  def photoEffect(img: BufferedImage, effect: String): BufferedImage = {
    // obtain width and height of image
    val w = img.getWidth
    val h = img.getHeight

    // create new image of the same size
    val out = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB)

    // copy pixels (mirror horizontally)
    for (x <- 0 until w) {
      for (y <- 0 until h) {
        //printlnY(img.getRGB(w - x - 1, y).toString)
        //out.setRGB(x, y, img.getRGB(w - x - 1, y) & 0xffffff)

          //0xffffff - img.getRGB(x,y)

        val p = img.getRGB(x, y)

        val a = (p>>24)&0xff
        val r = (p>>16)&0xff
        val g = (p>>8)&0xff
        val b = p&0xff

        //black and white
//        r = getBinary(r)
//        g = getBinary(r)
//        b = getBinary(r)

        //gray
//        r = r
//        g = r
//        b = r


        val cList = getColorValue(r,g,b,effect)


        val newRGB = (a<<24) | (cList(0)<<16) | (cList(1)<<8) | cList(2)
        out.setRGB(x, y, newRGB)
      }
    }
    //println(0xffffff)

    // draw red diagonal line
//    for (x <- 0 until (h min w))
//      out.setRGB(x, x, 0xff0000)


    val newOutput = new BufferedImage(w*2, h*2, BufferedImage.TYPE_INT_RGB)


    //crop image
    //out = cropImage(out,0,0,200,200)

    //resize
    //out = resizeImage(out, 40, 40)

    //return
    out
  }

  def cropImage(img: BufferedImage, x:Int, y:Int, width:Int, height:Int): BufferedImage = {
    var w = width
    var h = height
    if(x + width > img.getWidth()) {
      w = img.getHeight() - x
    }
    if(y + height > img.getHeight()){
      h = img.getHeight() - y
    }
    img.getSubimage(x, y, width, height)
  }

  def resizeImage(img: BufferedImage, width: Int, height: Int): BufferedImage = {
    val tmp = img.getScaledInstance(width, height, Image.SCALE_SMOOTH)
    val imgNew = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB)
    val g2d = imgNew.createGraphics
    g2d.drawImage(tmp, 0, 0, null)
    g2d.dispose()
    imgNew
  }

  def getBinary(color:Int, threshold:Int):Int = {
      if(color > threshold) {255} else {0}
  }
  def getColorValue(red:Int, green:Int, blue:Int, cat:String):List[Int] = {
    val threshold = 80
    cat match {
      case "default" => List(red,green,blue)
      case "binary" => List(getBinary(red,threshold),getBinary(red,threshold),getBinary(red,threshold))
      case "gray" => List(red,red,red)
      case "inverse" => List(255-red,255-green,255-blue)
      case "inverseR" => List(255-red,green,blue)
      case "inverseG" => List(red,255-green,blue)
      case "inverseB" => List(red,green,255-blue)
      case "inverseC" => List(red,255-green,255-blue)
      case "inverseM" => List(255-red,green,255-blue)
      case "inverseY" => List(255-red,255-green,blue)
      case "bright" => List(127+(red/2),127+(green/2),127+(blue/2))
      case "dark" => List(red/2,green/2,blue/2)
      case "red" => List(255,red,red)
      case "green" => List(green,255,green)
      case "blue" => List(blue,blue,255)
      case "yellow" => List(255,255,red)
      case "magenta" => List(255,red,255)
      case "cyan" => List(red,255,255)
    }
  }

  def mergeImage(srcFile: BufferedImage, overlay: BufferedImage): BufferedImage = {
    var srcImg = srcFile
    var overImg = overlay

    // create the new image, canvas size is the max. of both image sizes
//    val w = Math.max(srcImg.getWidth, overImg.getWidth)
//    val h = Math.max(srcImg.getHeight, overImg.getHeight)
//    val combined = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB)

    // create the new image, canvas size follow first image
    val w = srcImg.getWidth
    val h = srcImg.getHeight
    val combined = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB)

    // resize both image
    srcImg = resizeImage(srcImg, w, h)
    overImg = resizeImage(overImg, w, h)

    // paint both images, preserving the alpha channels
    val g = combined.getGraphics
    g.drawImage(srcImg, 0, 0, null)
    g.drawImage(overImg, 0, 0, null)

    // Save as new image
    combined
  }

  def concatImage(image: List[String], effect: List[String], row: Int, col: Int, itemWidth: Int, itemHeight: Int): BufferedImage = {
    val size = row * col
    val width = itemWidth * row
    val height = itemHeight * col
    val result = new BufferedImage(width, height, //work these out
      BufferedImage.TYPE_INT_RGB)
    val g = result.getGraphics
    var x, y = 0
    var indexImage, indexEffect = 0

    for(i <- 0 until size) {
      var bi = ImageIO.read(new File(image(indexImage)))

      bi = resizeImage(bi, itemWidth, itemHeight)
      bi = photoEffect(bi, effectList(indexEffect))
      bi = waterMark(bi, "@dotography")

      g.drawImage(bi, x, y, null)
      x += itemWidth
      indexImage += 1
      indexEffect += 1
      if(x >= result.getWidth()){
        x = 0
        y += bi.getHeight
      }
      if(indexImage >= image.length) {
        indexImage = 0
      }
      if(indexEffect >= effect.length) {
        indexEffect = 0
      }
    }
    result
  }

  def waterMark(srcImg: BufferedImage, msg: String): BufferedImage = {
    val w = srcImg.getWidth
    val h = srcImg.getHeight
    val img = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB)
    val g2d = img.createGraphics
    g2d.drawImage(srcImg, 0, 0, null)
    g2d.setPaint(Color.gray)
    g2d.setFont(new Font("FreeMono", Font.ITALIC, 16))
    val s = msg
    val fm = g2d.getFontMetrics
    val x = img.getWidth - fm.stringWidth(s) - 10
    val y = img.getHeight - fm.getHeight + 10
    g2d.drawString(s, x, y)
    g2d.dispose
    img
  }

  def borderOutImage(srcImg: BufferedImage, borderLeft: Int, borderTop: Int): BufferedImage = {
    val source = srcImg
    val borderedImageWidth = source.getWidth + (borderLeft * 2)
    val borderedImageHeight = source.getHeight + (borderTop * 2)
    val img = new BufferedImage(borderedImageWidth, borderedImageHeight, BufferedImage.TYPE_3BYTE_BGR)
    img.createGraphics
    val g = img.getGraphics
    g.setColor(Color.YELLOW)
    g.fillRect(0, 0, borderedImageWidth, borderedImageHeight)
    g.drawImage(source, borderLeft, borderTop, source.getWidth + borderLeft, source.getHeight + borderTop, 0, 0, source.getWidth, source.getHeight, Color.YELLOW, null)
    img
  }

  def apply(path: String): BufferedImage = ImageIO.read(new File(path))
  def apply(img: BufferedImage) = img
}

