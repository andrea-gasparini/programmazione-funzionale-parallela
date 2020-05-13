sealed abstract class Tree {
	def lMatch(l : Tree, e : Int) : Boolean = l match {
		case E() => true
		case T(_, le, _) => le < e
	}

	def rMatch(r : Tree, e : Int) : Boolean = r match {
		case E() => true
		case T(_, re, _) => re > e
	}

	def treeTest : Boolean = this match {
		case E() => true
		case T(l, e, r) if(lMatch(l, e) && rMatch(r, e)) => l.treeTest && r.treeTest
		case T(l, e, r) => false
	}
}

// albero non vuoto
case class T(l:Tree, e:Int, r:Tree) extends Tree 

// albero vuoto
case class E() extends Tree