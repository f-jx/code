#include <iostream>
#include <string>
using std::cin;
using std::endl;
using std::cout;
using std::string;
int main()
{
	cout<<"Please enter your first name:";
	string name;
	cin>>name;
	const string greeting="Hello, "+name+"!";
	const int pad=2;
	const int rows=pad*2+3;
	const string::size_type cols=greeting.size()+pad*2+2;
	cout<<endl;
	for (int r=0; r!=rows; ++r){
		for (string::size_type c=0; c!=cols; ++c){
			if (r==pad+1 && c==pad+1){
				cout<<greeting;
				c+=greeting.size()-1;}
			//减一是因为此步骤执行后还会执行++c
			else if (r==0 || r==rows-1 || c==0 || c==cols-1)
				cout<<'*';
			else cout<<' ';}
		cout<<endl;}
	return 0;}
