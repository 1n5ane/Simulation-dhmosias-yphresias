import java.util.Random;
class Visitor{
        private int floor;
        private int office;
        private int no;//arithmos proteraiothtas
        private boolean has_esc;
        private boolean isok;
        private Escort esc;

        public int get_floor(){
                return this.floor;
        }
        public int get_office(){
                return office;
        }
        public int get_no(){
                return no;
        }
        public boolean get_has_esc(){
                return has_esc;
        }
        public boolean get_isok(){
                return isok;
        }
        public Visitor(){
                floor=askisi4.rand.nextInt(4)+1;//minimum=1,maximum=4
                office=askisi4.rand.nextInt(10)+1;
                has_esc=false;// sthn arxh kaneis den exei escort
                esc=null;
                isok=false;
        }
        public void wait(int i){
                no=i;
                System.out.println("Waiting for the lift!");
        }
        public void print(){
                System.out.println("~--------------~");
                System.out.println("floor: "+floor);
                System.out.println("office: "+office);
                System.out.println("no: "+no);
                System.out.println("has_esc: "+has_esc);
                System.out.println("isok: "+isok);

                if(has_esc==true) this.esc.print();
                else System.out.println("NO ESCORT");
                System.out.println("~--------------~");
        }
        public void serviced(){
                this.isok=true;
        }
        public void set_esc(){
                has_esc=true;
                esc=new Escort(this);
        }

}
