class Escort{
        private int floor;//tou
        private int office;//   visitor
        private int no;//arithmos proteraiothtas tou visitor
        private boolean is_esc;
        public int get_floor(){
                return this.floor;
        }
        public int get_office(){
                return office;
        }
        public int get_no(){
                return no;
        }
        public void print(){
                System.out.println("\t~--------------~");
                System.out.println("\tis_esc: "+is_esc);
                System.out.println("\tfloor: "+floor);
                System.out.println("\toffice: "+office);
                System.out.println("\tno: "+no);
                System.out.println("\t~--------------~");
        }
        public Escort(Visitor v){
                floor=v.get_floor();
                office=v.get_office();
                no=v.get_no();
                is_esc=true;
        }
}
