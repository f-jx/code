//数组的地址不用加&，用数组名直接表示数组第一个元素的地址
//之后的元素的地址用arrayname+i来表示
#include <iostream>
using namespace std;
 
int main ()
{
   // 带有 5 个元素的整型数组
    double balance[5] = {1000.0, 2.0, 3.4, 17.0, 50.0};
    double *p= balance;

     // 输出数组中每个元素的值
    cout << "array data:" << endl; 
    for ( int i = 0; i < 5; i++ )
    {
        cout << "*(balance + " << i << ") : ";
        cout << *(balance + i) << endl;
    }
    cout << "address data:" << endl;
    for ( int i = 0; i < 5; i++ )
    {
        cout << "(balance + " << i << "):";
        cout << (balance + i) << endl;
    }
   return 0;
}

//  //从函数中返回数组的例子
// #include <iostream>
// #include <ctime>

// using namespace std;

// // 要生成和返回随机数的函数
// int * getRandom( )
// {
//   static int  r[10];

//   // 设置种子
//   srand( (unsigned)time( NULL ) );
//   for (int i = 0; i < 10; ++i)
//   {
//     r[i] = rand();
//     cout << r[i] << endl;
//   }

//   return r;
// }

// // 要调用上面定义函数的主函数
// int main ()
// {
//    // 一个指向整数的指针
//    int *p;

//    p = getRandom();
//    for ( int i = 0; i < 10; i++ )
//    {
//        cout << "*(p + " << i << ") : ";
//        cout << *(p + i) << endl;
//    }

//    return 0;
// }
