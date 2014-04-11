package ss2014a01;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
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
 *	Testklasse f�r die Klasse WebShop aus dem Aufgabenblatt 1.
 *	Die Sortiermethoden werden in der Klasse JUnit_Comparators
 *	getestet und die Methode "printListOfCustomers" wird nicht getestet,
 *	da diese nur eine in der Schleife ausgef�hrte toString-Methode
 * 	der Customer-Klasse ist. Die toString-Methode der Customer-Klasse
 * 	wird in der zu der Customer-Klasse geh�rigen JUnit-Testklasse
 * �berpr�ft.
 */
public class JUnit_WebShop {
	
	/**
	 * Testshop f�r die Testf�lle bzgl. der Klasse WebShop.
	 */
	private WebShop testShop;
	
	/**
	 * Initialisierung des Testshops mit 2 Kunden.
	 * @throws Exception 
	 */
	@Before
	public void setUp() throws Exception {
		testShop = new WebShop();
		testShop.addCustomer("Arno", "Bana");
		testShop.addCustomer("Baldi", "Gato");
	}

	/**
	 * �berpr�ft, ob der Webshop initialisiert wurde.
	 */
	@Test
	public void testWebShop() {
		assertNotNull(testShop);
		assertEquals("WebShop", testShop.getClass().getSimpleName());
		assertTrue(testShop instanceof WebShop);
	}

	/**
	 * Pr�ft, ob ein Kunde der Kundenliste des Webshops 
	 * hinzugef�gt wurde.
	 */
	@Test
	public void testAddCustomer() {
		testShop.addCustomer("Hugo", "Gastro");
		assertEquals(3, testShop.getKundenListe().size());
		assertEquals("Hugo", testShop.getKundenListe().get(2).getVorname());
		assertEquals("Gastro", testShop.getKundenListe().get(2).getNachname());
	}

	/**
	 * Pr�ft, ob ein Kunde aus der Kundenliste des
	 * Webshops entfernt wurde.
	 */
	@Test
	public void testRemoveCustomer() {
		testShop.removeCustomer("Arno", "Bana");
		assertEquals(1, testShop.getKundenListe().size());
	}

	/**
	 * Testet, ob die Methode die Kundenliste des Webshops liefert.
	 */
	@Test
	public void testGetKundenListe() {
		assertNotNull(testShop.getKundenListe());
		assertTrue(testShop.getKundenListe() instanceof ArrayList<?>);
	}

}
