void vecsum(int* A, int* B, int* C, int n) {
	int i;
	for (i = 0; i < n; ++i)  C[i] = A[i] + B[i];
}

void vecsum_sse(int* A, int* B, int* C, int n) {
	int i;
	for (i = 0; i + 3 < n; i += 4) {
		__m128i a, b, c;
		a = _mm_loadu_si128((const __m128i*)(A + i));
		b = _mm_loadu_si128((const __m128i*)(B + i));
		c = _mm_add_epi32(a, b);
		_mm_storeu_si128((__m128i*)(C + i), c);
	}

	for (; i < n; ++i) C[i] = A[i] + B[i];
}