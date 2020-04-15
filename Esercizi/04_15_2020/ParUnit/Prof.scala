object Prof {
    def profila[T](body : => T) : (T, Double) = {
		val start = System.nanoTime
		val v = body
		val t = System.nanoTime - start
		(v, t*1E-9)
	}
}