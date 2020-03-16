//  Scrivere una funzione sommaFun(f1:Double=>Double, f2:Double=>Double):Double=>Double che restituisce la funzione somma di f1 ed f2. 
//  Ad esempio: sommaFun(x=>x, x=>x+1)(2) == 5 (ottenuto come: 2+(2+1)), sommaFun(x=>2*x, x=>x+2)(3) == 11 (ottenuto come: (2*3)+(3+2))

object E1
{
    def sommaFun(f1 : Double => Double, f2 : Double => Double) : Double => Double =
    {
        x => f1(x) + f2(x)
    }
}