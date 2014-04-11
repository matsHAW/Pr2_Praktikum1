package ss2014a01;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
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
 * Testklasse für die Klasse Customer aus dem Aufgabenblatt 1.
 */
public class JUnit_Customer {

	/**
	 * Testkunde für die Methoden aus der Klasse Customer.
	 */
	private static Customer testKunde;
	
	/**
	 * Initialisierung des Kunden für die Testfälle.
	 * Statische Initialisierung, da sonst vor jedem Test der 
	 * Kunde neuangelegt würde und somit jedes Mal
	 * eine andere ID hätte.
	 * @throws Exception
	 */
	@BeforeClass
	public static void StaticSetUp() throws Exception {
		testKunde = new Customer("Arno", "Bana");
	}
	
	/**
	 * Re-Initialisierung des Vor- und Nachnamens.
	 * @throws Exception
	 */
	@Before
	public void SetUp() throws Exception {
		testKunde.setVorname("Arno");
		testKunde.setNachname("Bana");
	}

	/**
	 * Überprüft, ob der Kunde initialisiert wurde.
	 */
	@Test
	public void testCustomer() {
		assertNotNull(testKunde);
		assertEquals("Customer", testKunde.getClass().getSimpleName());
		assertTrue(testKunde instanceof Customer);
	}

	/**
	 * Überprüft, ob der Vorname des Kundens der ist,
	 * mit dem er initialisiert wurde.
	 */
	@Test
	public void testGetVorname() {
		assertEquals("Arno", testKunde.getVorname());
	}

	/**
	 * Überprüft, ob der Setter den neuen Vornamen
	 * richtig setzt.
	 */
	@Test
	public void testSetVorname() {
		testKunde.setVorname("Carlo");
		assertEquals("Carlo", testKunde.getVorname());
	}

	/**
	 * Überprüft, ob der Nachname der ist, mit
	 * dem der Kunde initialisiert wurde.
	 */
	@Test
	public void testGetNachname() {
		assertEquals("Bana", testKunde.getNachname());
	}

	/**
	 * Überprüft, ob der neue Nachname richtig 
	 * gesetzt wurde.
	 */
	@Test
	public void testSetNachname() {
		testKunde.setNachname("Carlito");
		assertEquals("Carlito", testKunde.getNachname());
	}

	/**
	 * Überprüft, ob die zugewiesene ID bei der Initialisierung
	 * korrekt ist.
	 */
	@Test
	public void testGetID() {
		assertEquals(0, testKunde.getID());
	}

	/**
	 * Überprüft, ob die textuelle Ausgabe korrekt ist.
	 */
	@Test
	public void testToString() {
		String testString = "Bana, Arno (id: 0)";
		assertEquals(testString, testKunde.toString());
	}

}
