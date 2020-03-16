object E1Main extends App {

	var score = 0
	var trials = 0
    
    def test(f1:Double=>Double, f2:Double=>Double, x:Double, res:Double) = {
        trials += 1
        val s = E1.sommaFun(f1,f2)
        val n = s(x)
        println("Test: "+trials+": "+n+" [corretto: "+res+"]")
        if (math.abs(n-res)<0.01) score += 1
    }

    test(x=>x, x=>x+1, 2, 5.0)
    test(x=>2*x, x=>x+2, 3, 11.0)
    test(x=>math.sin(x), x=>math.cos(x), 3.14142, -1.0)
    
	println("Risultato: " + score + "/" + trials)
}