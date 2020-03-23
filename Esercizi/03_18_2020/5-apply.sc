class Point(x : Double, y : Double) {
    def apply(i : Int) = i match
    {
        case 0 => x
        case 1 => y
    }
}

// x.apply(i) <--> x(i)