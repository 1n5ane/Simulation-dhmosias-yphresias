class Floor{
        private static int id=1;//which Floor
        public Entrance en;//no need for private because entrance has private data members
        public Office[] office;//the same
        public Floor(){
                en=new Entrance();
                office=new Office[10];
                for(int i=0;i<10;i++)
                        office[i]=new Office();
                System.out.println("A Floor has been created with number "+id);
                id++;
        }
        public int get_numofpeople(){
                int sum=0;
                for(int i=0;i<10;i++) sum=sum+office[i].get_numofpeople();
                sum+=en.get_numofpeople();
                return sum;
        }
}
