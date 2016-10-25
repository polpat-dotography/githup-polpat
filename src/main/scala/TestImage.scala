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

  val rootPath = rootU

  val f1 = "/home/polpat/pic/Pentagon_shape_black2.png"
  val f2 = "/home/polpat/pic/flame_PNG13218.png"
  val f3 = "/home/polpat/pic/004.jpg"

  val fp1 = "D:/Picture/01/12991022_777732232357413_473763123432125400_n.jpg"
  val fp2 = "D:/Picture/01/o5yojzkhml1ZPbnRYw2-o.jpg"

  val photo1 = f1
  val overlay = f1


  // set list of path/effect
  val effectDefaul = List("default")
  val effectList = List("default", "gray", "inverse", "red", "green", "blue", "bright", "dark")


  // make photo effect

  //val photo2 = photoEffect(photo1, "gray")

  //val photo2 = mergeImage(apply(f1), apply(f2))

//  var photo2 = concatImage(apply(List(photo1,photo1,photo1,photo1)), effectList, 3, 2, 400, 300)
//  photo2 = waterMark(photo2, "@polpat")

  //val photo2 = borderOutImage(apply(photo1), 2, 2)

  //val photo2 = getBinaryAuto(apply(photo1))
  //val photo3 = photoEffect(apply(photo1), "binary")

  // write file in function
  //writeFile = false
//  val photo2 = splitImage(apply(photo1), effectList, 128, 128, rootPath)
  val photo2 = splitEffect(apply(photo1), effectList, 64, 128, rootPath)






  //write image
  if(writeFile) {
    ImageIO.write(photo2, "png", new File(rootPath + randomName("pae") + ".png"))
    //ImageIO.write(photo3, "png", new File(rootPath + randomName("pae-old") + ".png"))
  }








}

