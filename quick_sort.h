#include <fstream>
#include <iostream>
using namespace std;

ofstream fout;
int* data;
int size;
void Initial()
{
	//data= (int *) malloc (size * sizeof(int));
	data= new int[size];
}

void Print()
{
	int i;
	for(i=0;i<size;i++)
	{
		printf("%d ", data[i]);
	}
}

void Finalize()
{
		delete(data);
}

int Partition(int i,int j)
{
	int pivot=data[i];
	while(i<j)
	{
		while(i<j&&data[j]>=pivot)
			j--;
		if(i<j)
			data[i++]=data[j];
		while(i<j&&data[i]<=pivot)
			i++;
		if(i<j)
			data[j--]=data[i];
		
	}
	data[i]=pivot;
	return i;
}

void Sort(int low,int high)//¹é²¢ÅÅÐò
{
	if(low<high)
	{
		int pivot;
		pivot=Partition(low,high);
		Sort(low,pivot-1);
		Sort(pivot+1,high);
	}
}
