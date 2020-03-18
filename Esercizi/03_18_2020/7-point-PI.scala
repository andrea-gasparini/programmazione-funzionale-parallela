class Point(x : Double, y : Double) {
    def getX = x
    def getY = y
    def getDist = Math.sqrt(x*x + y*y)
    override def toString = x + " | " + y
    val PI = 3.14 // <--- sarebbe static final in Java
    println("Creato oggetto Point")
}

object Point { // <--- companion object di Point
    val PI = 3.14 // <--- posto adatto per costanti
}

object Main extends App {
    println(Point.PI)
    val p = new Point(10, 20)
    println(p.PI)
}