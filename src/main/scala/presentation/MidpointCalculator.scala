package presentation

class MidpointCalculator {
  def midpointV1(func: Double => Double, a: Double, b: Double, n: Int): Double = {
    val width = (b - a) / n
    var sum: Double = 0.0
    for (i <- 0 to n) {
      val ithMidpoint = a +.5 * width + i * width
      sum += func(ithMidpoint)
    }
    width * sum
  }

  def midpointV2(func: Double => Double, a: Double, b: Double, n: Int): Double = {
    val width = (b - a) / n
    var z = a + width / 2
    var sum: Double = 0.0
    while (z < b) {
      sum += func(z)
      z += width
    }
    width * sum
  }
}
