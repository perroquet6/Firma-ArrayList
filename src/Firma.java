import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.math.*;
import java.math.*;

public class Firma {

	List<Pracownik> lista;

	public Firma() {
		lista = new ArrayList<Pracownik>();
		lista.add(new Urzednik("Kowalski", 0.5, 2200, 5));
		lista.add(new Urzednik("Nowak", 1.0, 2500, 10));
		lista.add(new Robotnik("Kwiatkowski", 1.0, 160, 10));
		lista.add(new Robotnik("Borowski", 1.5, 250, 8));
	}

	public double wyplata(String nazwisko) {
		return znajdzPrac(nazwisko).wyplata();
	}

	public Pracownik znajdzPrac(String nazwisko) {
		Iterator<Pracownik> iterator = lista.iterator();
		while (iterator.hasNext()) {
			Pracownik prac = iterator.next();
			if (prac.nazwisko.equals(nazwisko)) {
				return prac;
			}
		}
		return null;
	}

	public boolean czyUrzednik(String nazwisko) {
		Iterator<Pracownik> iterator = lista.iterator();
		while (iterator.hasNext()) {
			Pracownik prac = iterator.next();
			if (prac.nazwisko.equals(nazwisko)) {
				return prac instanceof Urzednik;
			}

		}
		return false;
	}

	public void dodajPrac(boolean czyJestUrzednikiem) {
		if (czyJestUrzednikiem) {
			lista.add(new Urzednik("Malinowski", 1.0, 2500, 10));
		} else {
			lista.add(new Robotnik("Jab³ecki", 1.5, 150, 10));
		}
	}

	public void usunPrac(String nazwisko) {
		lista.remove(znajdzPrac(nazwisko));
	}

	public int[] iluUrziRob() {
		int iloscU = 0;
		Iterator<Pracownik> iterator = lista.iterator();
		while (iterator.hasNext()) {
			if (czyUrzednik(iterator.next().nazwisko)) {
				iloscU++;
			}
		}
		int[] tab = { iloscU, lista.size() - iloscU };
		return tab;
	}

	public double[] sumaWyplat() {
		double sumaWyplatU = 0;
		double sumaWyplatR = 0;
		Iterator<Pracownik> iterator = lista.iterator();
		while (iterator.hasNext()) {
			Pracownik prac = iterator.next();
			if (czyUrzednik(iterator.next().nazwisko)) {
				sumaWyplatU = sumaWyplatU + prac.wyplata();
			} else {
				sumaWyplatR = sumaWyplatR + prac.wyplata();
			}
		}
		double[] tab = { sumaWyplatU, sumaWyplatR };
		return tab;
	}

	// tyle na korkach
	public String wydrukListyPrac() {
		String s1;
		String s2;
		String s3 = "";
		s1 = String.format("%-20s%n", "Lista pracowników");
		s2 = String.format("%-3s%-30s%-10s%-5s%n", "Lp", "nazwisko", "grupa", "etat");
		Iterator<Pracownik> iterator = lista.iterator();
		int i=1;
		while (iterator.hasNext()) {
			Pracownik prac = iterator.next();
			s3 = String.format("%-3d%-30s%-10s%-5f%n",i, prac.nazwisko, prac.getClass().getName(), prac.etat);
			i++;}
		String s = s1 + s2 + s3;
		System.out.println(s);
		return s;

	}

	public String wydrukListyUrz() {
		String s1;
		String s2;
		String s3;
		s1 = String.format("%-20s%n", "Lista urzêdników");
		s2 = String.format("%-3s%-30s%-5s%n", "Lp", "nazwisko", "etat");
		return s;
	}

	public String wydrukListyR() {
		String s1;
		String s2;
		String s3;
		s1 = String.format("%-20s%n", "Lista robotników");
		s2 = String.format("%-3s%-30s%-5s%n", "Lp", "nazwisko", "etat");
		return s;
	}

	public String wydrukListyPlac() {
		String s1;
		String s2;
		String s3;
		s1 = String.format("%-20s%n", "Lista p³ac");
		s2 = String.format("%-3s%-30s%-10s%-5s%#5d%n", "Lp", "nazwisko", "grupa", "etat", "wyp³ata");
		String s = s1 + s2 + s3;
		System.out.println(s);
		return s;

	}
}
