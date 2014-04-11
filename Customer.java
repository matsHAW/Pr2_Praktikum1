package ss2014a01;
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
public class Customer {
	
	/**
	 * Der statische Zähler für die Vergabe der eindeutigen ID des Kunden.
	 */
	private static int kundenID = 0;
	
	/**
	 * Der Vorname des Kunden.
	 */
	private String vorname;
	
	/**
	 * Der Nachname des Kunden.
	 */
	private String nachname;	
	
	/**
	 * ID des Kunden. Diese wird fortlaufend vergeben mittels 
	 * der statischen Variable customerID;
	 */
	private int id;
	
	/**
	 * Custom-Konstruktor.
	 * @param vorname		Vorname des Kunden
	 * @param nachname	Nachname des Kunden
	 */
	public Customer(String vorname, String nachname){
		this.vorname = vorname;
		this.nachname = nachname;
		this.id = kundenID++;
	}
	
	/**
	 * Getter - Liefert den Vornamen des Kunden.
	 * @return Der Vorname des Kunden.
	 */
	public String getVorname(){
		return this.vorname;
	}
	
	/**
	 * Setter - Setzt den Vornamen des Kunden.
	 * @param vorname Der neue Vorname des Kunden.
	 */
	public void setVorname(String vorname){
		this.vorname = vorname;
	}
	
	/**
	 * Getter - Liefert den Nachnamen des Kunden.
	 * @return Der Nachname des Kunden.
	 */
	public String getNachname(){
		return this.nachname;
	}
	
	/**
	 * Setter - Setzt den Nachnamen des Kunden.
	 * @param nachname Der neue Nachname des Kunden.
	 */
	public void setNachname(String nachname){
		this.nachname = nachname;
	}
	
	/**
	 * Getter - Liefert die ID des Kunden.
	 * @return Die ID des Kunden.
	 */
	public int getID(){
		return this.id;
	}

	/**
	 * Angepasste toString()-Methode für übersichtliche textuelle 
	 * Darstellung des Kunden.
	 * <p>
	 * Aufbau des Strings: Nachname, Vorname (ID)
	 * @return String bestehend aus Nachname, Vorname und ID.
	 */
	@Override
	public String toString() {
		return this.nachname + ", " + this.vorname + " (id: " + this.id + ")";
	}
	
}
