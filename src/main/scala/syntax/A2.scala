package syntax

class A2(val name: String, val id: Int) {

  // method taking in a Generic parameter and checking if it is an syntax.A2
  def canEqual(other: Any): Boolean = other.isInstanceOf[A2]


  // method overriding equals method, using a match statement
  // sort of like a switch statement --> switch "other"
  // case that: syntax.A2 — tests to see whether that is an instance of syntax.A2
  // the expression that canEqual this tests that the current instance (this) is an instance of that.
  // case _ is the default
  override def equals(other: Any): Boolean = other match {
    case that: A2 =>
      (that canEqual this) &&
        name == that.name &&
        id == that.id
    case _ => false
  }

  override def hashCode(): Int = {
    // Seq is an immutable sequence - state would be of type ": Seq[Any]"
    val state = Seq(name, id)
    // state.map(_.hashCode()) is equivalent to state.map(x => x.hashCode())
    // foldLeft - start at 0 index and recursively apply hash function - process list L -> R
    state.map(_.hashCode()).foldLeft(0)((a, b) => 31 * a + b)
  }

  override def toString = s"A($name, $id)"
}