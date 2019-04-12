//类：就是用户定义的类型的意思
//例如iostream，string，这些都是C++内部定义的类
//结构体struct可以看作一种特殊的类
//类的成员可以是函数
//类的访问限制通过public，private（默认），protected来设置
//public可以在类之外设置，private不能直接设置，protected类似private但可以在其子类中进进行设置。
#include <iostream>

using namespace std;

class Line
{
  public:
    int getLength(void);
    Line(int len);         //构造函数：新对象被创建时执行
    Line(const Line &obj); //拷贝构造函数
    ~Line();               //析构函数：对象被删除时执行

  private:    //私有成员，必须通过公有成员函数set和get，来设置和访问
    int *ptr; //public中属性名改变时，所有直接调用该属性的代码都要更改，而private不存在此种情形，只要其对应的set和get接口不变即可。
};

// 成员函数定义，包括构造函数
Line::Line(int len)
{
    cout << "Normal constructor allocating ptr" << endl;
    // 为指针分配内存
    ptr = new int;
    *ptr = len;
}

Line::Line(const Line &obj)
{
    cout << "Copy constructor allocating ptr." << endl;
    ptr = new int;
    *ptr = *obj.ptr; // copy the value
}

Line::~Line(void)
{
    cout << "Freeing memory!" << endl;
    delete ptr;
}
int Line::getLength(void)
{
    return *ptr;
}

void display(Line obj)
{
    cout << "Length of line : " << obj.getLength() << endl;
}

// 程序的主函数
int main()
{
    Line line1(10);

    Line line2 = line1; // 这里也调用了拷贝构造函数

    display(line1);
    display(line2);

    return 0;
}