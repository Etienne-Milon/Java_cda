package outils;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import org.junit.jupiter.api.Test;

import fr.fs.outils.OutilsDate;

@SuppressWarnings("java:S5960")
class OutilsDateTest {

	
	@Test
	void testAgeFinAnnee() {
		assertEquals(0, OutilsDate.ageFinAnnee( LocalDate.now()));
		assertEquals(0, OutilsDate.ageFinAnnee(LocalDate.of(LocalDate.now().getYear(),1,1)));
		assertEquals(1, OutilsDate.ageFinAnnee(LocalDate.of(LocalDate.now().getYear(),1,1).minusDays(1)));
		assertEquals(5, OutilsDate.ageFinAnnee( LocalDate.now().minusYears(5)));
		assertEquals(5, OutilsDate.ageFinAnnee( LocalDate.now().minusMonths(60)));	
	}

	@Test
	void testAncienneteMois() {
		LocalDate ref = OutilsDate.stringToDate( "01/07/2022");
		assertEquals(0, OutilsDate.moisEntre(ref, OutilsDate.stringToDate("02/06/2022")));
		assertEquals(1, OutilsDate.moisEntre(ref, OutilsDate.stringToDate("01/06/2022")));
		assertEquals(1, OutilsDate.moisEntre(ref, OutilsDate.stringToDate("30/05/2022")));
		assertEquals(6, OutilsDate.moisEntre(ref, OutilsDate.stringToDate("01/01/2022")));
		assertEquals(7, OutilsDate.moisEntre(ref, OutilsDate.stringToDate("01/12/2021")));
		assertEquals(9, OutilsDate.moisEntre(ref, OutilsDate.stringToDate("01/10/2021")));
		assertEquals(8, OutilsDate.moisEntre(ref, OutilsDate.stringToDate("02/10/2021")));
		
		assertEquals(0, OutilsDate.moisEntre(OutilsDate.stringToDate( "02/06/2022"),ref));
		assertEquals(1, OutilsDate.moisEntre(OutilsDate.stringToDate( "01/06/2022"),ref));
		assertEquals(1, OutilsDate.moisEntre(OutilsDate.stringToDate("30/05/2022"),ref));
		assertEquals(6, OutilsDate.moisEntre(OutilsDate.stringToDate( "01/01/2022"),ref));
		assertEquals(7, OutilsDate.moisEntre(OutilsDate.stringToDate("01/12/2021"),ref));
		assertEquals(9, OutilsDate.moisEntre(OutilsDate.stringToDate("01/10/2021"),ref));
		assertEquals(8, OutilsDate.moisEntre(OutilsDate.stringToDate("02/10/2021"),ref));
	}
	
	@Test
	void testDateToString()
	{
		LocalDate date = LocalDate.of(1962, 6,27);
		assertEquals("27/06/1962", OutilsDate.dateToString(date));
	}
	
	@Test
	void testDateToLitteral()
	{
		LocalDate date = LocalDate.of(1962, 6,27);
		assertEquals("27 juin 1962", OutilsDate.dateToLitteral(date));
	}
}
