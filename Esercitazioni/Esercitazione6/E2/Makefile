CC     = gcc
CFLAGS = -O1 -Wall -g
LFLAGS = -msse4.2

e2: e2-main.c e2.c e2.h
	$(CC) $(CFLAGS) e2-main.c e2.c -o e2 $(LFLAGS)

.phony: clean

clean:
	rm -rf e2 *.dSYM
