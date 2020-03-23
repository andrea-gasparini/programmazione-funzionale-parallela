// Scrivere un metodo getModel che, dato un intero n, restituisce una lista di n cerchi di cui l’i-esimo cerchio, per i=1..n, ha x=y=r=0.5*i/n, dove (x,y) sono le coordinate del centro e r è il raggio.
// L’origine degli assi è nell’angolo inferiore sinistro e il disegno è confinato in uno spazio quadrato di coordinate comprese tra 0.0 e 1.0.
// Usare la classe case class Circle(x:Double, y:Double, r:Double) extends Shape definita in Frame2D.scala, dove x e y sono le coordinate del centro ed r il raggio.

object E2 {
    def getModel(n:Int):List[Shape] = 
    {
        def foo(n : Int, i : Int) : List[Circle] =
        {
            if (i == 0) return List()
            else foo(n, i - 1) ::: List(new Circle(0.5*i/n, 0.5*i/n, 0.5*i/n))
        }
        foo(n, n)
    }
}
