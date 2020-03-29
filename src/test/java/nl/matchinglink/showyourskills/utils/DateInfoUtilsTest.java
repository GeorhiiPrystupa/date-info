package nl.matchinglink.showyourskills.utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.time.LocalDate;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import nl.matchinglink.showyourskills.domain.DateInfoProviderResponse;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DateInfoUtilsTest {

	@Test
	public void getDateInfoTest() {
		DateInfoProviderResponse response = DateInfoUtils.getDateInfo(LocalDate.of(1995, 4, 29));
		LocalDate date = LocalDate.of(1995, 4, 29);
		
		assertEquals(DateInfoUtils.getConstellation(date), "Aries");
		assertEquals(DateInfoUtils.getDayNumber(date), 119);
		assertEquals(DateInfoUtils.getWeekNumber(date), 17);
		assertEquals(DateInfoUtils.getDaysUntilCatholicXmas(date), 240);
		assertEquals(DateInfoUtils.getDaysUntilOrthodoxXmas(date), 253);
		
		assertFalse(DateInfoUtils.isLeapYear(date));
		
		assertNotNull(response);
	}
}
