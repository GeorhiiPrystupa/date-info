package nl.matchinglink.showyourskills.domain;


public class DateInfoProviderResponse {
	
	private String dateInfo;
	
	private String leapYearInfo;
	
	private String dayNumberInfo;
	
	private String weekNumberInfo;
	
	private String daysUntilCatholicXmasInfo;
	
	private String daysUntilOrthodoxXmasInfo;
	
	private String daysUntilNowInfo;
	
	private String constellationInfo;
	
	public String getDateInfo() {
		return dateInfo;
	}

	public void setDateInfo(String dateInfo) {
		this.dateInfo = dateInfo;
	}

	public String getLeapYearInfo() {
		return leapYearInfo;
	}

	public void setLeapYearInfo(String leapYearInfo) {
		this.leapYearInfo = leapYearInfo;
	}

	public String getDayNumberInfo() {
		return dayNumberInfo;
	}

	public void setDayNumberInfo(String dayNumberInfo) {
		this.dayNumberInfo = dayNumberInfo;
	}

	public String getWeekNumberInfo() {
		return weekNumberInfo;
	}

	public void setWeekNumberInfo(String weekNumberInfo) {
		this.weekNumberInfo = weekNumberInfo;
	}

	public String getDaysUntilCatholicXmasInfo() {
		return daysUntilCatholicXmasInfo;
	}

	public void setDaysUntilCatholicXmasInfo(String daysUntilCatholicXmasInfo) {
		this.daysUntilCatholicXmasInfo = daysUntilCatholicXmasInfo;
	}

	public String getDaysUntilOrthodoxXmasInfo() {
		return daysUntilOrthodoxXmasInfo;
	}

	public void setDaysUntilOrthodoxXmasInfo(String daysUntilOrthodoxXmasInfo) {
		this.daysUntilOrthodoxXmasInfo = daysUntilOrthodoxXmasInfo;
	}

	public String getDaysUntilNowInfo() {
		return daysUntilNowInfo;
	}

	public void setDaysUntilNowInfo(String daysUntilNowInfo) {
		this.daysUntilNowInfo = daysUntilNowInfo;
	}

	public String getConstellationInfo() {
		return constellationInfo;
	}

	public void setConstellationInfo(String constellationInfo) {
		this.constellationInfo = constellationInfo;
	}
	
	private DateInfoProviderResponse() {
		
	}
	
	public static class Builder {
		DateInfoProviderResponse response;
		
		public Builder() {
			response = new DateInfoProviderResponse();
		}
		
		public Builder withDate(String date) {
			response.dateInfo = "Your date is " + date;
			return this;
		}
		
		public Builder withLeapYear(boolean val) {
			response.leapYearInfo = "Your date is " + (val ? "" : "not ") + "in leap year";
			return this;
		}
		
		public Builder withDayNumber(int number) {
			response.dayNumberInfo = "Your date is " + number + " day of the year";
			return this;
		}
		
		public Builder withWeekNumber(int number) {
			response.weekNumberInfo = "Your date is in " + number + " week of the year";
			return this;
		}
		
		public Builder withDaysUntilCatholicXmas(long number) {
			response.daysUntilCatholicXmasInfo = "There are " + number + " days from your date until catholic christmas";
			return this;
		}
		
		public Builder withDaysUntilOrthodoxXmas(long number) {
			response.daysUntilOrthodoxXmasInfo = "There are " + number + " days from your date until orthodox christmas";
			return this;
		}
		
		public Builder withDaysUntilNow(long number) {
			response.daysUntilNowInfo = "There are " + number + " days from your date until now";
			return this;
		}
		
		public Builder withConstellation(String constellation) {
			response.constellationInfo = "Your date's constellation is " + constellation;
			return this;
		}
		
		public DateInfoProviderResponse build() {
			return response;
		}
	}
	
	
	
	
	
}
