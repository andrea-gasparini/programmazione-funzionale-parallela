object E2Main extends App {
	var score = 0
	var trials = 0
    
	def test[A,B](a:List[A], b:List[B], f:A=>B, res:Boolean) = {
		trials += 1
		val s:Boolean = E2.corrisp(a,b,f)
		println("Test "+trials+": " + s + " [corretto: " + res + "]")
		score += (if (s==res) 1 else 0)
	}

    test(List("uno", "cinque", "x", "sei"), List(3, 6, 1), (s:String) => s.length, true)
    test(List(1, 2, 3, 4), List(2, 4, 5), (_:Int)*2, false)
    test(List(-1, 0, 2, -5, 1), List(false, false, true), (_:Int)>0, true)
    
	println("Risultato: " + score + "/" + trials)
}
