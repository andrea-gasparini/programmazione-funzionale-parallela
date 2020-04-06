import E4._

object E4Main extends App {

    var punti = 0

	print("Test 1: repeat(5) { ... }: ")
	var i = 0;
	repeat(5) {
		i += 1
	}
		
	if (i==5) { 
		punti += 1
		println("OK")
	}
	else println("ERR")

	print("Test 1: repeat(0) { ... }: ")
	i=0;
	repeat(0) {
		i += 1
	}
	
	if (i==0) { 
		punti += 1
		println("OK")
	}
	else println("ERR")

    println("Risultato: " + punti + "/2")
}
