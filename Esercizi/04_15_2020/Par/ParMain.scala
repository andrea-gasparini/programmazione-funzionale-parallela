import Par._

object ParMain extends App {
    val (a, b) = par { "ciao" } { 3.14 }
    println(a)
    println(b)
}