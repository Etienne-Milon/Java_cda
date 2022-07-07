package fr.em.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import fr.em.bases.Cheques;

class ChequesTest extends Cheques {

    @Test
    void testPowTen() {
	assertEquals(1, powTen(0));
	assertEquals(10, powTen(1));
	assertEquals(1000, powTen(3));
	assertEquals(1000000, powTen(6));
    }

    @Test
    void testLongToLitteralNorme90() {
	assertEquals("zéro", longToLitteral(0,true));
	assertEquals("cinq", longToLitteral(5,true));
	assertEquals("neuf", longToLitteral(9,true));
	assertEquals("dix", longToLitteral(10,true));
	assertEquals("onze", longToLitteral(11,true));
	assertEquals("seize", longToLitteral(16,true));
	assertEquals("dix-sept", longToLitteral(17,true));
	assertEquals("vingt", longToLitteral(20,true));
	assertEquals("vingt-et-un", longToLitteral(21,true));
	assertEquals("vingt-deux", longToLitteral(22,true));
	assertEquals("trente-et-un", longToLitteral(31,true));
	assertEquals("quarante-et-un", longToLitteral(41,true));
	assertEquals("cinquante-et-un", longToLitteral(51,true));
	assertEquals("soixante-et-un", longToLitteral(61,true));
	assertEquals("soixante-et-onze", longToLitteral(71,true));
	assertEquals("quatre-vingts", longToLitteral(80,true));
	assertEquals("quatre-vingt-un", longToLitteral(81,true));
	assertEquals("quatre-vingt-dix", longToLitteral(90,true));
	assertEquals("quatre-vingt-onze", longToLitteral(91,true));
	assertEquals("quatre-vingt-dix-neuf", longToLitteral(99,true));
	assertEquals("cent-un", longToLitteral(101,true));
	assertEquals("cent-onze", longToLitteral(111,true));
	assertEquals("cent-vingt", longToLitteral(120,true));
	assertEquals("deux-cents", longToLitteral(200,true));
	assertEquals("deux-cent-un", longToLitteral(201,true));
	assertEquals("neuf-cent-quatre-vingt-dix-neuf", longToLitteral(999,true));
	assertEquals("mille", longToLitteral(1000,true));
	assertEquals("mille-un", longToLitteral(1001,true));
	assertEquals("deux-mille", longToLitteral(2000,true));
	assertEquals("deux-mille-un", longToLitteral(2001,true));
	assertEquals("cinq-mille-huit-cent-quatre-vingts", longToLitteral(5880,true));
	assertEquals("quatre-vingt-mille", longToLitteral(80000,true));
	assertEquals("quatre-cent-mille", longToLitteral(400000,true));
	assertEquals("neuf-cent-quatre-vingt-dix-neuf-mille-neuf-cent-quatre-vingt-dix-neuf", longToLitteral(999999,true));
	assertEquals("un-million", longToLitteral(1000000,true));
	assertEquals("un-million-dix-huit", longToLitteral(1000018,true));
	assertEquals("un-million-dix-huit-mille-trois-cent-quatre-vingts", longToLitteral(1018380,true));
	assertEquals("deux-millions-trois-cent-mille", longToLitteral(2300000,true));
	assertEquals("deux-millions-trois-cent-quatre-vingt-mille-trois-cents", longToLitteral(2380300,true));
	assertEquals("quatre-vingts-millions", longToLitteral(80000000,true));
	assertEquals("quatre-cents-millions", longToLitteral(400000000,true));	
	assertEquals(
		"neuf-cent-quatre-vingt-dix-neuf-millions-neuf-cent-quatre-vingt-dix-neuf-mille-neuf-cent-quatre-vingt-dix-neuf",
		longToLitteral(999999999,true));
	assertEquals("un-milliard-deux-cents-millions-cinq-cent-dix-huit-mille-trois-cent-soixante-six",
		longToLitteral(1200518366,true));
	assertEquals(
		"deux-milliards-cent-quarante-sept-millions-quatre-cent-quatre-vingt-trois-mille-six-cent-quarante-sept",
		longToLitteral(2147483647,true));
	assertEquals("deux-cents-milliards", longToLitteral(200000000000L,true));
	assertEquals(
		"neuf-trillions-deux-cent-vingt-trois-billiards-trois-cent-soixante-douze-billions-trente-six-milliards-huit-cent-cinquante-quatre-millions-sept-cent-soixante-quinze-mille-huit-cent-sept",
		longToLitteral(9223372036854775807L,true));
    }

