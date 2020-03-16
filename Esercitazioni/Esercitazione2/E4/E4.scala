//  Una sequenza bitonica è formata da una sequenza non vuota strettamente crescente seguita da una sequenza non vuota strettamente decrescente.
//  Ad esempio: List(1,2,5,6,9,4,3,2,0) è bitonica, mentre List(1,2,3,2,3,2,1), List(1,2,3) e List() non lo sono.

//  Scrivere una funzione checkBitonic(l:List[Int]):(List[Int],List[Int]) che, data una lista l bitonica, restituisce (inc,dec)
//  tale che inc è il prefisso crescente di l che include l’elemento massimo e dec è il suffisso strettamente decrescente che segue (si ha che inc ::: dec == l).
//  Se invece l non è bitonica, la funzione restituisce (Nil,Nil).

object E4
{
    def checkBitonic(l : List[Int]) : (List[Int], List[Int]) =
    {
        if (l.isEmpty) (Nil, Nil)
        else
        {
            val maxPos = l.indexOf(l.max)
            val (l1, l2) = l.splitAt(maxPos + 1)
            
            if ((! l1.isEmpty) && (! l2.isEmpty) && l1 == l1.sorted && l2.reverse == l2.sorted) (l1, l2)
            else (Nil, Nil)
        }
    }
}