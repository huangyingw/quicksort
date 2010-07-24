run : main.o 
	gcc -o run main.o
main.o : quick_sort.c
	gcc -c -o main.o quick_sort.c
