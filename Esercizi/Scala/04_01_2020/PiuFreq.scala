/*
Metodo piuFrequente[T](l : Seq[T]) : Option[(T, Int)]
dove l'Option è un None se la sequenza è vuota
ed è un Some((x, count)) se x è l'elemento più frequente
e count il suo numero di occorrenze
*/

object PiuFreq 
{
    def piuFrequente[T](l : Seq[T]) : Option[(T, Int)] =
    {
        if (l.isEmpty) None
        else
        {
			val m = l.groupBy(identity).reduce((x, y) => if (x._2.size > y._2.size) x else y)
			Some((m._1, m._2.size))
        }
    }
}