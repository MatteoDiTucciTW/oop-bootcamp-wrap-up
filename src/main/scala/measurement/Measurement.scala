package measurement

case class Measurement[T](private val quantity: BigDecimal, private val unit: UnitOfMeasurementConverter[T]) {

  def +(addend: Measurement[T]): Measurement[T] = Measurement(toUnit(sumInBaseUnit(addend)), unit)

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

  private def sumInBaseUnit(addend: Measurement[T]) = {
    this.inBaseUnit + addend.inBaseUnit
  }

  private def inBaseUnit: BigDecimal = Measurement.twoDigitPrecision(unit.conversionToBaseUnit(quantity))

  private def toUnit(quantityInBaseUnit: BigDecimal): BigDecimal = Measurement.twoDigitPrecision(unit.conversionFromBaseUnit(quantityInBaseUnit))
}

//FIXME: let the client of Measurement decide the numeric precision
object Measurement {
  def apply[T](quantity: BigDecimal, unit: UnitOfMeasurementConverter[T]): Measurement[T] = {
    val twoDigitPrecisionQuantity = twoDigitPrecision(quantity)
    new Measurement(twoDigitPrecisionQuantity, unit)
  }

  def twoDigitPrecision(value: BigDecimal): BigDecimal = value.setScale(2, BigDecimal.RoundingMode.HALF_UP)
}
