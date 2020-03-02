// scrivi la soluzione qui...

object E3
{
	def sommaQuadrati(x : Int, y : Int) : Int =
	{
		def sumWithTot(tot : Int, x : Int, y : Int) : Int =
		{
			if (x > y) tot
			else sumWithTot(tot + x*x, x+1, y)
		}
		sumWithTot(x*x, x+1, y)
	}
}
