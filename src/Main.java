import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner input=new Scanner(System.in);
		int numI;
		double numV;
		String str, passw;
		boolean stopProg=false,stopIns=false, erogata=false;
		
		Distributore dis=new Distributore();
		
		while(!stopProg) {
			System.out.println("--MENU--");
			System.out.println("1 per inserire monetine");
			if(dis.getTotMonetine()>0) {
				System.out.println("2 per scegliere bevanda");
			}
			System.out.println("3 per caricare la macchinetta");
			str=input.next();
			
			switch (str) {
			case "1":
				while(!stopIns) {
					System.out.println("Inserisci monetina o premi 0");
					System.out.println("per terminare inserimento");
					numV=input.nextDouble();
					dis.contaDenaro(numV);
					if(numV==0) {
						stopIns=true;
					}
				}
				stopIns=false;
				break;
			case "2":
				dis.mostraBevande();
				numI=input.nextInt();
				dis.erogaBibita(numI);
				break;
			case "3":
				System.out.println("Inserire password");
				passw=input.next();
				System.out.println("Cosa vuoi aggiungere? ");
				str=input.next();
				System.out.println("Inserisci la quantità ");
				numI=input.nextInt();
				dis.login(passw, str, numI);
				break;
			default : System.out.println("Uscito dallo switch");
					if(!erogata)
						dis.ritornaSoldi();
	   		  		stopProg=true;
			}
		}
		
		
	}

}
