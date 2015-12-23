abstract public class Pracownik{
	String nazwisko;
	double etat;

	public Pracownik(String nazwisko, double etat) {
		this.nazwisko=nazwisko;
		this.etat=etat;
	}

	abstract double wyplata();
}

