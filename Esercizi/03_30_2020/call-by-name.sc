def p(x : Int) = { println(x); x }

// valutazione eager, call-by-value
def f(a : Int, b : Int, c : Boolean) = if (c) a else b

// valutazione lazy, call-by-name
def f2(a : =>Int, b : =>Int, c : Boolean) = if (c) a else b

// =>T non è un valore di tipo T, ma un'espressione che calcola un valore di tipo T

def myWhile(test : =>Boolean)(body : =>Unit) : Unit = {
    if (! test) ()
    else {
        body
        myWhile(test)(body)
    }
}

var i = 0
myWhile (i < 10) {
    println("i = " + i)
    i += 1
}