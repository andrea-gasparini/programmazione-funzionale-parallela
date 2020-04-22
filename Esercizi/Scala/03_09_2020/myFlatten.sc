def myFlatten[T](l : List[List[T]]) : List[T] =
{
	l.reduce((l1, l2) => l1 ::: l2)
}
