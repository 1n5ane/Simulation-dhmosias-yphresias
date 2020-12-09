class Building{
        private int numofpeople;//if we have more than 1 building this won't work...
        private int numofvis;//NUMOFESCORTS IS numofpeople-numofvis!!!!!!!!!!!!
        Entrance en;
        Floor[] floor;
        Elevator el;
        public int get_numofpeople(){
                return numofpeople;
        }
        public int get_numofvis(){
                return numofvis;
        }
        public void enter(){
                numofpeople++;
                numofvis++;
                Visitor v=new Visitor();
                v.wait(numofvis);
                this.en.enter(v);
        }
        public void esc_enter(){
                (en.list.getLast()).set_esc();
                en.esc_enter();
                System.out.println("\t Also waiting for the lift(escort)");
                numofpeople++;
        }
        public void exit(Visitor v){
                numofpeople--;
                System.out.println("I cannot believe i finished! "+v.get_no());
                if(v.get_has_esc()==true){
                        numofpeople--;
                        System.out.println("\tI cannot believe my friend finished(escort)! "+v.get_no());
                }
        }
        public Building(){
                numofpeople=0;
                numofvis=0;
                en=new Entrance();
                floor=new Floor[4];
                for(int i=0;i<4;i++)
                        floor[i]=new Floor();
                el=new Elevator();
                System.out.println("A new building is ready for serving citizens!");
        }
}
