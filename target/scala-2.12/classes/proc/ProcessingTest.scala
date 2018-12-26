package proc
import processing.core.PApplet

import scala.collection.mutable.ArrayBuffer

class ProcessingTest extends PApplet{
  var time:Float = 0
  var wave = ArrayBuffer[Float]()
  var path = ArrayBuffer[Float]()

  override def settings(): Unit ={
    size(600,400)

//    smooth(8)
  }

  override def draw(): Unit = {
    background(0)
    translate(150,200)
    var x:Float=0
    var y:Float=0
    for (i <- 1 to 10){
      var prevx = x
      var prevy = y
      var n = i*2+1
      var radius = 75 * (4/(n*Math.PI))
      x += (radius * Math.cos(n*time)).toFloat
      y += (radius * Math.sin(n*time)).toFloat

      stroke(255,100)
      noFill()
      ellipse(prevx,prevy,x,y)
      stroke(255)
      line(prevx,prevy,x,y)
    }
    wave+=y
    translate(200,0)
    //x-200,y,0,wave(1)
    line(x-200,y,0,wave(0))
    beginShape()
    noFill()
    println(wave.length)
    for (i <- 0 to wave.length){
      println("the value of i\t"+i +"\t"+ wave.length )
      vertex(i,wave(i))

    }
    endShape()
    time += 0.05.toFloat

//    if (wave.length > 250){
////      wave.trimEnd(1)
////      println(wave.length)
//    }

  }
}

object ProcessingTest {
  def main(args: Array[String]): Unit = {
    PApplet.main("proc.proc.ProcessingTest")
  }
}