package syntax

class Notes {
  private val field = 1000

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
    println("field accessed from within main: " + field)

    // blocks - the {} turns this statement into a block statement
    println({
      val x = 1 + 1
      x + 1 // this is the result
    }) // 3

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

    // multiline method, notice how its declared inside a method
    def getSquareString(input: Double): String = {
      val square = input * input
      square.toString // return statement goes here, last line
    }

    println(getSquareString(2.5)) // 6.25

    // string interpolation
    val nameExample = "James"
    // add s - allows the usage of variables directly in the string
    println(s"Hello, $nameExample")
    println(s"1 + 1 = ${1 + 1}")
    // must escape the dollar sign
    println(s"New offers starting at $$14.99")
    // triple double quotes escapes the double quote
    val person = s"""{"name":$nameExample}"""
    println(person)
    val height = 1.9d
    // f allows the creation of simple formatted strings, similar to printf
    println(f"$nameExample%s is $height%2.2f meters tall")
    // raw vs s
    println(s"a\nb")
    println(raw"a\nb")

    // for loops
    for (a <- 1 to 3) {
      println("Value of a: " + a);
    }

    // 2D for loop
    for {
      i <- 1 to 3
      j <- 1 to 3
    } println(s"i = $i, j = $j")

    // while loops
    var a = 15
    while (a < 20) {
      println("While loop value of a: " + a);
      a = a + 1
    }

    // classes
    // syntax: class keyword, name, constructor parameters
    class Greeter(prefix: String, suffix: String) {
      // note :Unit means void
      def greet(name: String): Unit =
        println(prefix + " " + name + " " + suffix)
    }

    val greeter = new Greeter("Hello,", "!")
    greeter.greet("Rachel Nemesure")

    // case classes
    /*
    By default, instances of case classes are immutable,
    and they are compared by value
    (unlike classes, whose instances are compared by reference)
     */
    // syntax: case class keyword, name, parameter list
    case class Point(x: Int, y: Int)
    // case classes do not need to be instantiated with the new keyword
    val point = Point(1, 2)
    val anotherPoint = Point(1, 2)
    val yetAnotherPoint = Point(2, 2)

    // notice the == rather than .equals()
    if (point == anotherPoint) {
      // notice the automatic toString method
      println(s"$point and $anotherPoint are the same.")
    } else
      println(s"$point and $anotherPoint are different.")

    if (point == yetAnotherPoint)
      println(s"$point and $yetAnotherPoint are the same.")
    else
      println(s"$point and $yetAnotherPoint are different.")

    println(point.toString)

    class A(var name: String, id: Int)
    case class B(name: String, id: Int)

    // objects - single instances of their own definitions
    object Test {
      val a1 = new A("a", 1)
      val a2 = new A("a", 1)
      println(s"a1 == a2: ${a1 == a2}")

      // notice how this is accessed - because of the var keyword
      println("a1 name: " + a1.name)

      // notice that case class override equals for you
      val b1 = B("b", 1)
      val b2 = B("b", 1)

      // notice that this is accessed without the var keyword
      println("b1 name: " + b1.name)

      println(s"b1 == b2: ${b1 == b2}") //this returns true
    }
    Test // note all I need to do is call the object and it runs

    // TODO: switch A to syntax.A2

    // traits
    /*
    Traits are abstract data types containing certain fields and methods.
    In Scala inheritance, a class can only extend one other class,
    but it can extend multiple traits.
     */
    trait GreeterTrait {
      def greet(name: String): Unit =
        println("Hello, " + name + "!")
    }
    class DefaultGreeter extends GreeterTrait
    class CustomizableGreeter(prefix: String, postfix: String) extends GreeterTrait {
      // note the use of the override keyword
      override def greet(name: String): Unit =
        println(prefix + name + postfix)
    }

    val defaultGreeter = new DefaultGreeter()
    defaultGreeter.greet("Scala developer")

    val customGreeter = new CustomizableGreeter("How are you, ", "?")
    customGreeter.greet("Scala developer")
  }

  def play(y: Int): Int = {
    val x = y
    println("field accessed from within play: " + field)
    x * x
  }
}

object Notes {
  def main(args: Array[String]): Unit = {
    // TODO: Add program arguments
    println("Hello " + args.mkString(" "))
    println(args.length)
    // notice the parentheses to access the first index of args array
    println(args(0))

    // NOTE: class instantiation doesn't need ()
    val notesClass = new Notes
    notesClass.notes() // runs basic overview of Scala
  }
}
