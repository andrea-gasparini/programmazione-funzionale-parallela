class Point(x : Double, y : Double) {
    def getX = x
    def getY = y
    def getDist = Math.sqrt(x*x + y*y)

    def +(other : Point) : Point =
    {
        new Point(x + other.getX, y + other.getY)
    }

    override def toString = "" + x + " | " + y

    println("Creato oggetto Point: " + this)
}