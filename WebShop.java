package ss2014a01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Veranstaltung:		Praktikum Programmieren 2
 * Studiengang:			Wirtschaftsinformatik
 * Semester:				SS2014	(B-WI2)
 * Praktikumsgrupe:	Gruppe 2
 * Gruppe: 					Florian Arfert (florian.arfert@haw-hamburg.de)
 * 								Mats Beeth (mats.beeth@haw-hamburg.de)
 * Aufgabenblatt:		Aufgabenblatt 1 - Benutzerverwaltung
 */

/**
 * Diese Klasse repräsentiert die Kunden des Webshops. Jeder Kunde hat einen 
 * Vornamen, einen Nachnamen und eine eindeutige ID.
 */
public class WebShop {
	/**
	 * Die Liste, die die Kunden des Webshops enthält.
	 */
	private List<Customer> kundenListe;	

	/**
	 * Enum für die verschiedenen Sortierungen.
	 */
	public enum Sortierung {
		NACHNAME_VORNAME, ID
	}

	/**
	 * Standardkonstruktor.
	 */
	public WebShop() {
		this.kundenListe = new ArrayList<>();
	}

	/**
	 * Fügt einen Kunden der Kundenliste des Webshops hinzu.
	 * @param vorname Vorname des Kunden
	 * @param nachname Nachname des Kunden
	 */
	public void addCustomer(String vorname, String nachname) {
		this.kundenListe.add(new Customer(vorname, nachname));
	}

	/**
	 * Entfernt einen Kunden aus der Kundenliste des Webshops.
	 * @param vorname Vorname des Kunden
	 * @param nachname Nachname des Kunden
	 */
	public void removeCustomer(String vorname, String nachname) {
		for (int i = this.kundenListe.size() - 1; i >= 0; i--) {
			if (this.kundenListe.get(i).getVorname().equals(vorname)
					&& this.kundenListe.get(i).getNachname().equals(nachname)) {
				this.kundenListe.remove(i);
			}
		}
	}

	/**
	 * Ausgabe der Kundenliste in Textform auf der Konsole.
	 * @param sort Art der Sortiermethode, Angabe über Enum.
	 */
	public void printListOfCustomers(Sortierung sort) {
		if (sort.equals(Sortierung.NACHNAME_VORNAME)) {
			sortiereNachNachnameVorname();
		} else {
			sortiereNachID();
		}
		for (Customer c : this.kundenListe) {
			System.out.println(c.toString());
		}
	}

	/**
	 * Sortiert die Kundenliste aufsteigend in 
	 * der Reihenfolge Nachname, Vorname.
	 */
	public void sortiereNachNachnameVorname() {
		/**
		 * Der Comparator, der für die Sortierung verwendet wird.
		 */
		Comparator<Customer> cmp = new Comparator<Customer>() {
			
			/**
			 * Zwei Kunden werden zuerst per Nachname verglichen und bei
			 * Gleichheit des Nachnamens wird mittels der Vornamen
			 * ein Vergleich durchgeführt.
			 * @param kunde1	Der erste Kunde für den Vergleich.
			 * @param kunde2	Der zweite Kunde für den Vergleich.
			 * @return 1, wenn der erste Kunde alphabetisch nach dem
			 * zweiten Kunden im Alphabet steht.
			 * 0, wenn exakte Namensgleichheit herrscht und -1 wenn der erste 
			 * Kunde alphabetisch vor dem zweiten Kunden steht.
			 */
			@Override
			public int compare(Customer kunde1, Customer kunde2) {
				int ergebnis = kunde1.getNachname().compareTo(kunde2.getNachname());
				if (ergebnis == 0) {
					return kunde1.getVorname().compareTo(kunde2.getVorname());
				}
				return ergebnis;
			}
		};
		Collections.sort(this.kundenListe, cmp);
	}

	/**
	 * Sortiert die Kundenliste aufsteigend nach der ID.
	 */
	public void sortiereNachID() {
		/**
		 * Der Comparator, der für die Sortierung verwendet wird.
		 */
		Comparator<Customer> cmp = new Comparator<Customer>() {

			/**
			 * Vergleicht zwei Kunden mittels ihrer ID.
			 * @param kunde1	Der erste Kunde für den Vergleich.
			 * @param kunde2	Der zweite Kunde für den Vergleich.
			 * @return Wert größer 0, falls die ID des ersten Kunden
			 * größer ist als die vom zweiten Kunden. 
			 * 0, wenn beide Kunden die gleiche ID haben.
			 * Wert kleiner 0, falls die ID vom ersten Kunden kleiner ist
			 * als die vom zweiten Kunden.
			 */
			@Override
			public int compare(Customer kunde1, Customer kunde2) {
				return kunde1.getID() - kunde2.getID();
			}
		};

		Collections.sort(this.kundenListe, cmp);
	}
	
	/**
	 * Getter - Liefert die Kundenliste des Webshops.
	 * @return Die Kundenliste des Webshops.
	 */
	public List<Customer> getKundenListe(){
		return this.kundenListe;
	}
	
}
