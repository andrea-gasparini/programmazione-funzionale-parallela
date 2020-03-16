//  Scrivere una funzione maxPrefisso(l:List[Int], x:Int):Int Scala che restituisce il più grande numero n tale che la somma dei primi n numeri di l è minore o uguale a x.
//  Ad esempio, maxPrefisso(List(1,1,1,1,1),3) == 3, maxPrefisso(List(5,2,4,7),8)==2 e maxPrefisso(List(5,2,4,7),4)==0.

object E3
{
    def maxPrefisso(l : List[Int], x : Int) : Int =
    {
        def foo(n : Int, tot : Int, l : List[Int]) : Int =
        {
            if (l.isEmpty || tot + l.head > x) n
            else foo(n + 1, tot + l.head, l.tail)
        }
        foo(0, 0, l)
    }
}