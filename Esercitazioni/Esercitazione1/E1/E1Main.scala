object E1Main extends App {

	var score = 0
	var trials = 0

	def test(n:Int, r:Int) = {
		trials += 1
		val s:Int = E1.sum(n)
		println("Test "+trials+": " + s + " [corretto: " + r + "]")
		score += (if (s==r) 1 else 0)
	}
	
	test(0, 0)
	test(1, 1)
	test(2, 3)
	test(3, 6)
	test(6, 21)

	println("Risultato: " + score + "/" + trials)
}
