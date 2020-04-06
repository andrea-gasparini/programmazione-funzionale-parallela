import scala.language.implicitConversions

object MyReduce 
{
	implicit def list2MyList[T](l : List[T]) = MyReduce(l)
}

case class MyReduce[T](l : List[T])
{
	def myReduce(f : (T, T) => T) : Option[T] =
	{
		def foo(m : List[T]) : T =
		{
			if (m.size == 1) m.head
			else f(aux(m.tail), m.head)
		}

		if (l.isEmpty) None else Some(aux(l))
	}
}