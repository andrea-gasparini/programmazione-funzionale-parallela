/*
Scrivere un metodo scalarProd che, date due vettori rappresentati come sequenze di Double, ne calcola il prodotto scalare.
Se i vettori hanno lunghezze diverse, limitare il prodotto scalare al range di indici validi comuni. 
Ad esempio: scalarProd(Seq(3,4), Seq(2,9,1)) == 3*2 + 4*9 == 42.

Suggerimento: usare ricorsione oppure i metodi delle collezioni (potrebbero essercene di utili anche fra quelli non visti a lezione).
*/

object E1 {
    def scalarProd(s1 : Seq[Double], s2 : Seq[Double]) : Double = {
        if (s1.isEmpty || s2.isEmpty) 0
        else s1.head * s2.head + scalarProd(s1.tail, s2.tail)
    }
}