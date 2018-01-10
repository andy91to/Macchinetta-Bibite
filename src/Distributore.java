
public class Distributore {
	private static int coca=10;
	private static int fanta=10;
	private static int acqua=0;
	private static int[] lattine=new int[] {coca,fanta,acqua};
	public static double totSoldiMacchinetta;
	static int numeroTipiBibite=3;

//dichiarazione variabili (nome bibita,numero lattine contenute nel distributore e prezzo di ciascuna) 

	private String[] nomeBibite= {"Coca","Fanta","Acqua"};
	private static int[] numLattine= {1,0,0};
	private double[] prezziLattine= {0.75,0.50,0.30};
	private String passw="admin";
	
	private static double denaroTotale=0;
	private static double totMonetine=0;
	int indice;
	boolean flag=false;

	public void contaDenaro(double monetina) {
		totMonetine+=monetina;
	}
	
	private void contaGuadagnoTot(double nuovoGuadagno) {
		denaroTotale+=nuovoGuadagno;
	}
	
//GETTERS E SETTERS
	
	public double getTotMonetine() {
		return totMonetine;
	}
	public static double getDenaroTotale() {
		return denaroTotale;
	}
	
	public void mostraBevande() {
		System.out.println("--------------------");
		System.out.println("Bevande disponibili: ");
		System.out.println("--------------------");
		System.out.println("Denaro a disposizione: "+totMonetine+"�");
		for (int i = 0; i < nomeBibite.length; i++) {
			if(numLattine[i]>0) {
				System.out.println("-"+(i+1)+" "+nomeBibite[i]+" "+"prezzo "+prezziLattine[i]+"�");
			}
			else
				System.out.println(nomeBibite[i]+" non disponibile");
		}
	}
	
	public void erogaBibita(int indice) {
		int j=indice-1;
		if (numLattine[j]==0) {
			System.out.println("Prodotto non disponibile,");
			System.out.println("ripetere operazione!");
			ritornaSoldi();
			
		}
		else if(prezziLattine[j]>totMonetine) {
			System.out.println("Denaro insufficiente");
			ritornaSoldi();
			
		}
		else {
			numLattine[j]=numLattine[j]-1;
			System.out.println(nomeBibite[j]+" erogata");
			denaroTotale+=prezziLattine[j];
			System.out.println("Denaro incassato dalla macchinetta: "+denaroTotale);
			daiResto(j);
			System.out.println(numLattine[0]+" "+numLattine[1]+" "+numLattine[2]);
		}
	}
	
	public void ritornaSoldi() {
		System.out.println("Ritirare i "+totMonetine+"� da te inseriti");
		totMonetine=0;
	}
	
	public void daiResto(int indice) {
		System.out.println("Ritira il resto di "+(totMonetine-prezziLattine[indice]));
		totMonetine=0;
	}
	public void login(String password, String nomeB, int n) {
		if(password.equals(passw)) {
			caricaMacchinetta(nomeB, n);
			System.out.println(numLattine[0]+" "+numLattine[1]+" "+numLattine[2]);
		}
		else {
			System.out.println("Password non valida");
		}
	}
	public void caricaMacchinetta(String nomeB,int n) {
		if(n>0) {
			for(int i=0;i<nomeBibite.length;i++) {
				if (nomeBibite[i].equalsIgnoreCase(nomeB)) {
					numLattine[i]+=n;
					System.out.println(nomeB+" aggiunta correttamente!");
					flag=true;
				}
				if(flag=false) {
					System.out.println("Nome bibita insesistente");
				}
			}
		}
		else
			System.out.println("Hai inserito un numero negativo");
		
	}
	
}
