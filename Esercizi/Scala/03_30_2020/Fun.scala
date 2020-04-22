sealed abstract class Fun {
    def apply(x : Int) : Int = this match {
        case X() => x
        case Const(c : Int) => c
        case Add(a : Fun, b : Fun) => a(x) + b(x)
        case Mul(a : Fun, b : Fun) => a(x) * b(x)
    }

    override def toString : String = this match {
        case X() => "x"
        case Const(c : Int) => c.toString
        case Add(a : Fun, b : Fun) => "(" + a + " + " + b + ")"
        case Mul(a : Fun, b : Fun) => "(" + a + " * " + b + ")"
    }

    def deriv : Fun = this match {
        case X() => Const(1)
        case Const(c : Int) => Const(0)
        case Add(a : Fun, b : Fun) => Add(a.deriv, b.deriv)
        case Mul(a : Fun, b : Fun) => Add(Mul(a.deriv, b), Mul(a, b.deriv))
    }
}

case class X() extends Fun
case class Const(c : Int) extends Fun
case class Add(a : Fun, b : Fun) extends Fun
case class Mul(a : Fun, b : Fun) extends Fun