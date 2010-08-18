#include <fstream>
#include <iostream>
using namespace std;


class QuickSort
{
private:
	ofstream fout; 

public:
	int* data;
	int size;
	QuickSort(int len);
	~QuickSort();
	void Print();
	void Sort(int low,int high);//πÈ≤¢≈≈–Ú
	int Partition(int i,int j);
};

QuickSort::QuickSort(int len)
{
	size=len;
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


QuickSort::~QuickSort()
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

void QuickSort::Sort(int low,int high)//πÈ≤¢≈≈–Ú
{
	if(low<high)
	{
		int pivot;
		cout<<"1"<<endl;
		Print();
		pivot=Partition(low,high);
		Print();
		
		Sort(low,pivot-1);
		Sort(pivot+1,high);
	}
}
