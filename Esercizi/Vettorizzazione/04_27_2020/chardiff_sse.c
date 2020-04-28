#include <stdio.h>
#include <immintrin.h>

int chardiff_seq(const char* x, const char* y, int n) {
	int i, cnt = 0;
	
	for (i = 0; i < n; i++) 
		if (x[i] != y[i]) cnt++;

	return cnt;
}

int chardiff_sse(const char* x, const char* y, int n) {
	if (n < 16) return chardiff_seq(x, y, n);

	int i, cnt = 0;
	unsigned char mcnt[16];

	// istanzio variabili vettoriali
	__m128i xv, yv, res, vcnt, vone;

	// util per complementare il risultato della comparazione vettoriale di char
	vone = _mm_set_epi8(1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1);

	// contatori delle diff
	vcnt = _mm_set_epi8(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0); 

	for (i = 0; (i + 15) < n; i += 16) {
		xv = _mm_loadu_si128((const __m128i*)(x + i));
		yv = _mm_loadu_si128((const __m128i*)(y + i));

		// comparazione vettoriale (il risultato ha val = 0 se diff, -1 se non)
		res = _mm_cmpeq_epi8(xv, yv);

		// complemento il risultato (così che i val di res = 1 se diff, 0 se non)
		res = _mm_add_epi8(res, vone);

		// aggiungo le diff ai contatori
		vcnt = _mm_add_epi8(vcnt, res);

		// ogni 255 iterazioni ripristino i contatori (unsigned char è 255)
		if (i % 255 == 0) {
			_mm_storeu_si128((__m128i*)mcnt, vcnt);
			for (int k = 0; k < 16; k++) cnt += mcnt[k];
			vcnt = _mm_set_epi8(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0); 
		}
	}

	// controllo i char non compresi nei multipli di 16
	while (++i < n && x[i] != y[i]) cnt++;

	_mm_storeu_si128((__m128i*)mcnt, vcnt);
	for (i = 0; i < 16; i++) cnt += mcnt[i];

	return cnt;
}

int main() {
	const char x[17] = {'a','b','c','d','a','b','c','d','a','b','c','d','a','b','c','d','a'};
	const char y[17] = {'e','a','b','b','a','b','c','d','a','b','c','d','a','b','c','d','a'};
	printf("chardiff_seq: %d \n", chardiff_seq(x, y, 17));
	printf("chardiff_sse: %d \n", chardiff_sse(x, y, 17));

	return 0;
}