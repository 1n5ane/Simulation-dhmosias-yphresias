import java.util.Random;
class Elevator extends RoomInfo{
        private void stop_up(Building b,int i){
                int j;
                int after=0;
                while(b.floor[i].get_numofpeople()<askisi4.Nf && this.list.size()!=0 && (after+1)<=this.list.size()){//+ ama h lista dn einai kenh
                        j=this.search(i+1,after);//synartish anazhthshs atomwn apo thn lista pou theloun na kateboun ston orofo pou stamathse to asanser

		        if (j==-1) break;//if nobody found
                                if((this.list.get(j)).get_has_esc()==true){
                                        if(b.floor[i].get_numofpeople()<askisi4.Nf-1){
		                              System.out.println("Entering floor number "+(i+1)+" with my escort <"+(this.list.get(j)).get_no()+">");
                                              this.esc_exit();//o escort vgainei apto asanser
                                              b.floor[i].en.esc_enter();//kai mpainei ston orofo
                                        }else after++;//ama o orofos xwraei ton visitor alla oxi ton escort tote o visitor den katevainei
                                }else System.out.println("Entering floor number "+(i+1)+" <"+(this.list.get(j)).get_no()+">");
		        b.floor[i].en.enter(this.exit(j+1));//autos pou thelei na katebei ston orofo bgainei apto asanser kai mpainei sto entrance tou orofou
	        }


	        after=0;
                j=this.search(i+1,after);

	        if (this.list.size()!=0) //ama to asanser dn einai adeio apo visitor
	               while(j!=-1){ //osoi den xwresan ston orofo emfanizetai minima lathous
                               System.out.println("Sorry, floor number "+(i+1)+" is full "+"<"+(this.list.get(j)).get_no()+">");
                               after++;
			       j=this.search(i+1,after);
                       }

	        int k=1,which_office;

	        if (b.floor[i].en.list.size()!=0){//prospatheia na mpoun sta grafeia oi visitor
		       while (k<=b.floor[i].en.list.size()){
                               which_office=(b.floor[i].en.list.get(k-1)).get_office();
                               if((b.floor[i].en.list.get(k-1)).get_has_esc()==false){//ama den exei escort
                                       if (b.floor[i].office[which_office-1].get_numofpeople()<askisi4.No){//ama xwraei sto office pou thelei na paei (which_office)
                                               System.out.println("Entering office number "+which_office+" <"+(b.floor[i].en.list.get(k-1)).get_no()+">");

				               b.floor[i].office[which_office-1].enter(b.floor[i].en.exit(k)); //o visitor vgainei apto entrance kai mpainei sto grafeio pou thelei

                                       }else{
                                               System.out.println("Please, wait outside for entrance in office number "+which_office+" <"+(b.floor[i].en.list.get(k-1)).get_no()+">");
				               k++;//des pou thelei na paei o epomenos
                                       }
                               }else{
                                       if (b.floor[i].office[which_office-1].get_numofpeople()<askisi4.No-1){//ama xwraei sto office mazi me ton escort
                                               System.out.println("Entering office number "+which_office+" with my escort <"+(b.floor[i].en.list.get(k-1)).get_no()+">");
                                               b.floor[i].en.esc_exit();//o escort kanei exit apto entrance
                                               b.floor[i].office[which_office-1].esc_enter();//kai mpainei sto grafeio
				               b.floor[i].office[which_office-1].enter(b.floor[i].en.exit(k)); //o visitor vgainei apto entrance kai mpainei sto grafeio pou thelei

                                       }else{
                                               System.out.println("Please, wait outside with escort for entrance in office number "+which_office+" <"+(b.floor[i].en.list.get(k-1)).get_no()+">");
				               k++;//des pou thelei na paei o epomenos
                                       }
                               }
                       }

               }}
        private void stop_down(Building b,int i){
                int el_space , get_from_floor , from_office , office_visitors  , who;
                Visitor v;
                boolean [] good=new boolean[10];
                boolean flag=true;
                int k;
                for (k=0;k<10;k++)good[k]=true;//o pinakas periexei thn plhroforia an ena grafeio exei atoma
                                                 //h an theloume na paroume ena atomo kai yparxoun mono zeugaria
                if (this.get_numofpeople()<askisi4.Ni && b.floor[i].get_numofpeople()!=0){

                        el_space=askisi4.Ni-this.get_numofpeople();//diathesimos xwros asanser
                        //System.out.println("\n\n****taking from floor "+(i+1)+" ****");
                        //System.out.println("****elspace: "+(el_space)+" ****");

		        get_from_floor=askisi4.rand.nextInt(el_space)+1 ;// posa atoma tha parei apton orofo
		        if(get_from_floor>b.floor[i].get_numofpeople()-b.floor[i].en.get_numofpeople())//an ta atoma pou tha parw sinolika apton orofo xepernane ta atoma p einai genika sta grafeia
                                get_from_floor=b.floor[i].get_numofpeople()-b.floor[i].en.get_numofpeople(); //tote tha parw osa atoma einai sta grafeia

                        //System.out.println("****taking "+(get_from_floor)+" people ****");
                        while (get_from_floor>0){

                                from_office=askisi4.rand.nextInt(10);//tyxaia epilogh grafeiou
                                for(k=0; k<10;k++)
                                        if(good[k]==true) break;
                                if(k==10) break;//ama den mporoume na paroume
                                               //apo kanena grafeio
			        if(good[from_office]==true && b.floor[i].office[from_office].get_numofpeople()!=0){//elegxos an to grafeio adeio
				        office_visitors=askisi4.rand.nextInt(b.floor[i].office[from_office].get_numofpeople()) + 1;//posa atoma tha parei apto grafeio from_office

				        if (office_visitors>get_from_floor) office_visitors=get_from_floor;
                        //                System.out.println("TAKING FROM OFFICE: "+ (from_office+1));

                      //                System.out.println("****office visitors= "+office_visitors+" ****");
                                        for (int j=1;j<=office_visitors;j++){

                                                who=askisi4.rand.nextInt(b.floor[i].office[from_office].list.size()) + 1;//tyxaia epilogh apta atoma pou einai sto grafeio (to who atomo)
                        //                        System.out.println("||||auton pernw->"+who);
                                                if ((b.floor[i].office[from_office].list.get(who-1)).get_has_esc()==true){//an o visitor exei escort
                                                        if(askisi4.Ni-this.get_numofpeople()>1){//an xwraei sto asanser
                                                                b.floor[i].office[from_office].esc_exit();//tote vgainei o escort apto grafeio
                                                                b.floor[i].en.esc_enter();//kai mpainei sto entrance
                                                                this.esc_enter();//kai sth synexeia sto asanser
                                                                get_from_floor--;
                                                                j++;
                                                        }else{
                        //                                        System.out.println("im here");
                                                                if(b.floor[i].office[from_office].list.size()*2==b.floor[i].office[from_office].get_numofpeople()){
                                                                        good[from_office]=false;
                                                                        break;//an sto asanser yparxei xwros gia enan alla ston xwro yparxoyn mono zeugaria...
                                                                }else
                                                                        continue;
                                                        }
                                                }
                                                v=b.floor[i].office[from_office].exit(who);//vgainei kai o visitor apto grafeio
                                                v.serviced();		//efoson vghke eksipiretithike
                                                b.floor[i].en.enter(v);//autos pou vghke apto grafeio mpainei sto entrance tou orofou
                                                this.enter(b.floor[i].en.exit(b.floor[i].en.list.size()));//autos pou vgainei apton orofo mpainei sto asanser
                                                get_from_floor--;
                                        }
                                }else{//grafeio adeio
                                        good[from_office]=false;
                                }
                        }

                }
        }
        private void empty_all(Building b){//exodos olwn oswn to isok==true
                Visitor v;
                //this.print();
                int limit=this.list.size();
                for(int i=1;i<=limit;){
                        v=this.list.get(i-1);
                        if(v.get_isok()==true){
                                askisi4.serv_today++;
                                this.exit(i);
                                if(v.get_has_esc()==true)//ama exei escort
                                        this.esc_exit();//vgainei kai o escort
                                b.exit(v);
                                limit--;
                        }else i++;
                }
                //System.out.println("After empty_all: "+ this.get_numofpeople());
        }
        public int search(int i, int after){//h synarthsh anazhta poios exei floor i meta ton after komvo ths listas
                int j=after;
                boolean found=false;
                while(found==false&& j+1<=list.size()){
                        if((list.get(j)).get_floor()==i)
                                found=true;
                        else
                                j++;
                }
                if (found==true) return j;
                else return -1;
        }
        public Elevator(){
                System.out.println("A lift has been created");
        }
        public void operate(Building b){
                for(int i=0;i<4;i++) this.stop_up(b,i);
                for(int i=3;i>=0;i--)this.stop_down(b,i);
                this.empty_all(b);
        }

}
