class Point(val x : Double, val y : Double)

// object come static in Java
object Point { // <<< companion object
    def apply(x : Double, y : Double) = new Point(x, y)
    // questo permette di istanziare la classe tramite solo Point(x, y) piuttosto che new Point(x, y)
}