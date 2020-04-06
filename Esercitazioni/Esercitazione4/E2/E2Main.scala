import E2._

object E2Main extends App {

    var punti = 0

    // test correttezza
    val v0 = Vector(1,2,3)
    val m0 = Vector(2,4,6)
    val r0 = v0.isMappedFrom(m0, 2*_)
	val c0 = true
    if (r0 == c0) punti += 1
    println("Test 1: " + r0 + " (corretto: " + c0 + ")")

    val v1 = Vector(1,2,3)
    val m1 = Vector(2,3)
	val c1 = false
    val r1 = v1.isMappedFrom(m1, 1+_)
    if (r1 == c1) punti += 1
    println("Test 2: " + r1 + " (corretto: " + c1 + ")")

    val v2 = Vector(2,3,3)
    val m2 = Vector("A2","A3","A3")
	val c2 = true
    val r2 = v2.isMappedFrom(m2, "A"+_)
    if (r2 == c2) punti += 1
    println("Test 3: " + r2 + " (corretto: " + c2 + ")")

    val v3 = Vector(2,3,3)
    val m3 = Vector("A2","B3","C3")
	val c3 = false
    val r3 = v3.isMappedFrom(m3, "A"+_)
    if (r3 == c3) punti += 1
    println("Test 4: " + r3 + " (corretto: " + c3 + ")")

    println("Risultato: " + punti + "/4")
}
