package shape

class Rectangle(base: Int, height: Int) {

  if (base < 0){
    throw new IllegalArgumentException("Base of a rectangle has to be greater than zero")
  }

  if (height < 0){
    throw new IllegalArgumentException("Height of a rectangle has to be greater than zero")
  }

  def area: Int = base * height

  def perimeter: Int = base * 2 + height * 2
}