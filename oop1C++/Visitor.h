#ifndef VISITOR_H
#define VISITOR_H
class Visitor{
	private:
		int floor;
		int office;
		int no;
		bool isok;
	public:
		Visitor(int floor=0,int office=0,int no=-1);
		Visitor(const Visitor &);
		int get_floor()const;
		int get_office()const;
		int get_no()const;
		void set_Info(const int,const int,const int);	
		void print_Info()const;
		bool get_isok()const;
		void wait(int);

};
#endif
