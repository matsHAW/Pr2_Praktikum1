package ss2014a01;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

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
 * Testklasse f�r Sortierung mitels der beiden Comparatoren.
 */
public class JUnit_Comparators {
	
	/**
	 * Testshop f�r die Sortierungen.
	 */
	private WebShop testShop;
	
	/**
	 * Vergleichsliste f�r die korrekte Sortierung im Webshop
	 * nach Nachname und Vorname in aufsteigender Reihenfolge.
	 */
	private List<Customer> listeSortiertNachnameVorname;
	
	/**
	 * Vergleichsliste f�r die korrekte Sortierung im Webshop
	 * nach der ID in aufsteigender Reihenfolge.
	 */
	private List<Customer> listeSortiertID;
	
	/**
	 * Initialisierung f�r den Testshop mit 5 Eintr�gen sowie
	 * der beiden Vergleichslisten f�r die Sortierungen mittels
	 * der Comparatoren.
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		/**
		 * Initialisierung des Webshops sowie
		 * Einf�gen von 5 Eintr�gen in den Webshop. Als Zeilenkommentar
		 * stehen jeweils die ID sowie Sortierung (nachfolgend "Sort.")
		 * nach Nachname und Vorname dahinter. 
		 */
		testShop = new WebShop();
		testShop.addCustomer("Andre", "Anders");	// ID = 0	 Sort. = 0
		testShop.addCustomer("David", "Drau");		// ID = 1	 Sort. = 3
		testShop.addCustomer("Egon", "Emilsen");	// ID = 2	 Sort. = 4
		testShop.addCustomer("Bruno", "Band");		// ID = 3	 Sort. = 1
		testShop.addCustomer("Carlo", "Cramer");	// ID = 4	 Sort. = 2
		
		/**
		 * Initialisierung der Vergleichsliste sowie
		 * Einf�gen der Kunden in die Vergleichsliste f�r die Sortierung
		 * nach der ID.
		 */
		listeSortiertID = new ArrayList<>();
		listeSortiertID.add(testShop.getKundenListe().get(0));
		listeSortiertID.add(testShop.getKundenListe().get(1));
		listeSortiertID.add(testShop.getKundenListe().get(2));
		listeSortiertID.add(testShop.getKundenListe().get(3));
		listeSortiertID.add(testShop.getKundenListe().get(4));
		
		/**
		 * Initialisierung der Vergleichsliste sowie
		 * Einf�gen der Kunden in die Vergleichsliste f�r die Sortierung
		 * nach Nachnamen und Vornamen.
		 */
		listeSortiertNachnameVorname = new ArrayList<>();
		listeSortiertNachnameVorname.add(testShop.getKundenListe().get(0));
		listeSortiertNachnameVorname.add(testShop.getKundenListe().get(3));
		listeSortiertNachnameVorname.add(testShop.getKundenListe().get(4));
		listeSortiertNachnameVorname.add(testShop.getKundenListe().get(1));
		listeSortiertNachnameVorname.add(testShop.getKundenListe().get(2));
	}

	/**
	 * �berpr�ft, ob die ausgef�hrte Sortiermethode die Kundenliste
	 * des Webshops korrekt sortiert hat nach Nachnamen und
	 * Vornamen.
	 */
	@Test
	public void testSortiereNachNachnameVorname() {
		testShop.sortiereNachNachnameVorname();
		assertEquals(listeSortiertNachnameVorname, testShop.getKundenListe());
	}

	/**
	 * Testet, ob die Sortiermethode die Kunden des Webshops korrekt
	 * nach ID sortiert hat.
	 */
	@Test
	public void testSortiereNachID() {
		testShop.sortiereNachID();
		assertEquals(listeSortiertID, testShop.getKundenListe());
	}

}
