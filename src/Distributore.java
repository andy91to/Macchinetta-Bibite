import java.util.Scanner;

public class Distributore {

	// dichiarazione variabili (nome bibita,numero lattine contenute nel
	// distributore e prezzo di ciascuna)

	private String[] nomeBibite = { "Coca", "Fanta", "Acqua" };
	private static int[] numLattine = { 10, 7, 9 };
	private double[] prezziLattine = { 0.75, 0.50, 0.30 };
	private String passw = "admin";

	private static double denaroTotale = 0;
	private static double totMonetine = 0;
	int indice;
	boolean flag = false;

	public void contaDenaro(double monetina) {
		totMonetine += monetina;
	}

	private void contaGuadagnoTot(double nuovoGuadagno) {
		denaroTotale += nuovoGuadagno;
	}

	// GETTERS E SETTERS

	public double getTotMonetine() {
		return totMonetine;
	}

	public static double getDenaroTotale() {
		return denaroTotale;
	}

	public void mostraBevande() {
		
		System.out.println("Denaro a disposizione: " + totMonetine + "€");
		System.out.println("--------------------");
		System.out.println("Bevande disponibili: ");
		System.out.println("--------------------");
		for (int i = 0; i < nomeBibite.length; i++) {
			if (numLattine[i] > 0) {
				System.out.println("-" + (i + 1) + " " + nomeBibite[i] + " " + "prezzo " + prezziLattine[i] + "€");
			} else
				System.out.println(nomeBibite[i] + " non disponibile");
		}
	}

	public void erogaBibita(int indice) {
		
		int j = indice - 1;
		if (numLattine[j] == 0) {
			System.out.println("\n");
			System.out.println("Prodotto non disponibile, ripetere operazione!");
			ritornaSoldi();
		} 
		else if (prezziLattine[j] > totMonetine) {
			System.out.println("\n");
			System.out.println("Denaro insufficiente");
			ritornaSoldi();
		} 
		else {
			numLattine[j] = numLattine[j] - 1;
			System.out.println(nomeBibite[j] + " erogata");
			denaroTotale += prezziLattine[j];
			System.out.println("Denaro incassato dalla macchinetta: " + denaroTotale);
			daiResto(j);
		}
	}

	public void ritornaSoldi() {
		
		System.out.println("--[Ritirare i " + totMonetine + "€ da te inseriti]--");
		totMonetine = 0;
	}

	public void daiResto(int indice) {
		
		System.out.println("\n--[Ritira il resto di " + (totMonetine - prezziLattine[indice])+"]--");
		totMonetine = 0;
	}

	public void caricaMacchinetta(String nomeB, int n) {
		int indiceL=trovaIndice(nomeB);
		if (n > 0) {
			if (indiceL!=(-1)) {
					numLattine[indiceL] += n;
					System.out.println("\n--["+nomeBibite[indiceL] + " aggiunta correttamente!]--\n");
					System.out.println("--------------------");
					System.out.println("Lattine disponibili"); 
					System.out.println("--------------------");
					stampaLattine();
					System.out.println("\n");
			}
			else {
					System.out.println("!!!!Nome bibita inesistente\n");
				 }
		} else
			System.out.println("!!!!Hai inserito un numero negativo");
	}

	public boolean verificaPassword(String password) {
		
		boolean passwIdentica = false;
		if (password.equals("admin"))
			passwIdentica = true;
		else
			System.out.println("\n!!!!Password sbagliata!\n");
		return passwIdentica;
	}
	
	public void avviaCarico(boolean passwordIdentica) {
		
		Scanner in= new Scanner(System.in);
		String tipoLattina;
		int numLat;
		if(passwordIdentica) {
			System.out.println("Password esatta procedi al carico\n");
			System.out.println("--[Inserisci nome bibita da ricaricare]--");
			tipoLattina=in.next();
			System.out.println("--[Inserisci numero di lattine ricaricate]--");
			numLat=in.nextInt();
			caricaMacchinetta(tipoLattina, numLat);
		}
	}
	private void stampaLattine() {
		
		for (int i = 0; i < nomeBibite.length; i++) {
			System.out.println(nomeBibite[i] +" "+ numLattine[i]);
			
		}
	}
	
	private int trovaIndice(String nomeB) {
		int ind=-1;
		for (int i = 0; i < nomeBibite.length; i++) {
			if(nomeBibite[i].equalsIgnoreCase(nomeB)) {
				ind = i;
			}
		}
		return ind;
	}

}
