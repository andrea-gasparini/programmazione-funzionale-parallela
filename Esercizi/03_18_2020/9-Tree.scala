// sealed vincola le estensioni della classe a quelle definite all'interno del modulo (file) attuale
sealed abstract class Tree {
    // scrivere un metodo che conta il numero di nodi dell'albero
    def numNodi : Int = this match
    {
        case E() => 0
        case T(sx, _, dx) => 1 + sx.numNodi + dx.numNodi
    }
}

case class T(sx : Tree, root : Int, dx : Tree) extends Tree
case class E() extends Tree

object TreeMain extends App {
    val t = T(T(E(), 10, E()), 20, E())
    println(t.numNodi)
}