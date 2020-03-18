class Coder(val name : String, val age : Int)

object MainCoder extends App
{
    val l = List(
        new Coder("Anna", 19),
        new Coder("Paolo", 24),
        new Coder("Francesca", 21),
        new Coder("Marco", 22),
        new Coder("Anna", 18)
    )

    // trova il nome del coder più giovane
    val q = l.reduce((a,b) => if (a.age < b.age) a else b).name
    println(q)

    // seleziona nome coder con meno di 20 anni
    val p = l.filter(_.age < 20).map(_.name)
    println(p)
}