import java.util.Random;
public class askisi4{
        public static int N;
        public static int Nf;
        public static int Ng;
        public static int No;
        public static int Ni;
        public static int K;
        public static int L;
        public static Random rand=new Random();
        public static int serv_today=0;
        public static void main(String[] args){
                /*                                       ELEGXOS EISODOU                              */
	if (args.length!=7){

		System.out.println("usage:");
		System.out.println("\tjava askisi4<space>N<space>Nf<space>Ng<space>No<space>Ni<space>K<space>L\n");
		System.out.println("where:   N=capacity of building");
		System.out.println("\t Nf=floor capacity(<N/3)");
		System.out.println("\t Ng=groundfloor capacity(<N/2)");
		System.out.println("\t No=office capacity(<Nf)");
		System.out.println("\t Ni=elevator capacity(>No)");
		System.out.println("\t K=visitors that want to be serviced");
		System.out.println("\t L=elevator cycles(up and down)");
		System.exit(1);

	}
	askisi4.N=Integer.parseInt(args[0]);
	askisi4.Nf=Integer.parseInt(args[1]);
	if(askisi4.Nf<askisi4.N/3){
	        askisi4.Ng=Integer.parseInt(args[2]);
		if(askisi4.Ng<askisi4.N/2){
			askisi4.No=Integer.parseInt(args[3]);
			if(askisi4.No<askisi4.Nf){
				askisi4.Ni=Integer.parseInt(args[4]);
				if (askisi4.Ni>askisi4.No){
					askisi4.K=Integer.parseInt(args[5]);
					askisi4.L=Integer.parseInt(args[6]);
				}else{//Ni error
					System.out.println("Ni must be bigger than No");
                                        System.exit(1);
				}
			}else{//No error
				System.out.println("No must be smaller than Nf");
                                System.exit(1);
			}
		}else{//Ng error
			System.out.println("Ng must be smaller than N/2");
                        System.exit(1);
		}
	}else{//Nf error
		System.out.println("Nf must be smaller than N/3");
                System.exit(1);
	}


/*                                   TELOS ELEGXOU                                      */

                int i;
                Random rand=new Random();
                Building b=new Building();

                while(askisi4.L>0){
                        while(b.get_numofpeople()<askisi4.N && askisi4.K>0 && b.en.get_numofpeople()<askisi4.Ng){
                                b.enter();
                                askisi4.K--;
                                if(b.en.get_numofpeople()<askisi4.Ng)
                                        if(rand.nextInt(2)==1){//possible values 0 and 1.. Here is decided whether next visitor is escort
                                                b.esc_enter();
                                                askisi4.K--;
                                        }
                        }

                        for(i=1;i<=askisi4.K;i++)
                                System.out.println("Please, come tomorrow");

                        while (b.el.get_numofpeople()<askisi4.Ni && b.en.get_numofpeople()>0 ){
                                if((b.en.list.get(0)).get_has_esc()==true){//an to atomo pou prokeite na mpei sto asanser exei escort
                                        if(b.el.get_numofpeople()<askisi4.Ni-1){//to asanser prepei na xwraei kai ton visitor kai ton escort
                                                b.en.esc_exit();//******o escort feugei apton xwro eisodou tou building****
                                                b.el.esc_enter();//*****kai mpainei sto el mazi me ton filo tou
                                                b.el.enter(b.en.exit(1));
                                                System.out.println("Visitor in the lift with escort");
                                        }else break;//ama den xwrane kai oi dyo den mpainei kaneis
                                }else{
                                        b.el.enter(b.en.exit(1));//autos pou mpainei sto asanser
        						      //kanei exit apo to entrance kai einai panta o prwtos
        						      //gt einai autos p exei proteraiothta!!!!!(autoi pou den ekshphretithikan den vgainoun
                                        System.out.println("Visitor in the lift");

                                }
        		}

                        for(i=1;i<=b.en.list.size();i++){
                                if((b.en.list.get(i-1)).get_has_esc()==true)
                                        System.out.println("You and your escort are not allowed to enter "+(b.en.list.get(i-1)).get_no());
                                else
                                        System.out.println("You are not allowed to enter " +(b.en.list.get(i-1)).get_no());
                        }
                        //System.out.println("\nElevator:\n");
                        //b.el.print();
                        b.el.operate(b);
                        askisi4.L--;
                        //System.out.println(askisi4.L);
                }
                System.out.println(askisi4.serv_today+" people were serviced today!");
        }
}
