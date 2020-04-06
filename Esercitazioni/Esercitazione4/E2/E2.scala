/*
Scrivere un metodo isMappedFrom, applicabile a un Vector v che verifica se un altro Vector m
è ottenibile da v applicando la funzione f a ciascun elemento di v.
*/
import scala.language.implicitConversions

object E2 {
    implicit def vector2MyVector[T](v : Vector[T]) = MyVector(v);
}

case class MyVector[T](v : Vector[T]) {
    import E2._

    def isMappedFrom[S](m : Vector[S], f : T => S) : Boolean = {
        if (v.size != m.size) false
        else if (v.isEmpty) true
        else if (f(v.head) == m.head) v.tail.isMappedFrom(m.tail, f)
        else false
    }
}