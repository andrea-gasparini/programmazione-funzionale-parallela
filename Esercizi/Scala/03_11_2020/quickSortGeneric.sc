def quickSort(l : List[Int]) : List[Int] = 
{
    if (l.size < 2) l
    else quickSort(l.filter(_ < l.head)) ::: l.head :: quickSort(l.tail.filter(_ >= l.head))
}

def quickSortGen[T](cmp : (T, T) => Boolean)(l : List[T]) : List[T] = 
{
    if (l.size < 2) l
    else quickSortGen(cmp)(l.filter(cmp(_, l.head))) ::: l.head :: quickSortGen(cmp)(l.tail.filter(! cmp(_, l.head)))
}