def ListIntersection(l1 : List[Int], l2 : List[Int]) : List[Int] =
{
    if (l1.isEmpty || l2.isEmpty) List()
    else if (l2.contains(l1.head)) l1.head :: inters(l1.tail, l2)
    else inters(l1.tail, l2)
}