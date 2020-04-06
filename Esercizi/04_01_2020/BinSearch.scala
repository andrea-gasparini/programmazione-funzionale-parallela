object BinSearch {
    def search[T](v : Vector[T], x : T)(implicit cmp : T => Int) : Boolean =
    {
        def foo(a : Int, b : Int) : Boolean =
        {
            if (a >= b) false
            else
            {
                val mid = (a + b) / 2
                if (v(mid) == x) true
                else if (x <= v(mid)) foo(a, mid)
                else foo(mid + 1, b)
            }
        }
        foo(0, v.length)
    }
}