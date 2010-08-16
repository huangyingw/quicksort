run : main.o 
	g++ -o run main.o
main.o : quick_sort.cpp
	g++ -c -o main.o quick_sort.cpp
