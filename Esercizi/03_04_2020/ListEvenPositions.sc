def ListEvenPositions(l : List[Int]) : List[Int] =
{
    l.zipWithIndex
        .filter(el => el._2 % 2 == 0)
        .map(el => el._1)
}