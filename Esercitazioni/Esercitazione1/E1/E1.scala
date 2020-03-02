// trasformare il seguente medodo in modo che usi la ricorsione di coda

object E1 {
    //def sum(n:Int):Int = if (n<1) 0 else n+sum(n-1)
    def sum(n : Int) : Int =
    {
		@scala.annotation.tailrec
		def sumRic(tot : Int, n : Int) : Int =
		{
			if (n < 1) tot
			else sumRic(tot + n, n - 1)
		}
		sumRic(0, n)
	}
}

