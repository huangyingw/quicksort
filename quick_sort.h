#include <fstream>
#include <iostream>
using namespace std;

class QuickSort
{
  private:

  public:
    int* data;
    int size;
    QuickSort(int len);
    ~QuickSort();
    void Print();
    void Sort(int low,int high);
    int Partition(int i,int j);
};

QuickSort::QuickSort(int len)
{
  size=len;
  data= new int[size];
}

void QuickSort::Print()
{
  int i;
  for(i=0;i<size;i++)
    cout<<data[i];
  cout<<endl;
}


QuickSort::~QuickSort()
{
  delete(data);
}

int QuickSort::Partition(int i,int j)
{
  int pivot=data[i];
  while(i<j)
  {
    while(i<j&&data[j]>pivot)
      j--;
    while(i<j&&data[i]<pivot)
      i++;
    if(i<j) {
      data[i]^=data[j];
      data[j]^=data[i];
      data[i]^=data[j];
    }
  }
  data[i]=pivot;
  return i;
}

void QuickSort::Sort(int low,int high)
{
  if(low<high)
  {
    int pivot;
    Print();
    pivot=Partition(low,high);
    Print();

    Sort(low,pivot-1);
    Sort(pivot+1,high);
  }
}
