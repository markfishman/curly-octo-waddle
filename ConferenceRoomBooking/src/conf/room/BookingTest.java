package conf.room;

import static org.junit.Assert.*;

import java.time.LocalDateTime;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import conf.room.services.BookingService;
import conf.room.services.BookingServiceHashMap;
import conf.room.services.Convertator;

public class BookingTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		BookingService bookingService = new BookingServiceHashMap();
		LocalDateTime from = LocalDateTime.parse("2021-01-01T14:10:10");
		LocalDateTime to = LocalDateTime.parse("2021-01-01T14:20:11");
		int[] timeframeInt = Convertator.convertToInt(new Timeframe(from, to));
		assertTrue(bookingService.booking(timeframeInt[0],timeframeInt[1]));
		
		from = LocalDateTime.parse("2021-01-01T14:30:10");
		to = LocalDateTime.parse("2021-01-01T14:38:11");
		timeframeInt = Convertator.convertToInt(new Timeframe(from, to));
		assertTrue(bookingService.booking(timeframeInt[0],timeframeInt[1]));
		
		from = LocalDateTime.parse("2021-01-01T14:09:10");
		to = LocalDateTime.parse("2021-01-01T14:09:11");
		timeframeInt = Convertator.convertToInt(new Timeframe(from, to));
		assertTrue(bookingService.booking(timeframeInt[0],timeframeInt[1]));
		
		from = LocalDateTime.parse("2021-01-01T14:30:09");
		to = LocalDateTime.parse("2021-01-02T14:38:11");
		timeframeInt = Convertator.convertToInt(new Timeframe(from, to));
		assertFalse(bookingService.booking(timeframeInt[0],timeframeInt[1]));
		
		from = LocalDateTime.parse("2021-01-02T14:29:10");
		to = LocalDateTime.parse("2021-01-02T14:30:00");
		timeframeInt = Convertator.convertToInt(new Timeframe(from, to));
		assertTrue(bookingService.booking(timeframeInt[0],timeframeInt[1]));
		
		from = LocalDateTime.parse("2020-01-01T00:00:00");
		to = LocalDateTime.parse("2030-01-01T00:00:00");
		timeframeInt = Convertator.convertToInt(new Timeframe(from, to));
		assertFalse(bookingService.booking(timeframeInt[0],timeframeInt[1]));
	}

}
