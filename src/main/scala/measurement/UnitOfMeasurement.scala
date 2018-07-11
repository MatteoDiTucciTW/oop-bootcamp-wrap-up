package measurement

abstract class UnitOfMeasurement[T](val conversionToBaseUnit: BigDecimal => BigDecimal)

object Foot extends UnitOfMeasurement[Length](conversionToBaseUnit = _ * 0.3048)
object Inch extends UnitOfMeasurement[Length](conversionToBaseUnit = _ * 0.0254)
object Yard extends UnitOfMeasurement[Length](conversionToBaseUnit = _ * 0.9144)
object Centimeter extends UnitOfMeasurement[Length](conversionToBaseUnit = _ * 0.01)

object Gallon extends UnitOfMeasurement[Volume](conversionToBaseUnit = _ * 3.7854)
object Liter extends UnitOfMeasurement[Volume](conversionToBaseUnit = _ * 1)

object Fahrenheit extends UnitOfMeasurement[Temperature](conversionToBaseUnit = _ * 1)
object Celsius extends UnitOfMeasurement[Temperature](conversionToBaseUnit = 32 + 1.8 * _)

