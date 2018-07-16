package measurement

abstract class UnitOfMeasurementConverter[T](val conversionToBaseUnit: BigDecimal => BigDecimal, val conversionFromBaseUnit: BigDecimal => BigDecimal)

object Foot extends UnitOfMeasurementConverter[Length](conversionToBaseUnit = _ * 0.3048, conversionFromBaseUnit = _ * 3.2808)
object Inch extends UnitOfMeasurementConverter[Length](conversionToBaseUnit = _ * 0.0254, conversionFromBaseUnit = _ * 39.3700)
object Yard extends UnitOfMeasurementConverter[Length](conversionToBaseUnit = _ * 0.9144, conversionFromBaseUnit = _ * 1.0936)
object Centimeter extends UnitOfMeasurementConverter[Length](conversionToBaseUnit = _ * 0.01, conversionFromBaseUnit = _ * 100)

object Gallon extends UnitOfMeasurementConverter[Volume](conversionToBaseUnit = _ * 3.7854, conversionFromBaseUnit = _ * 0.264172)
object Liter extends UnitOfMeasurementConverter[Volume](conversionToBaseUnit = _ * 1, conversionFromBaseUnit = _ * 1)

object Fahrenheit extends UnitOfMeasurementConverter[Temperature](conversionToBaseUnit = _ * 1, conversionFromBaseUnit = _ * 1)
object Celsius extends UnitOfMeasurementConverter[Temperature](conversionToBaseUnit = 32 + 1.8 * _, conversionFromBaseUnit = fahrenheit =>  (fahrenheit - 32) / 1.8)

