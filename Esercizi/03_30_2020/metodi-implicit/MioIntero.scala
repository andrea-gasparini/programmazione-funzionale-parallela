import scala.language.implicitConversions

object MioIntero {
    implicit def int2MioIntero(i : Int) = MioIntero(i)
}

case class MioIntero(i : Int) {
    def somma(j : Int) = i + j
}