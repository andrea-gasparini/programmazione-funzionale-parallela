#include <immintrin.h>
#include "e2.h"


// ---------------------------------------------------------------------
// count_occ
// ---------------------------------------------------------------------
// SSE version

int count_occ(const char* v, int n, char x) {
	int i, cnt = 0;
    char ccnt[16];

    __m128i vval = _mm_set1_epi8(x); 
    __m128i vcnt = _mm_setzero_si128();

    for (i = 0; (i + 15) < n; i += 16) {
        __m128i vv = _mm_loadu_si128((__m128i*)(v + i));
        
        // comparazione vettoriale (il risultato ha val = 0 se diff, -1 se non)
        __m128i vres = _mm_cmpeq_epi8(vv, vval);

        vcnt = _mm_add_epi8(vres, vcnt);

        if (i % 127 == 0) {
			_mm_storeu_si128((__m128i*)ccnt, vcnt);
			for (int k = 0; k < 16; k++) cnt -= ccnt[k];
			vcnt = _mm_setzero_si128();
		}
    }

    _mm_storeu_si128((__m128i*)ccnt, vcnt);
    for (int k = 0; k < 16; k++) cnt -= ccnt[k];
    
    while (x == v[i] && i++ < n) cnt++;

	return cnt;
}




// ---------------------------------------------------------------------
// count_occ_seq
// ---------------------------------------------------------------------
// sequential version

int count_occ_seq(const char* v, int n, char x) {
    int i, cnt = 0;
    for (i=0; i<n; ++i) cnt += v[i] == x;
    return cnt;
}
