package proc
import processing.core.PApplet

import scala.collection.mutable.ArrayBuffer


class ProcessingTest extends PApplet{
  // Visualization of Fourier Series using Processing Module
  var time:Float = 0
  var wave = ArrayBuffer[Float]()
  var path = ArrayBuffer[Float]()
  // slide values can span from 0 to 50 incremented by 5 to give different effects
  val slide:Int = 5
  override def settings(): Unit ={
    size(600,400)
  }

  override def draw(): Unit = {
    background(0)
    translate(150,200)
    var x:Float=0
    var y:Float=0
    for (i <- 1 to slide){
      var prevx = x
      var prevy = y
      var n = i*2+1
      var radius:Float = (75 * (4/(n*Math.PI))).toFloat
      x += (radius * Math.cos(n*time)).toFloat
      y += (radius * Math.sin(n*time)).toFloat

      stroke(255)
      noFill()
      ellipse(prevx,prevy,radius*2,radius*2)
      stroke(255)
      line(prevx,prevy,x,y)
    }
    wave+=y
    translate(200,0)
    line(x-200,y,0,wave(0))
    beginShape()
    noFill()
    beginShape()
    // nice equivalnt to Python's enumerate method!
    for ((elem, i) <- wave.zipWithIndex) {
      vertex(i, elem)
    }

    endShape()
    time += 0.05.toFloat

    if (wave.length > 250){
      wave.trimEnd(1)
    }

  }
}

object ProcessingTest {
  def main(args: Array[String]): Unit = {
    PApplet.main("proc.ProcessingTest")
  }
}