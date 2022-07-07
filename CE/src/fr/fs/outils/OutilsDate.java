package fr.fs.outils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class OutilsDate {
	private OutilsDate() {

	}
	private static DateTimeFormatter formatNumerique = DateTimeFormatter
			.ofPattern("dd/MM/yyyy");
	private static DateTimeFormatter formatChaine = DateTimeFormatter
			.ofPattern("d MMMM yyyy");

	public static LocalDate stringToDate(String date) {
		return LocalDate.parse(date, formatNumerique);
	}
	public static String dateToString(LocalDate date) {
		return formatNumerique.format(date);
	}
	public static String dateToLitteral(LocalDate date) {
		return formatChaine.format(date);
	}

	public static int ageFinAnnee(LocalDate date) {
		return LocalDate.now().getYear() - date.getYear();
	}
	public static int moisEntre(LocalDate date, LocalDate otherDate) {
		
		if (date.isBefore(otherDate)) {
			LocalDate temp = date;
			date = otherDate;
			otherDate=temp;
		}
	
		int mois = (date.getYear() - otherDate.getYear()) * 12;
		mois += date.getMonthValue() - otherDate.getMonthValue();
		if (date.getDayOfMonth() < otherDate.getDayOfMonth())
			mois--;
		return Math.abs(mois);
	}
	
	
}
