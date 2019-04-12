#include <iomanip>
#include <ios>
#include <iostream>
#include <string>
using std::cin;
using std::setprecision;
using std::cout;
using std::string;
using std::endl;
using std::streamsize;
//using std::pricision;
int main(){
	//请求输入姓名
	cout<<"Please enter students\' name: ";
	string name;
	cin>>name;
	cout<<"Hello, "<<name<<"!"<<endl;
	//请求输入并读入期中期末成绩
	cout<<"Please enter your midterm and final exam grades: ";
	double midterm,ultimate;
	cin>>midterm>>ultimate;
	//请求输入家庭作业成绩并计算成绩数目与总和
	cout<<"Enter all your homework grades, "
		"followed by end-of-file: ";
	int count=0;
	double sum=0;
	double x;
	while (cin>>x){
		++count; sum+=x;}
	streamsize prec=cout.precision();
	cout<<"Your final grade is "<<setprecision(3)
		<<0.2*midterm+0.4*ultimate+0.4*sum/count
		<<setprecision(prec)<<endl;
	return 0;}
