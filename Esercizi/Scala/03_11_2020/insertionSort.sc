def insert(x : Int, l : List[Int]) : List[Int] = 
{
    if (l.isEmpty) List(x)
    else if (x < l.head) x :: l
    else l.head :: insert(x, l.tail)
}

def insertionSort(l : List[Int]) : List[Int] = 
{
    if (l.size < 2) l
    else insert(l.head, insertionSort(l.tail))
}