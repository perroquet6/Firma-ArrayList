
public class Urzednik extends Pracownik {
	double pp; // p³aca podstawowa na 1,0 etat
	double premia;

	public double wyplata(){
		double wyplata;
		wyplata = pp * super.etat * (1 + premia * 0.01);
		return wyplata;											
	}

	public Urzednik(String nazwisko, double etat, double pp, double premia) {
		super(nazwisko, etat);
		this.pp = pp;
		this.premia = premia;
	}
	}

