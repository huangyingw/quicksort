#include <fstream>
#include <iostream>
using namespace std;


class QuickSort
{
private:
	int size;
	ofstream fout; 

public:
	int* data;
	QuickSort(int len);
	~QuickSort();
	void Initial();
	void Print();
	void Print();
};



void QuickSort::Initial()
{
	data= new int[size];
	fout.open("output.txt");
}

void QuickSort::Print()
{
	int i;
	for(i=0;i<size;i++)
	{
		fout<<data[i];
	}
	fout<<endl;
}


void QuickSort::Finalize()
{
	delete(data);
	fout.close();
}

int QuickSort::Partition(int i,int j)
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

void QuickSort::Sort(int low,int high)//¹é²¢ÅÅÐò
{
	if(low<high)
	{
		int pivot;
		
		Print();
		pivot=Partition(low,high);
		Print();
		fout<<"fuck your mother"<<endl;	
		
		Sort(low,pivot-1);
		Sort(pivot+1,high);
	}
}
