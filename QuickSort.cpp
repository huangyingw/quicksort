// QuickSort.cpp : 定义控制台应用程序的入口点。
//

#include "stdafx.h"
#include<iostream>
#include <fstream>

using namespace std;
ofstream fout; 
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
				list[i]=list[j];
				list[j]=temp;
			}
		}while(i<j);
		temp=list[left];
		list[left]=list[j];
		list[j]=temp;
		fout << "swap "<< list[left]<<"->"<<list[j]<<endl;
		
		fout << "current sorting result:\n" ;
		for(k=0;k<index;k++)
			fout<<list[k];
		fout<<"->pivot:"<<pivot<<"->list[j]->"<<list[j];
		fout<<endl;
		
		QuickSort(list,left,j-1,index);
		QuickSort(list,j+1,right,index);
	}
}

int _tmain(int argc, _TCHAR* argv[])
{
	
	fout.open("output.txt");
	int list[10]={5,8,7,6,9,4,3,2,1,0};
	int index=10;
	QuickSort(list,0,index-1,index);
	fout.close();
	return 0;
}

