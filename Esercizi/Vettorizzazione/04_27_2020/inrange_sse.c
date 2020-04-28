#include <stdio.h>
#include <immintrin.h>

int inrange_seq(const short* data, unsigned n, short min, short max) {
	int i;
	for (i = 0; i < n; i++)
		if (data[i] <  min || data[i] > max)
			return 0;

	return 1;
}

int inrange_sse(const shor* data, unsigned n, short min, short max) {
	int i;
	__m128i minv, maxv, datav, res;
	// min-1 e max-1 necessari perché l'operatore vettoriale confronta strettamente
	minv = _mm_set_epi16(min-1,min-1,min-1,min-1,min-1,min-1,min-1,min-1);
	maxv = _mm_set_epi16(max-1,max-1,max-1,max-1,max-1,max-1,max-1,max-1);

	for (i = 0; i + 7 < n; i += 8) {
		datav = _mm_loadu_si128(const __m128*)(data + i));

		// comparazione vettoriale val datav >= val min (datav >= min <--> datav > min-1)
		// il risultato ha val = 1 se val datav > val minv, 0 altrimenti
		res = _mm_cmpgt_epi16(datav, minv);

		// se in tutti i casi i valori di datav >= valori di minv
		if (! _mm_test_all_ones(res)) return 0;


		res = _mm_cmpgt_epi16(maxv, datav);

		if (! _mm_test_all_ones(res)) return 0;
	}

	while (++i < n) 
		if (data[i] < min || data[i] > max)
			return 0;

	return 1;
}
