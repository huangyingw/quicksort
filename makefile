quick_sort.exe : quick_sort.o 
	g++ -o quick_sort.exe quick_sort.o
quick_sort.o : quick_sort.cc
	g++ -c -o quick_sort.o quick_sort.cc
