object E2Main extends App
{
    println(E2.ugualiInterv(0, 20, identity, identity))
    println(E2.ugualiInterv(2, 6, _*2, _*2))
    println(E2.ugualiInterv(0, 5, _+2*3, _*2+3))
}