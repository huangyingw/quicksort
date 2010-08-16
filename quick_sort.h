#include <fstream>
#include <iostream>
using namespace std;


class QuickSort
{
private:
	int length;
	ofstream fout; 

public:
	int* data;
	QuickSort(int len);
	~QuickSort();
	void Initial();
	void Sort();
	void Merge(int l,int m,int r);
	void Print(int l,int r);
	void Divide(int len);
	void Print();
};



ofstream fout;
int* data;
int size;
void Initial()
{
	data= new int[size];
	fout.open("output.txt");
}

void Print()
{
	int i;
	for(i=0;i<size;i++)
	{
		fout<<data[i];
	}
	fout<<endl;
}


void Finalize()
{
	delete(data);
	fout.close();
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
		
		Print();
		pivot=Partition(low,high);
		Print();
		fout<<"fuck your mother"<<endl;	
		
		Sort(low,pivot-1);
		Sort(pivot+1,high);
	}
}
