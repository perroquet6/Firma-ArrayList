public class Robotnik extends Pracownik {
	double wyplata;
	int liczbaGodz;
	double stawkaGodz;
	int LIMIT = 150;

	public double wyplata() {
		wyplata = LIMIT*stawkaGodz + (liczbaGodz-LIMIT) * stawkaGodz * 1.5;
		return wyplata;
	}

	public Robotnik(String nazwisko, double etat, int liczbaGodz, double stawkaGodz) {
		super(nazwisko, etat);
		this.liczbaGodz = liczbaGodz;
		this.stawkaGodz = stawkaGodz;
	}
}

