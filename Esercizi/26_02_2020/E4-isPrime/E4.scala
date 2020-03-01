object E4
{
    def isPrime(n : Int) =
    {
        def divisible(m : Int) : Boolean =
        {
            if (m == 1) true
            else if (n % m == 0) false
            else divisible(m-1)
        }

        //divisible(n/2)
        divisible(Math.sqrt(n).toInt)
    }
}