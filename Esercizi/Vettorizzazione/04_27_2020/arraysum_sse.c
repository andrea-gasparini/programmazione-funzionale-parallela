#include <stdio.h>
#include <immintrin.h>

int arraysum(int* v, int n) {
	int i, sum = 0;

	for (i = 0; i < n; i++) sum += v[i];

	return sum;
}

int arraysum_unroll(int* v, int n) {
	int i, c[4] = {0}, res = 0;

	for (i = 0; (i + 3) < n; i += 4) {
		c[0] += v[i+0];
		c[1] += v[i+1];
		c[2] += v[i+2];
		c[3] += v[i+3];
	}
	while (i++ < n) res += v[i]; // sommo eventuali valori rimanenti

	return res + c[0] + c[1] + c[2] + c[3];
}

int arraysum_sse(int* v, int n) {
	int i, c[4] = {0}, res = 0;
	__m128i s = _mm_set_epi32(0, 0, 0, 0);

	for (i = 0; (i + 3) < n; i += 4) {
		__m128i vv = _mm_loadu_si128((__m128i*)(v + i));
		s = _mm_add_epi32(s, vv);
	}
	_mm_storeu_si128((__m128i*)c, s);

	while (i < n) res += v[i++]; // sommo eventuali valori rimanenti

	return res + c[0] + c[1] + c[2] + c[3];
}

int main() {
	int v[5] = {1,2,3,4,5};
	printf("%d \n", arraysum_sse(v, 5));
}