//  Scrivere una funzione corrisp[A,B](a:List[A], b:List[B], f:A=>B):Boolean che restituisce true se e solo se per ogni indice i comune a entrambe le liste vale b(i)=f(a(i)).
//  Se una lista è più lunga dell’altra, gli elementi in eccedenza devono essere ignorati.

object E2
{
    def corrisp[A,B](a : List[A], b : List[B], f : A => B) : Boolean =
    {
        if (b.size == 0 || a.size == 0) true
        else if (b.head != f(a.head)) false
        else corrisp(a.tail, b.tail, f)
    }
}