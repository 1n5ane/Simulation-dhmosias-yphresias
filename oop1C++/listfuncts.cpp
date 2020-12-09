#include <iostream>

#include "list.h"
using namespace std;
node::node(const Visitor &v,node * x=NULL){
			this->v=v;
			next=x;
}
void List::add_back(const Visitor &v){
	node **x=&(this->head);	//adress of head (head is a node *)
	
	if(this->head!=NULL){ //if list isn't empty
		while ((*x)->next!=NULL)			
			x=&((*x)->next); 	
	
		(*x)->next= new node(v) ;
	}else{
		(*x)=new node(v);	
	}
	size_of_list++;	
}	

Visitor List::remove(const int i){	
	Visitor v;
	node *to_be_rm;
		
	if (i==1){// if 1st node removed
		to_be_rm=this->head;		
		head=head->next;	
	}else{
		node *x=this->head;
		for (int j=2;j<i;j++){
			x=x->next;
		}
		to_be_rm=x->next; //x->next must be removed and value of x->next will point in (x->next)->next	
		x->next=to_be_rm->next;	 
	}
	v=to_be_rm->v;
	delete to_be_rm;
	size_of_list--;
	return v;
	
}

void List::print_list()const{
	node *x=this->head;
	cout << size_of_list<< endl;
	while(x!=NULL){
		x->v.print_Info();
		cout <<"-------------------------" <<endl;
		x=x->next;
	}
}
