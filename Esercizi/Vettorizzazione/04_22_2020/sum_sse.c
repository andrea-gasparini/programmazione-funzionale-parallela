#include <stdio.h>
#include <immintrin.h>

void somma(int A[4], int B[4], int C[4]) {
	C[0] = A[0] + B[0];
	C[1] = A[1] + B[1];
	C[2] = A[2] + B[2];
	C[3] = A[3] + B[3];
}

void somma_sse(int A[4], int B[4], int C[4]) {
	__m128i a, b, c;
	a = _mm_loadu_si128((__m128i*)A);
	b = _mm_loadu_si128((__m128i*)B);
	c = _mm_add_epi32(a, b); // suddivide in 32 byte e fa le somme
  _mm_storeu_si128((__m128i*)C, c);
}

int main() {
	int A[4] = { 1, 2, 3, 4 };
	int B[4] = { 4, 3, 2, 1 };
  int C[4];

  somma_sse(A, B, C);
  printf("%d %d %d %d\n", C[0], C[1], C[2], C[3]);

  return 0;
}