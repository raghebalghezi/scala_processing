package proc

import processing.core.PApplet

import scala.util.Random

class tenPrint extends  PApplet{
  /*
  * Ten Print Design Patterns based on BASIC programming language
  * pattern design check https://10print.org and https://youtu.be/Ov0baPrRNkc
  * */
  var x = 0f
  var y = 0f
  val spacing:Float = 20
  override def settings(): Unit = {
    size(400,400)
    //background(0)
  }

  override def draw(): Unit = {

    var r = Random
    //stroke(255)
    if (r.nextFloat() > 0.5f){
      line(x,y,x+spacing,y+spacing)
    } else {
      line(x,y+spacing,x+spacing,y)
    }
    x = x+spacing

    if (x > width){
      x = 0f
      y = y+spacing
    }

  }
}
object tenPrint {
  def main(args: Array[String]): Unit = {
    PApplet.main("proc.tenPrint")
  }
}
