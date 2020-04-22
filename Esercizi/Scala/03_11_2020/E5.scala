// Scrivere un metodo Scala somma che, dato come parametro una funzione f : Int => Int,
// restituisce una funzione che prende come parametri due interi a e b e restituisce
// la somma di f(x) per ogni x compreso tra a e b (estremi inclusi)

/*
// Soluzione Consegnata
object E5
{
	def somma(f : Int => Int) =
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
*/

// Soluzioni Professore
object E5
{
	def somma(f : Int => Int) : (Int, Int) => Int =
	{
		def funzioneDaRestituire(a : Int, b : Int) : Int =
		{
			if (a > b) 0
			else f(a) + funzioneDaRestituire(a + 1, b)
		}
	}

	def somma2(f : Int => Int)(a : Int, b : Int) : (Int, Int) => Int =
	{
		if (a > b) 0
		else f(a) + somma2(f)(a + 1, b)
	}

	def somma3(f : Int => Int)(a : Int, b : Int) : Int =
	{
		(a to b).map(f(_)).sum
	}
}
