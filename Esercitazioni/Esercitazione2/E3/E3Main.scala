object E3Main extends App {
	var score = 0
	var trials = 0
    
	def test(l:List[Int], n:Int, res:Int) = {
		trials += 1
		val s:Int = E3.maxPrefisso(l, n)
		println("Test "+trials+": " + s + " [corretto: " + res + "]")
		score += (if (s==res) 1 else 0)
	}

    test(List(1, 1, 1, 1, 1), 3, 3)
    test(List(5, 2, 4, 7), 8, 2)
    test(List(5, 2, 4, 7), 4, 0)
    
	println("Risultato: " + score + "/" + trials)
}
