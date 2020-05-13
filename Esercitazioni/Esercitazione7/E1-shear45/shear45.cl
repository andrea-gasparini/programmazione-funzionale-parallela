#define IDX(x,y,w) ((y)*(w)+(x))

__kernel void shear45(__global unsigned char* I,
					  __global unsigned char* O,
					  int h, int w, unsigned char gray) {

    int x = get_global_id(0);
    int y = get_global_id(1);

    if (x >= w+h || y >= h) return;
    
    O[IDX(x, y, w+h)] = (x < y || x >= w+y) ? gray : I[IDX(x-y, y, w)];
}

