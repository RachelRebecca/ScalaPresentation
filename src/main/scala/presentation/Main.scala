package presentation

object Main {

  def main(args: Array[String]): Unit = {
    // Primes
    val primeCalculator = new PrimeCalculator
    val primesList = primeCalculator.calculatePrimesUntil(100)
    primesList.foreach(value => println(value))

    // Midpoint Formula
    val midpointCalculator = new MidpointCalculator
    // TODO: when n = 10, integralV1 is 66 not 56
    val integralV1 = midpointCalculator.midpointV1(2, 4, 1000)
    val integralV2 = midpointCalculator.midpointV2(2, 4, 10)
    println(integralV1)
    println(integralV2)
  }
}