    @Test
    void testLongToLitteralEuro() {
	assertEquals("zéro", longToLitteral(0,false));
	assertEquals("cinq", longToLitteral(5,false));
	assertEquals("neuf", longToLitteral(9,false));
	assertEquals("dix", longToLitteral(10,false));
	assertEquals("onze", longToLitteral(11,false));
	assertEquals("seize", longToLitteral(16,false));
	assertEquals("dix-sept", longToLitteral(17,false));
	assertEquals("vingt", longToLitteral(20,false));
	assertEquals("vingt-et-un", longToLitteral(21,false));
	assertEquals("vingt-deux", longToLitteral(22,false));
	assertEquals("trente-et-un", longToLitteral(31,false));
	assertEquals("quarante-et-un", longToLitteral(41,false));
	assertEquals("cinquante-et-un", longToLitteral(51,false));
	assertEquals("soixante-et-un", longToLitteral(61,false));
	assertEquals("soixante-et-onze", longToLitteral(71,false));
	assertEquals("quatre-vingts", longToLitteral(80,false));
	assertEquals("quatre-vingt-un", longToLitteral(81,false));
	assertEquals("quatre-vingt-dix", longToLitteral(90,false));
	assertEquals("quatre-vingt-onze", longToLitteral(91,false));
	assertEquals("quatre-vingt-dix-neuf", longToLitteral(99,false));
	assertEquals("cent un", longToLitteral(101,false));
	assertEquals("cent onze", longToLitteral(111,false));
	assertEquals("cent vingt", longToLitteral(120,false));
	assertEquals("deux cents", longToLitteral(200,false));
	assertEquals("deux cent un", longToLitteral(201,false));
	assertEquals("neuf cent quatre-vingt-dix-neuf", longToLitteral(999,false));
	assertEquals("mille", longToLitteral(1000,false));
	assertEquals("mille un", longToLitteral(1001,false));
	assertEquals("deux mille", longToLitteral(2000,false));
	assertEquals("deux mille un", longToLitteral(2001,false));
	assertEquals("cinq mille huit cent quatre-vingts", longToLitteral(5880,false));
	assertEquals("quatre-vingt mille", longToLitteral(80000,false));
	assertEquals("quatre cent mille", longToLitteral(400000,false));
	assertEquals("neuf cent quatre-vingt-dix-neuf mille neuf cent quatre-vingt-dix-neuf", longToLitteral(999999,false));
	assertEquals("un million", longToLitteral(1000000,false));
	assertEquals("un million dix-huit", longToLitteral(1000018,false));
	assertEquals("un million dix-huit mille trois cent quatre-vingts", longToLitteral(1018380,false));
	assertEquals("deux millions trois cent mille", longToLitteral(2300000,false));
	assertEquals("deux millions trois cent quatre-vingt mille trois cents", longToLitteral(2380300,false));
	assertEquals("quatre-vingts millions", longToLitteral(80000000,false));
	assertEquals("quatre cents millions", longToLitteral(400000000,false));	
	assertEquals(
		"neuf cent quatre-vingt-dix-neuf millions neuf cent quatre-vingt-dix-neuf mille neuf cent quatre-vingt-dix-neuf",
		longToLitteral(999999999,false));
	assertEquals("un milliard deux cents millions cinq cent dix-huit mille trois cent soixante-six",
		longToLitteral(1200518366,false));
	assertEquals(
		"deux milliards cent quarante-sept millions quatre cent quatre-vingt-trois mille six cent quarante-sept",
		longToLitteral(2147483647,false));
	assertEquals("deux cents milliards", longToLitteral(200000000000L,false));
	assertEquals(
		"neuf trillions deux cent vingt-trois billiards trois cent soixante-douze billions trente-six milliards huit cent cinquante-quatre millions sept cent soixante-quinze mille huit cent sept",
		longToLitteral(9223372036854775807L,false));
    }

    @Test
    void testLibellerCheque() {
	assertEquals("***zéro euro et zéro centime***", libellerCheque("0"));
	assertEquals("***zéro euro et un centime***", libellerCheque("0.01"));
	assertEquals("***zéro euro et dix centimes***", libellerCheque("0.1"));
	assertEquals("***un euro et quatre-vingts centimes***", libellerCheque("1.8"));
	assertEquals("***cinq euros et quatre-vingts centimes***", libellerCheque("5.8"));
	assertEquals("***neuf cent quatre-vingt-dix-neuf euros et quatre-vingt-dix-neuf centimes***", libellerCheque("999.99"));
    }
}