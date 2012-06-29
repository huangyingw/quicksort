quick_sort.exe : quick_sort.o 
	gcc -o quick_sort.exe quick_sort.o
main.o : quick_sort.c
	gcc -c -o quick_sort.o quick_sort.c
