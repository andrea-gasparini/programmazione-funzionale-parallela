object E2Main extends App {

    var score = 0
    var trials = 0

    def test(n:Int, c:List[Shape]) {
        trials += 1
        val r = E2.getModel(n)
        println("Test " + trials + ": " + r + " [corretto: " + c + "]")
        if (r==c) score += 1 
    }

    test(0, Nil)
    test(1, List(Circle(0.5,0.5,0.5)))
    test(2, List(Circle(0.25,0.25,0.25), Circle(0.5,0.5,0.5)))
    test(4, List(Circle(0.125,0.125,0.125), Circle(0.25,0.25,0.25), Circle(0.375,0.375,0.375), Circle(0.5,0.5,0.5)))

	println("Risultato: " + score + "/" + trials)
    
    val m = E2.getModel(50)    
    Frame2D.display(m,  500, 500)
}


