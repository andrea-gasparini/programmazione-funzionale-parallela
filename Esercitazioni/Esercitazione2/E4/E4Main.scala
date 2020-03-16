object E4Main extends App {
    var score = 0
	var trials = 0

	def test(l:List[Int], res:(List[Int],List[Int])) = {
		trials += 1
		val s:(List[Int],List[Int]) = E4.checkBitonic(l)
		println("Test "+trials+": " + s + " [corretto: " + res + "]")
		score += (if (s==res) 1 else 0)
	}

    test(List(1,2,5,6,9,4,3,2,0), (List(1,2,5,6,9),List(4,3,2,0)))
    test(List(), (Nil,Nil))
    test(List(1,2,3,2,3,2,1), (Nil,Nil))
    test(List(1,2,-1), (List(1,2),List(-1)))
    
	println("Risultato: " + score + "/" + trials)
}
