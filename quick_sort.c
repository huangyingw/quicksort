
#include "quick_sort.h"

int main()
{
  size=7;
  Initial();
  data[0]=0; 
  data[1]=1;
  data[2]=2;
  data[3]=6;
  data[4]=4;
  data[5]=5;
  data[6]=3;
  Sort(0,6);
  Print();	
  printf("\n");
  Initial();
  data[0]=6; 
  data[1]=5;
  data[2]=4;
  data[3]=3;
  data[4]=2;
  data[5]=1;
  data[6]=0;
  Sort(0,6);
  Print();	
  printf("\n");
  return 0;
}

