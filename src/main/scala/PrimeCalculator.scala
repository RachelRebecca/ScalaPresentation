import scala.collection.mutable.ListBuffer

class PrimeCalculator {

  def calculatePrimesUntil(number: Int): ListBuffer[Int] = {
    val primes = new ListBuffer[(Int)]()

    for (i <- 2 to number) {
      if (isPrime(i)) {
        primes.append(i)
      }
    }

    primes
  }

  private def isPrime(n: Int): Boolean = {
    var result = true
    if (n == 1) result = false

    for (i <- 2 to n / 2) {
      if (n % i == 0) {
        result = false
      }
    }
    result
  }
}
