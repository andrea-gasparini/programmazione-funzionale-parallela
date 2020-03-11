def evenOdd(x : Int) = x % 2 match
{
    case 0 => "pari"
    case 1 => "dispari"
}

def varType(x : Any) = x match
{
    case i : Int => i + " è un Int"
    case f : Float => f + " è un Float"
    case s : String => s + " è un String"
    case _ => "tipo non identificato"
}

def segno(n : Int) = n match
{
    case _ if (n > 0) => "positivo"
    case _ if (n == 0) => "zero"
    case _ => "negativo"
}

def listLen[T](l : List[T]) : Int = l match
{
    case List() => 0
    case h :: t => 1 listLen(t) // h == l.head, t == l.tail
}

def inters[T](l1 : List[T], l2 : List[T]) : List[T] = (l1, l2) match
{
    case (List(), _) => List()
    case (_, List()) => List()
    case (h1 :: t1, _) if (l2 contains h1) => h1 :: inters(t1, l2)
    case (_ :: t1, _) => inters(t1, l2)
}