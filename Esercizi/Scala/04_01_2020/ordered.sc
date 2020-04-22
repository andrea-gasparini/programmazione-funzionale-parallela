class A {
    def text = "superclasse A"
}

class B extends A {
   override def text = "sottoclasse B"
}

class C extends A {
   override def text = "sottoclasse C"
}

def sottoclasse[T <: A](x : T) = x.text

def min[T](l : List[T]) = {
    l.reduce((a, b) => if (a < b) a else b)
}

def min2[T](l : List[T])(implicit cmp : T => Int) = {
   l.reduce((a, b) => if (a < b) a else b)
}