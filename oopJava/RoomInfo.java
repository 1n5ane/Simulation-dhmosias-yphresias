import java.util.LinkedList;
public class RoomInfo{//o xwros apoteleite apo enan arithmo atwmon(num) kai apto pioi einai
        private int num;
        public LinkedList<Visitor> list;

        public RoomInfo(){
                num=0;
                list=new LinkedList<Visitor>();
        }
        public void enter(Visitor v){
                list.add(v);
                num++;
        }
        public Visitor exit(int i){
                Visitor v;
                v=list.remove(i-1);
                num--;
                return v;
        }
        public void esc_enter(){
                num++;
        }
        public void esc_exit(){
                num--;
        }
        public void print(){
                System.out.println("\n\nThere are " + num +" people in this room\n");
                for (int i=1;i<=list.size();i++)
                        (list.get(i-1)).print();
        }
        public int get_numofpeople(){
                return num;
        }
}
