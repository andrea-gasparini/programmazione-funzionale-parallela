def prodCart[A, B](a : List[A], b : List[B]) : List[(A, B)] = 
{
    a.map(x => b.map(y => (x, y))).flatten
}

def prodCart2[A, B](a : List[A], b : List[B]) : List[(A, B)] = 
{
    for 
    {
        x <- a
        y <- b
    } yield (x, y)
}