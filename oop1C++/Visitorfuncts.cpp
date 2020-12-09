#include <iostream>
#include "Visitor.h"
using namespace std;
int Visitor::get_floor()const{
	return floor;
}

int Visitor::get_office()const{
	return office;
}

int Visitor::get_no()const{
	return no;
}

void Visitor::set_Info(const int floor=0,const int office=0,const int no=-1){
	this->floor=floor;
	this->office=office;
	this->no=no;
}

void Visitor::print_Info()const{
	cout <<"floor:" <<floor<<endl;
	cout <<"office:" <<office<<endl;
	cout <<"no:" <<no<<endl; 

}

bool Visitor::get_isok()const{
	return isok;
}

void Visitor::wait(int y=1){
	static int x=0;
	if (y==0) x=0;
	x++;
	cout <<"Waiting for the lift" <<endl;
	this->no=x;
}

Visitor::Visitor(int floor,int office,int no){
	this->floor=floor;
	this->office=office;
	this->no=no;
	this->isok=false;

}

Visitor::Visitor(const Visitor &v){
	this->floor=v.floor;
	this->office=v.office;
	this->no=v.no;
	this->isok=v.isok;
}

