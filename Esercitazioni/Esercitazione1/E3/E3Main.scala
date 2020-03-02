object E3Main extends App {

	var score = 0
	var trials = 0

	def test(n:Int, m:Int, r:Int) = {
		trials += 1
		val s:Int = E3.sommaQuadrati(n,m)
		println("Test "+trials+": " + s + " [corretto: " + r + "]")
		score += (if (s==r) 1 else 0)
	}
	
	test(1,4,30)
	test(10,15,955)
	test(6,6,36)

	println("Risultato: " + score + "/" + trials)
}
