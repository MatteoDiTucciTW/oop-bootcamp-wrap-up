package shape

class Square(side: Int) extends Rectangle(base = side, height = side){
}

object Square {

  def apply(side: Int): Square = {
    if (side < 0){
      throw new IllegalArgumentException("Side of a square has to be greater than zero")
    }
    new Square(side)
  }
}
