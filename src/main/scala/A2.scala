class A2(val name: String, val id: Int) {
  def canEqual(other: Any): Boolean = other.isInstanceOf[A2]

  override def equals(other: Any): Boolean = other match {
    case that: A2 =>
      (that canEqual this) &&
        name == that.name &&
        id == that.id
    case _ => false
  }

  override def hashCode(): Int = {
    val state = Seq(name, id)
    state.map(_.hashCode()).foldLeft(0)((a, b) => 31 * a + b)
  }

  override def toString = s"A($name, $id)"

}