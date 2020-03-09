def removeDup[T](l : List[T]) : List[T] =
{
	if (l.size < 2) l
	else if (l.tail.contains(l.head)) removeDup(l.tail)
	else l.head :: removeDup(l.tail)
}
