## Domanda 1: V

Il seguente frammento di codice Scala genera errori di compilazione:
```scala
def f(x:Int) = x
val v = f
```

## Domanda 2: V

Il seguente frammento di codice Scala genera errori di compilazione:
```scala
def f[T](l:List[T]):List[T] = {
    l.sorted
}
```

## Domanda 3: F

Dimezzare il tempo di esecuzione di una porzione di codice che richiede la metà del tempo di esecuzione di un programma porta a uno speedup complessivo pari a 2x per quel programma.

## Domanda 4: V

Il tipo vettoriale `__m128i` permette di fare 16 operazioni in parallelo su valori di 8 bit.

## Domanda 5: F

La vettorizzazione è un tipo di computazione MIMD secondo la tassonomia di Flynn.

## Domanda 6: V

Uno dei problemi principali nella manutenzione di un data center è tenerne bassa la temperatura con un opportuno sistema di raffreddamento.

## Domanda 7: F

In Scala il concetto di metodo e quello di funzione sono equivalenti.

## Domanda 8: F

Il seguente metodo Scala viene compilato correttamente e calcola una copia della lista in ingresso:
```scala
def f[T](l:List[T]) = l match {
    case Nil => Nil
    case h::Nil => List(h)
    case h::t => h::f(t)
}
```

## Domanda 9: F

La seguente funzione SSE calcola la somma dei numeri di un vettore di `int` di lunghezza arbitraria:

```c
#include <immintrin.h>

int array_sum(int *v, int n) {
    int i, res[4];
    __m128i s = _mm_set_epi32(0,0,0,0);
    for (i=0; i+3<n; i+=4) {
        __m128i vv = _mm_loadu_si128((const __m128i*)(v+i));
        s = _mm_add_epi32(s, vv);
    }
    _mm_storeu_si128((__m128i*)res, s);
    return res[0]+res[1]+res[2]+res[3];
}
```

## Domanda 10: F

In OpenCL la memoria host e quella device risiedono sempre in memorie fisiche distinte.
