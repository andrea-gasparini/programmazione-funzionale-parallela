// Si vuole verificare la proprietà di un albero binario che l’elemento contenuto in ogni suo nodo v sia maggiore o uguale all’elemento nella radice del sottoalbero sinistro di v (se non vuoto)
// e minore o uguale all’elemento nella radice del sottoalbero destro di v (se non vuoto).
// Scrivere un metodo treeTest che, dato un albero binario con elementi interi, restituisce true se l’albero soddisfa la proprietà, e false altrimenti.

sealed abstract class Tree {
    def treeTest : Boolean = this match
    {
        case E() => true
        case T(sx, root, dx) if (
            (sx match
            {
                case E() => false
                case T(_, rootSx, _) => root < rootSx
            })
            ||
            (dx match
            {
                case E() => false
                case T(_, rootDx, _) => root > rootDx
            })) => false
        case T(sx, root, dx) => sx.treeTest && dx.treeTest
    }
}

// albero non vuoto
case class T(l:Tree, e:Int, r:Tree) extends Tree 

// albero vuoto
case class E() extends Tree
