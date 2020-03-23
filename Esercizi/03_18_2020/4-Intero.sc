class Intero(val x : Int) {
    def this(s : String) =    // << definizione costruttore secondario
        this(Integer.parseInt(s))   // << invocazione costruttore primario
}