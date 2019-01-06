
// Defining a class with global variables
// To make variables private, you add the word "private" before their declaration.
// This way, they will no longer be accessible anywhere in the class
// make variables private/global is what encapsultion all about.

class progParadiagm ( val name:String,  val age:Int) /*primary constructor*/{
  //NOTE: whatever is written here, except for method definitions, will be executed
  // this line below will be executed twice b/c there are two instance definitions below
  print("whatever is written in the body of the class will be executed\n")
  // auxiliary constructors are any variables other than above
  def this(name:String)={
    this(name, 100)
  }
  def test():Unit = {
    println(name+" and "+age)
  }
}

object helloWord{
  def showMsg():Unit={
  println("Hello World")
  }
}

object testMyClass {
  def main(args:Array[String]):Unit = {
    // create an instance m of class myClass
    val m = new progParadiagm("ragheb", 29)
    m.test()
    //Using the aux constructor, we don't have to define age b/c we hardcode it in the aux constructor above
    // we can add/ override it nevertheless
    val m2 = new progParadiagm("Ali")
    m2.test()
    //    // to access global variables anywhere in the code, you can simply write Class_name.variable
    println(m.name)
    println(m.age)
    // Static aka Singleton: you call an object from another object. i.e. objects, like classes, can be called
    // printing static object without instantiation or class declaration
    helloWord.showMsg()
  }
}

