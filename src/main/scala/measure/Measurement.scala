package measure

case class Measurement[T](private val quantity: BigDecimal, private val unit: UnitOfMeasurement[T]) {

  override def canEqual(a: Any): Boolean = a.isInstanceOf[Measurement[T]]

  override def equals(that: Any): Boolean =
    that match {
      case that: Measurement[T] => that.canEqual(this) &&
        this.inBaseUnit == that.inBaseUnit
      case _ => false
    }

  def +(addend: Measurement[T]): Measurement[T] =
    Measurement(1/unit.conversionToBaseUnit(1/addend.unit.conversionToBaseUnit(addend.quantity)) + quantity, unit)

  private def inBaseUnit: BigDecimal = unit.conversionToBaseUnit(quantity)
}