package conf.room;

import java.time.LocalDateTime;

import conf.room.services.BookingService;
import conf.room.services.BookingServiceBinaryArray;
import conf.room.services.BookingServiceHashMap;
import conf.room.services.BookingServiceTreeMap;
import conf.room.services.Convertator;

public class TestAppl {

	public static void main(String[] args) {
		BookingService bookingService = new BookingServiceHashMap();
		//BookingService bookingService = new BookingServiceTreeMap();
		//BookingService bookingService = new BookingServiceBinaryArray();
		LocalDateTime from = LocalDateTime.parse("2021-01-01T14:10:10");
		LocalDateTime to = LocalDateTime.parse("2021-01-01T14:20:11");
		int[] timeframeInt = Convertator.convertToInt(new Timeframe(from, to));
		System.out.println(bookingService.booking(timeframeInt[0],timeframeInt[1]));
		
		from = LocalDateTime.parse("2021-01-01T14:30:10");
		to = LocalDateTime.parse("2021-01-01T14:38:11");
		timeframeInt = Convertator.convertToInt(new Timeframe(from, to));
		System.out.println(bookingService.booking(timeframeInt[0],timeframeInt[1]));
		
		from = LocalDateTime.parse("2021-01-01T14:09:10");
		to = LocalDateTime.parse("2021-01-01T14:09:11");
		timeframeInt = Convertator.convertToInt(new Timeframe(from, to));
		System.out.println(bookingService.booking(timeframeInt[0],timeframeInt[1]));
		
		from = LocalDateTime.parse("2021-01-01T14:30:09");
		to = LocalDateTime.parse("2021-01-02T14:38:11");
		timeframeInt = Convertator.convertToInt(new Timeframe(from, to));
		System.out.println(bookingService.booking(timeframeInt[0],timeframeInt[1]));
		
		from = LocalDateTime.parse("2021-01-02T14:29:10");
		to = LocalDateTime.parse("2021-01-02T14:30:00");
		timeframeInt = Convertator.convertToInt(new Timeframe(from, to));
		System.out.println(bookingService.booking(timeframeInt[0],timeframeInt[1]));
		
		from = LocalDateTime.parse("2020-01-01T00:00:00");
		to = LocalDateTime.parse("2030-01-01T00:00:00");
		timeframeInt = Convertator.convertToInt(new Timeframe(from, to));
		System.out.println(bookingService.booking(timeframeInt[0],timeframeInt[1]));
	}

}
