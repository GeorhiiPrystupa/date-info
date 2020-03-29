package nl.matchinglink.showyourskills.utils;


import java.time.LocalDate;
import java.time.temporal.WeekFields;
import java.util.HashMap;
import java.util.Map;
import java.time.temporal.ChronoUnit;

import nl.matchinglink.showyourskills.domain.DateInfoProviderResponse;

public class DateInfoUtils {

	
	
	
	public static DateInfoProviderResponse getDateInfo(LocalDate date) {
		DateInfoProviderResponse response = new DateInfoProviderResponse.Builder()
				.withDate(date.toString())
				.withDayNumber(getDayNumber(date))
				.withWeekNumber(getWeekNumber(date))
				.withLeapYear(isLeapYear(date))
				.withDaysUntilCatholicXmas(getDaysUntilCatholicXmas(date))
				.withDaysUntilOrthodoxXmas(getDaysUntilOrthodoxXmas(date))
				.withDaysUntilNow(getDaysUntilNow(date))
				.withConstellation(getConstellation(date))
				.build();
		
		return response;
	}
	
	public static boolean isLeapYear(LocalDate date) {
		
		return date.isLeapYear();
	}
	
	public static int getDayNumber(LocalDate date) {
		
		return date.getDayOfYear();
	}
	
	public static int getWeekNumber(LocalDate date) {
	
		return date.get(WeekFields.ISO.weekOfWeekBasedYear());
	}
	
	public static long getDaysUntilCatholicXmas(LocalDate date) {
			
		LocalDate xmas = LocalDate.of(date.getYear(), 12, 25);
		if(date.toEpochDay() > xmas.toEpochDay()) {
			
			xmas = xmas.plusYears(1);
		}
		return ChronoUnit.DAYS.between(date, xmas);
	}
	
	public static long getDaysUntilOrthodoxXmas(LocalDate date) {
		LocalDate xmas = LocalDate.of(date.getYear(), 1, 7);
		if(date.toEpochDay() > xmas.toEpochDay()) {
			
			xmas = xmas.plusYears(1);
		}
		return ChronoUnit.DAYS.between(date, xmas);
	}
	
	public static long getDaysUntilNow(LocalDate date) {
		LocalDate now = LocalDate.now();
		
		return ChronoUnit.DAYS.between(date, now);

	}
	
	public static String getConstellation(LocalDate date) {
		Map<String, DateRange> consellationsMap = getConstellationsMap(date.getYear());
		
		for (Map.Entry<String, DateRange> entry : consellationsMap.entrySet()) {
			
		    if(date.compareTo(entry.getValue().start) >= 0 &&
		    		date.compareTo(entry.getValue().end) <= 0) {
		    	
		    	return entry.getKey();
		    }
		    	
		}

		return null;
	}
	
	private static Map<String, DateRange> getConstellationsMap(int year){
		 Map<String, DateRange> result = new HashMap<String, DateRange>();
		
		 result.put("Aries",
				new DateRange(LocalDate.of(year, 4, 19), LocalDate.of(year, 5, 13)));
		
		 result.put("Taurus",
				new DateRange(LocalDate.of(year, 5, 14), LocalDate.of(year, 6, 19)));
		
		 result.put("Gemini",
				new DateRange(LocalDate.of(year, 6, 20), LocalDate.of(year, 7, 20)));
		
		 result.put("Cancer",
				new DateRange(LocalDate.of(year, 7, 21), LocalDate.of(year, 8, 9)));
		
		 result.put("Leo",
				new DateRange(LocalDate.of(year, 8, 10), LocalDate.of(year, 9, 15)));
		
		 result.put("Virgo",
				new DateRange(LocalDate.of(year, 9, 16), LocalDate.of(year, 10, 30)));
		
		 result.put("Libra",
				new DateRange(LocalDate.of(year, 10, 31), LocalDate.of(year, 11, 22)));
		
		 result.put("Scorpius",
				new DateRange(LocalDate.of(year, 11, 23), LocalDate.of(year, 11, 29)));
		
		 result.put("Ophiuchus",
				new DateRange(LocalDate.of(year, 11, 30), LocalDate.of(year, 12, 17)));
		
		 result.put("Sagittarius",
				new DateRange(LocalDate.of(year, 12, 18), LocalDate.of(year + 1, 1, 18)));
		
		 result.put("Capricornus",
				new DateRange(LocalDate.of(year, 1, 19), LocalDate.of(year, 2, 15)));
		
		 result.put("Aquarius",
				new DateRange(LocalDate.of(year, 2, 16), LocalDate.of(year, 3, 11)));
		
		 result.put("Pisces",
				new DateRange(LocalDate.of(year, 3, 12), LocalDate.of(year, 4, 18)));
		 
		 return result;
	}
	
	static class DateRange {
		
		public LocalDate start;
		public LocalDate end;
		
		public DateRange(LocalDate start, LocalDate end) {
			this.start = start;
			this.end = end;
		}
		
	}
}


