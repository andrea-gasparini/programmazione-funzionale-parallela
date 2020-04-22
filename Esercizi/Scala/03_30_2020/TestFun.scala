object TestFun extends App {
    val f = Add(Mul(Const(5), Const(20)), X())
    println(f)
    println(f(5))

    val g = Mul(X(), X())
    println(g)
    println(g.deriv(10))
}