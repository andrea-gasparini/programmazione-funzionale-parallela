#include <stdio.h>
#include <immintrin.h>

void somma(int A[8], int B[8], int C[8]) {
	C[0] = A[0] + B[0];
	C[1] = A[1] + B[1];
	C[2] = A[2] + B[2];
	C[3] = A[3] + B[3];
	C[4] = A[4] + B[4];
	C[5] = A[5] + B[5];
	C[6] = A[6] + B[6];
	C[7] = A[7] + B[7];
}

void somma_avx(int A[8], int B[8], int C[8]) {
	__m256i a, b, c;
	a = _mm256_loadu_si256((__m256i*)A);
	b = _mm256_loadu_si256((__m256i*)B);
	c = _mm256_add_epi32(a, b);
  _mm256_storeu_si256((__m256i*)C, c);
}

int main() {
	int A[8] = { 1, 2, 3, 4, 1, 2, 3, 4 };
	int B[8] = { 4, 3, 2, 1, 4, 3, 2, 1 };
  int C[8];

  somma_avx(A, B, C);
  printf("%d %d %d %d %d %d %d %d\n", C[0], C[1], C[2], C[3], C[4], C[5], C[6], C[7]);

	somma(A, B, C);
  printf("%d %d %d %d %d %d %d %d\n", C[0], C[1], C[2], C[3], C[4], C[5], C[6], C[7]);

  return 0;
}