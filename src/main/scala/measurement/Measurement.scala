package measurement

case class Measurement[T](private val quantity: BigDecimal, private val unit: UnitOfMeasurement[T]) {

  def +(addend: Measurement[T]): Measurement[T] =
    Measurement(1 / unit.conversionToBaseUnit(1 / addend.unit.conversionToBaseUnit(addend.quantity)) + quantity, unit)

  override def canEqual(a: Any): Boolean = a.isInstanceOf[Measurement[T]]

  override def equals(that: Any): Boolean =
    that match {
      case that: Measurement[T] => that.canEqual(this) &&
        this.inBaseUnit == that.inBaseUnit
      case _ => false
    }

  override def hashCode: Int = {
    val prime = 31
    var result = 1
    result = prime * result + quantity.toInt
    result = prime * result + unit.hashCode
    result
  }

  private def inBaseUnit: BigDecimal = unit.conversionToBaseUnit(quantity)
}