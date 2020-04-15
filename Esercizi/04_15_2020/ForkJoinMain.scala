object Task {
  	def doTask(n : Long) = {
		var i = 0
		while (i < n) {
			i += 1
		}
	}
}

object ForkJoinMain extends App {
    val n = 2100000000L

	val r = new Runnable {
		def run() = { 
            Task.doTask(n)
        }
	}
	val t = new Thread(r)
	t.start()
	Task.doTask(n)
	t.join()
}