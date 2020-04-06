/*
Si vuole aggiungere un costrutto Scala repeat che, dato un intero n e un corpo body,
esegue body per n volte come nel seguente esempio:

repeat(5) {
    println("test")
}
*/

object E4 {
    def repeat(n : Int)(body : =>Unit) : Unit = {
        if (n == 0) ()
        else {
            body
            repeat(n - 1)(body)
        }
    }
}