// QuickSort.cpp : 定义控制台应用程序的入口点。
//

#include "stdafx.h"
#include<iostream>
#include <fstream>

using namespace std;
void QuickSort(int* list,int left,int right,int index)
{
	int i,j,k;
	int pivot;
	int temp;
	i=left,j=right+1;
	pivot=list[left];
	if(i<j)
	{
		do
		{
			do
			{
				i++;
			}while(list[i]<=pivot&&i<=right);
			do
			{
				j--;
			}while(list[j]>=pivot&&j>left);
			if(i<j)
			{
				temp=list[i];
				list[i]=list[j];//交换list[i],list[j]的值
				list[j]=temp;
				cout<<"current sorting result:";
				for(k=0;k<index;k++)
				{
					cout<<list[k];
				}
				cout<<"pivot:"<<pivot;
				cout<<endl;
			}
		}while(i<j);
		temp=list[left];
		list[left]=list[j];
		list[j]=temp;
		cout<<"current sorting result:";
		for(k=0;k<index;k++)cout<<list[k];
		cout<<"->pivot:"<<pivot;
		cout<<endl;
		QuickSort(list,left,j-1,index);
		QuickSort(list,j+1,right,index);
	}
}

int _tmain(int argc, _TCHAR* argv[])
{
	ofstream fout; 
	fout.open("output.txt");
	for (int i=1; i<=20; i++)
     {
           fout << "The " << i << " Line\n" ;

     }

     fout.close();

	int list[10]={9,8,7,6,5,4,3,2,1,0};
	int index=10;
	QuickSort(list,0,index-1,index);
	return 0;
}

