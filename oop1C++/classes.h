#ifndef CLASSES_H
#define CLASSES_H
#include "list.h"
/* ROOMINFO*/
class RoomInfo{
	private:	
		int num;//how many visitors
		List vislist;//list of visitors
	public:
		
		RoomInfo();
		int get_numofpeople()const;
		void enter(const Visitor &);
		Visitor exit(int);
		void print_RoomInfo()const;
		
};

class Entrance{//xwros eisodou
	public:
		RoomInfo en; //no need for private because en has private data members
		Entrance();
};

class Office{
	public:          										/////// DESTRUCTORS MISSING!!!!!!!!!!!!!!!
		RoomInfo in_the_office;
		Office(const int j=10);
};

class Floor{
	public:		
		Entrance en;
		Office office[10];
		Floor(const int j=4); // 4 floors
};

class Elevator{
	public:
		RoomInfo el;  	//no need for private because el has private data members
		Elevator();
};

class Building{
	public:
		Entrance en;
		Floor floor[4];
		Elevator el;
		Building();
		////////////////////////// +num of people in building
};
#endif
