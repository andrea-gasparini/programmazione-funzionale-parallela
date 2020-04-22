object ParUnit {
	def par(a : => Unit)(b : => Unit) = {
		val r = new Runnable {
			def run() = a
		}
        
		val t = new Thread(r)

		t.start()
		b
		t.join()
	}
}