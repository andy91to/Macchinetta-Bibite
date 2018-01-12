import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner input=new Scanner(System.in);
		int numI;
		double numV;
		String str, password;
		boolean stopProg=false,stopIns=false, erogata=false;
		
		Distributore dis=new Distributore();
		
		while(!stopProg) {
			System.out.println("--MENU--");
			System.out.println("1 Per inserire monetine");
			if(dis.getTotMonetine()>0) {
				System.out.println("2 per scegliere bevanda");
			}
			System.out.println("3 per caricare la macchinetta");
			if(dis.getDenaroTotale()>0) {
				System.out.println("4 per conoscere incasso totale macchinetta");
			}
			
			str=input.next();
			System.out.print("\n");
			
			switch (str) {
			case "1":
				while(!stopIns) {
					System.out.println("--[Inserisci monetina e premi 0 per terminare inserimento]--");
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
				System.out.println("--[Inserire password]--");
				password=input.next();
				dis.avviaCarico(dis.verificaPassword(password));				
				break;
			case "4":
				numV=dis.getDenaroTotale();
				System.out.println("Denaro incassato dal distributore "+numV);
				break;
			default : System.out.println("!!!!Opzione non disponibile!");
					if(!erogata)
						dis.ritornaSoldi();
					System.out.println("");
//	   		  		stopProg=true;
			}
		}
		
		
	}

}
