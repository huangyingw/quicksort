// QuickSort.cpp :
#include <fstream>
#include <iostream>
#include "quick_sort.h"
using namespace std;

int main()
{
	QuickSort *qs=new QuickSort(7);

	qs->data[0]=0; 
	qs->data[1]=1;
	qs->data[2]=2;
 	qs->data[3]=6;
  qs->data[4]=4;
	qs->data[5]=5;
  qs->data[6]=3;
	qs->Sort(0,6);
	qs->Print();	
	cout<<endl;
	
	return 0;
}

