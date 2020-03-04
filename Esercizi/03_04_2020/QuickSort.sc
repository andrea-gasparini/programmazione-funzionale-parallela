def QuickSort(l : List[Int]) : List[Int] =
{
    if (l.length < 2) l
    else
    {
        val pivot = l.head
        val minp = l.filter(_ < pivot)
        val magp = l.tail.filter(_ >= pivot)
        val sx = QuickSort(minp)
        val dx = QuickSort(magp)
        sx ::: (pivot :: dx)
    }
}

def QuickSortMinimized(l : List[Int]) : List[Int] = 
    if (l.length < 2) l else QuickSort2(l.filter(_ < l.head)) ::: (l.head :: QuickSort2(l.tail.filter(_ >= l.head)))