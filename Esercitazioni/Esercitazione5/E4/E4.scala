/*
Scrivere un metodo piuGiovane che, dato un Vector s di oggetti Studente(id, nome) e un Vector e di oggetti Eta(id, eta),
restituisce un Option[String] che vale None se s è vuoto e Some(x), dove x è il nome dello studente più giovane, altrimenti.

Si assuma che ogni id contenuto in s sia anche contenuto in e.
Gli id sono unici in ciascuna collezione e servono come chiave primaria in s e in e.
*/

object E4 {
    def piuGiovane(s : Vector[Studente], e : Vector[Eta]) : Option[String] = {
        if (s.isEmpty) None
        else {
            val stuEta =
            for {
                stu <- s
                eta <- e
                if (stu.id == eta.id)  
            } yield (stu.nome, eta.eta)
            
            Some(stuEta.reduce((e1, e2) => if (e1._2 < e2._2) e1 else e2)._1)
        }
    }
}