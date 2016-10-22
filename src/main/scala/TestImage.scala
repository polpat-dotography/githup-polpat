import java.io.File
import javax.imageio.ImageIO
import java.awt.{Color, Font, Image}
import java.awt.image.{BufferedImage, CropImageFilter, FilteredImageSource}
import java.util.Date

import Utility.MetricService._
import Utility.ImageHelper._
import Utility.FancyLog._
/**
  * Created by polpat on 22/8/2559.
  */
object testImage extends App {

  var writeFile = true

  var rootU = "/home/polpat/pic/"
  var rootW = "D:/Picture/scala/"

  val rootPath = rootW

  val f1 = "/home/polpat/pic/Pentagon_shape_black2.png"
  val f2 = "/home/polpat/pic/flame_PNG13218.png"
  val f3 = "/home/polpat/pic/004.jpg"

  val fp1 = "D:/Picture/01/12991022_777732232357413_473763123432125400_n.jpg"

  val photo1 = fp1
  val overlay = f2


  // set list of path/effect
  val effectList = List("default", "gray", "inverse", "red", "green", "blue")


  // make photo effect

  //val photo2 = photoEffect(photo1, "gray")

  //val photo2 = mergeImage(apply(f1), apply(f2))

  var photo2 = concatImage(List(photo1,photo1,photo1,photo1), effectList, 3, 2, 400, 300)
  photo2 = waterMark(photo2, "@polpat")

  //val photo2 = borderOutImage(apply(photo1), 2, 2)

  // write file in function
//  writeFile = false
//  val photo2 = splitImage(apply(photo1), 400, 400, rootPath)



  //write image
  if(writeFile) {
    ImageIO.write(photo2, "png", new File(rootPath + randomName("pae") + ".png"))
  }








}

