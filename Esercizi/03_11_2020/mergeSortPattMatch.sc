def mergeSortPattMatch(a : List[Int], b : List[Int]) : List[Int] = (a, b) match
{
    case (List(), List()) => List()
    case (l, List()) => l
    case (List(), l) => l
    case (ha :: ta, hb :: tb) if (ha < hb) => ha :: mergePattMatch(ta, b)
    case (ha :: ta, hb :: tb) => hb :: mergePattMatch(a, tb)
}