object Factorial
{
    def fact(n : Int) : Int =
    {
        if (n < 2) n
        else n*fact(n-1)
    }

    def factTail(n : Int) : Int =
    {
        def fact(res : Int, n : Int) : Int =
        {
            if (n < 2) res
            else fact(res*n, n-1)
        }
        fact(1, n)
    }
}