object E3
{
    def fibonacci(n : Int) : Int =
    {
        if (n == 0) 0
        else if (n <= 2) 1
        else fibonacci(n-1) + fibonacci(n-2)
    }
}