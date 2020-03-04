def isSorted(l : List[Int]) : Boolean =
{
    if (l.size < 2) true
    else if (l.head < l.tail.head) isSorted(l.tail)
    else false
}