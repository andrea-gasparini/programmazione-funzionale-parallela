/*
Scrivere un metodo currificato def buildMatrix(rows:Int, cols:Int)(f:(Int,Int) => Double):Vector[Vector[Double]]
che restituisce una matrice di Double con rows righe e cols colonne dove f(i,j) descrive il contenuto della cella (i,j).

Più precisamente, il metodo restituisce un Vector[Vector[Double]] v tale che per ogni i in [0,rows-1] e per ogni j in [0,cols-1] si ha v(i)(j) == f(i,j).
*/

object E1 {
    def buildMatrix(rows : Int, cols : Int)(f : (Int,Int) => Double) : Vector[Vector[Double]] = {
        def buildRow(row : Int, cols : Int) = (0 to cols - 1).toVector.map(col => f(row, col))
        (0 to rows - 1).toVector.map(row => buildRow(row, cols))    
    }
}