run : main.o 
	g++ -o run main.o
main.o : quick_sort.c
	g++ -c -o main.o quick_sort.c
