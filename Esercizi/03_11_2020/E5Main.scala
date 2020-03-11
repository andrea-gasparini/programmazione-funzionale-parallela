object E5Main extends App {

	var score = 0
	var trials = 0

	def test(f:Int=>Int, a:Int, b: Int, r:Int) = {
		trials += 1
		val g:(Int,Int)=>Int = E5.somma(f)
		val s:Int = g(a,b)
		println("Test "+trials+": " + s + " [corretto: " + r + "]")
		score += (if (s==r) 1 else 0)
	}
	
	test(x=>2*x, 5, 7, 36)
	test(x=>x+1, 1, 4, 14)
	test(x=>2*x+1, 0, 10, 121)

	println("Risultato: " + score + "/" + trials)
}
