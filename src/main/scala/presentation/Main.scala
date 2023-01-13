package presentation

object Main {
  def f(x: Double): Double = 3 * x * x

  def g(x: Double): Double = 4 * x * x * x

  def main(args: Array[String]): Unit = {
    // Primes
    val primeCalculator = new PrimeCalculator
    val primesList = primeCalculator.calculatePrimesUntil(100)
    primesList.foreach(value => print(value + " "))
    println("\n")

    // Midpoint Formula
    val midpointCalculator = new MidpointCalculator

    val integralV1F = midpointCalculator.midpointV1(f, 2, 4, 1000)
    val integralV2F = midpointCalculator.midpointV2(f, 2, 4, 10)
    println(integralV1F)
    println(integralV2F)
    val integralV1G: Double = midpointCalculator.midpointV1(g, 2, 4, 1000)
    val integralV2G: Double = midpointCalculator.midpointV2(g, 2, 4, 10)
    println(integralV1G)
    println(integralV2G)
  }
}
