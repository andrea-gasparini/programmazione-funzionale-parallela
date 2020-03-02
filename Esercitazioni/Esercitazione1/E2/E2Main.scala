object E2Main extends App {

	var score = 0
	var trials = 0

	def test(n:Int, m:Int, r:Int) = {
		trials += 1
		val s:Int = E2.mcd(n,m)
		println("Test "+trials+": " + s + " [corretto: " + r + "]")
		score += (if (s==r) 1 else 0)
	}
	
	test(6,4,2)
	test(13,8,1)
	test(4,12,4)

	println("Risultato: " + score + "/" + trials)
}
