object E1Main extends App
{
    def filterByIndex[T](l : List[T], f : Int => Boolean) =
    {
        l.zipWithIndex.filter(c => f(c._2)).map(c => c._1)
    }

    val l = List("zero", "uno", "due", "tre", "quattro", "cinque")
    println(filterByIndex(l, _ % 2 == 0))
}