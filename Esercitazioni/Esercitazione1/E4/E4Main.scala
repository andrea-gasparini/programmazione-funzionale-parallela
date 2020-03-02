object E4Main extends App {

	var score = 0
	var trials = 0

	def test(f1:Int=>Int, f2:Int=>Int, n:Int, r:Boolean) = {
		trials += 1
		val s:Boolean = E4.ugualiIn(f1, f2, n)
		println("Test "+trials+": " + s + " [corretto: " + r + "]")
		score += (if (s==r) 1 else 0)
	}
	
	test(identity, identity, 100, true)
	test(x=>x*x, identity, 1, true)
	test(x=>x*x, identity, 2, false)
	test(x=> if (x<0) 0 else x, identity, 20, true)

	println("Risultato: " + score + "/" + trials)
}
