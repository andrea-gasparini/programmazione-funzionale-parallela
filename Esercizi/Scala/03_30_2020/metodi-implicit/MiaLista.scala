import scala.language.implicitConversions

object MiaLista {
    implicit def list2MiaLista[T](l : List[T]) = MiaLista(l)
}

case class MiaLista[T](l : List[T]) {
    import MiaLista._

    def mioZip[S](m : List[S]) : List[(T, S)] = {
        if (l.isEmpty || m.isEmpty) List()
        else (l.head, m.head) :: l.tail.mioZip(m.tail)
    }

    def mioFilter(f : T => Boolean) : List[T] = {
        if (l.isEmpty) List()
        else if (f(l.head)) l.head :: l.tail.mioFilter(f)
        else l.tail.mioFilter(f)
    }
}