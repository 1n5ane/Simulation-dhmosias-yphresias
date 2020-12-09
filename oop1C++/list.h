#ifndef LIST_H
#define LIST_H
#include "Visitor.h"
struct node{
	
		Visitor v; //no need for private because Visitor data members private
		 node * next;
		 node(const Visitor &,node *);
};

class	List{
	public:
		node *head;
		int size_of_list;
		void add_back(const Visitor &);
		Visitor remove(const int);
		void print_list()const;
		List(){
			head=NULL;
			size_of_list=0;
		}


};
#endif
