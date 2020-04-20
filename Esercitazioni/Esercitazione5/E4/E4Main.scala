case class Studente(id:Int, nome:String)
case class Eta(id:Int, eta:Int)

object E4Main extends App {

    var punti = 0
    var test  = 0

    def doTest(s:Vector[Studente], e:Vector[Eta], c:String) = {
        test += 1
        val r:String = E4.piuGiovane(s,e).getOrElse("None")
        println("Test " + test + ": " + r + " (corretto: " + c + ")")
        if (c == r) punti += 1
    }

	doTest(Vector(Studente(1,"Lucia"), Studente(2,"Marco"), Studente(3,"Paola"), Studente(4,"Alberto")),
           Vector(Eta(1,22), Eta(2,21), Eta(3,19), Eta(4,23)), 
		   "Paola")

    doTest(Vector(),Vector(), "None")

    println("Punti: " + punti + " su " + test)
}
