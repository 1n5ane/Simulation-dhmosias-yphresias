#include <iostream>
#include "classes.h"
using namespace std;
/*       ROOMINFO              */
RoomInfo::RoomInfo(){
	num=vislist.size_of_list;
}

void RoomInfo::print_RoomInfo()const{
	cout <<"current visitors:" << num <<endl;
	vislist.print_list();
}

int RoomInfo::get_numofpeople()const{
	return num;
}

void RoomInfo::enter(const Visitor &v){
	vislist.add_back(v);
	num=vislist.size_of_list;
}

Visitor RoomInfo::exit(int i){
	Visitor v;
	v=vislist.remove(i);
	num=vislist.size_of_list;
	return v;
}


/*             ENTRANCE                    */

Entrance::Entrance(){
	cout<<"A new entrance has been created" <<endl;
}

/*	     ELEVATOR			  */

Elevator::Elevator(){
	cout <<"A lift has been created" <<endl;
}

/*                   OFFICE               */

Office::Office(const int j){
	static int i=1;
	cout <<"Office with number <"<<i<<">has been created" << endl;
	i++;
	if (i>j)i=1;
}

/*          FLOOR                       */

Floor::Floor(const int j){
	static int i=1;
	cout <<"Floor with number <"<<i<<"> has been created " << endl;
	i++;
	if(i>j)i=1;
}

/*           BUILDING          */

Building::Building(){
	cout <<"A new building is ready for serving citizens" <<endl;
}







