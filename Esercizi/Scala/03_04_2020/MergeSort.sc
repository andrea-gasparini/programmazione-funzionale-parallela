def Merge(l1 : List[Int], l2 : List[Int]) : List[Int] = 
{
    if (l1 == List()) l2
    else if (l2 == List()) l1
    else if (l1.head < l2.head) l1.head :: Merge(l1.tail, l2)
    else l2.head :: Merge(l1, l2.tail)
}

def MergeSort(l : List[Int]) : List[Int] = 
{
    if (l.length < 2) l
    else
    {
        val (a, b) = l.splitAt(l.length / 2)
        val sx = MergeSort(a)
        val dx = MergeSort(b)
        Merge(sx, dx)
    }
}