// Aggiungi alla classe DB un metodo registiConFilm(p:Film=>Boolean):List[Regista] che estrae tutti i registi che hanno diretto almeno un film con la proprietà p.
// Nota: Se ritenunto utile, è possibile aggiungere alla classe DB variabili di istanza e metodi privati a piacere.

case class Film(id:Int, titolo:String, anno:Int)
case class Regista(id:Int, nome:String)
case class DirettoDa(idFilm:Int, idRegista:Int)

case class DB(film:List[Film], registi:List[Regista], regie:List[DirettoDa]) {
    def registiConFilm(p:Film=>Boolean):List[Regista] = 
    {
        (for
        {
            regista <- this.registi
            film <- film.filter(p)
            if (this.regie contains new DirettoDa(film.id, regista.id))
        } 
        yield (regista)).distinct
    }
}