// scrivi la soluzione qui...

object E5
{
	def somma(f : Int => Int) /*: (a : Int, b : Int) => Int*/ =
	{
		def funzioneDaRestituire(a : Int, b : Int) : Int =
		{
			def funzioneConTot(tot : Int, a : Int, b : Int) : Int =
			{
				if (a > b) tot
				else funzioneConTot(tot + f(a), a+1, b)
			}
			funzioneConTot(f(a), a+1, b)
		}
		funzioneDaRestituire _
	}
}
