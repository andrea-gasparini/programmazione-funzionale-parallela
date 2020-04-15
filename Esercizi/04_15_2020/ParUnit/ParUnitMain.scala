import ParUnit._
import Prof._

object Task {
	def doTask(n : Long) = {
		var i = 0
		while (i < n) {
			i += 1
		}
	}
}

object ParUnitMain extends App {
	val n = 2100000000L

    val tseq = profila {
        Task.doTask(n)
        Task.doTask(n)
    }._2

	val tpar = profila {
		par { Task.doTask(n) } { Task.doTask(n) }
	}._2

	println("tempo parallelo: " + tpar)
    println("tempo sequenziale: " + (tseq / tpar))
}