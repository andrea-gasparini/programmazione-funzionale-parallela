object E2Main extends App {

	var score = 0
	var trials = 0
    
    def test(t:Tree, res:Boolean) = {
        trials += 1
        val s:Boolean = t.treeTest
        println("Test: "+trials+": "+s+" [corretto: "+res+"]")
        if (s == res) score += 1
    }

    val t1:Tree = T(T(E(),5,E()),10,T(T(E(),20,E()),30,T(E(),40,E())))
    val t2:Tree = T(T(E(),15,E()),10,T(T(E(),20,E()),30,T(E(),40,E())))
    val t3:Tree = T(E(),0,E())
    val t4:Tree = E()
    val t5:Tree = T(E(),0,T(E(),-10,E()))

    test(t1, true)
    test(t2, false)
    test(t3, true)
    test(t4, true)
    test(t5, false)

	println("Risultato: " + score + "/" + trials)
}
