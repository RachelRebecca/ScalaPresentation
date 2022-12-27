object Main {
  var public = 1000

  def notes(): Unit = {
    // https://docs.scala-lang.org/tour/tour-of-scala.html
    // Object oriented language because every value is an object
    // Functional language because every function is a value

    // Comments
    // note no semicolons needed
    /*
    A multiline comment goes here
        -> # is not a comment
     */

    // Val vs. var
    // You can explicitly type ex. ": Int" or it can be implied
    val immut: Int = play(10)
    println("val is immutable: " + immut)
    var mutable = 10
    mutable = 20
    println("var is mutable: " + mutable)

    // accessing public fields
    println("public from within main: " + public)

    // blocks - the {} turns this statement into a block statement
    println({
      val x = 1 + 1
      x + 1 // this is the result
    })

    // anonymous functions - can be named, assigned to a variable
    // (x: Int) is the list of parameters with their type
    // x + 1 is the return value
    // => separates them
    val addOne = (x: Int) => x + 1
    println(addOne(1)) // 2

    // methods - add two Int parameters, and return an Int
    // ORDER: def, name, parameter list(s), a return type, and a body
    def add(x: Int, y: Int): Int = x + y
    println(add(1, 2)) // 3

    // multiple parameter lists allowed
    def addThenMultiply(x: Int, y: Int)(multiplier: Int): Int = (x + y) * multiplier
    println(addThenMultiply(1, 2)(3)) // 9

    // no parameters also allowed
    def name: String = System.getProperty("user.name")
    println("Hello, " + name + "!")

    // multiline functions, notice how its declared inside a function
    def getSquareString(input: Double): String = {
      val square = input * input
      square.toString // return statement goes here, last line
    }
    println(getSquareString(2.5)) // 6.25



  }

  def main(args: Array[String]): Unit = {
    println("Hello " + args.mkString(" "))

    // Basic overview of Scala
    notes()

    // Primes
    val calculator = new PrimeCalculator
    val primesList = calculator.calculatePrimesUntil(100)
    primesList.foreach(value => println(value))
  }

  def play(y: Int): Int = {
    val x = y
    println("public from within play: " + public)
    x * x
  }
}