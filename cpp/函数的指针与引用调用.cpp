#include <iostream>
using namespace std;

// 函数声明
void swap1(int *x, int *y);
void swap2(int &x, int &y);

int main ()
{
   // 局部变量声明
   int a = 100;
   int b = 200;
 
   cout << a << " " << &a << endl;
   cout << b << " " << &b << endl;

   //指针调用函数
   swap1(&a, &b);

   cout << a << " " << &a << endl;
   cout << b << " " << &b << endl;

   //将a，b值重置
   a = 100;
   b = 200;

   //引用调用函数
   swap2(a,b);

   cout << a << " " << &a << endl;
   cout << b << " " << &b << endl;
 
   return 0;
}
//指针调用函数定义：
void swap1(int* x, int *y)  //定义x，y为指针变量
//x，y是两个指针变量，分别指向a，b的地址：int * x = &a; int * y = &b;
{
   int temp;
   temp = *x;	//将，指针x指向的内存地址中的数值，赋给变量temp
   *x = *y;		//将，指针y指向的内存地址中的数值，存储到，指针x所对应的内存地址中
   *y = temp;	//将temp数值，存储到，指针y所对应的内存地址中
  
   return;
}
//引用调用函数定义：
void swap2(int &x, int &y)   //把实参所对应的地址贴上第二个标签
//x，y成为a，b对应内存地址的第二标签：int & x = a; int & y = b;
//相当于直接对a，b进行操作。
{
   int temp;
   temp = x; //将x的值赋给变量temp
   x = y;    //将y的值赋给x，实质上改变的是x所对应内存地址中的数值
   y = temp; //将temp的值赋给y，实质上改变的是y所对应内存地址中的数值
  
   return;
}