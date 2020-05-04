CC     = gcc
CFLAGS = -O1 -Wall -g
LFLAGS = -msse4.2

e1: e1-main.c e1.c e1.h
	$(CC) $(CFLAGS) e1-main.c e1.c -o e1 $(LFLAGS)

.phony: clean

clean:
	rm -rf e1 *.dSYM
