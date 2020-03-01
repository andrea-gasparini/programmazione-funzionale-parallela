// Uguaglianza di funzioni in un intervallo

object E2
{
    def ugualiInterv(a : Int, b : Int, f1 : Int => Int, f2 : Int => Int) : Boolean =
    {
        if (a > b) true
        else if (f1(a) == f2(a)) ugualiInterv(a, b-1, f1, f2)
        else false
    }
}