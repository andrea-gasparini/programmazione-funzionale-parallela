/*
Scrivere una versione parallela fibPar del metodo fib definito nel file Fib.scala usando
fork-join in Scala mediante il costrutto par.
*/

import Par._
import Fib._

object E2 {
    def fibPar(a : Int, b : Int)(n : Int) : Long = 
        if (n < 2) a
        else if (n == 2) b
        else {
            val (r1 : Long, r2 : Long) = Par.par { Fib.fib(a,b)(n-1) } { Fib.fib(a,b)(n-2) }
            r1 + r2
        }
}