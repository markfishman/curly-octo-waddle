package conf.room;

import java.time.LocalDateTime;

public class TestAppl {

	public static void main(String[] args) {
		//BookingService bookingService = new BookingServiceTreeMap();
		BookingService bookingService = new BookingServiceBinaryArray();
		LocalDateTime from = LocalDateTime.parse("2021-01-01T14:10:10");
		LocalDateTime to = LocalDateTime.parse("2021-01-01T14:20:11");
		System.out.println(bookingService.booking(from, to));
		
		from = LocalDateTime.parse("2021-01-01T14:30:10");
		to = LocalDateTime.parse("2021-01-01T14:38:11");
		System.out.println(bookingService.booking(from, to));
		
		from = LocalDateTime.parse("2021-01-01T14:09:10");
		to = LocalDateTime.parse("2021-01-01T14:09:11");
		System.out.println(bookingService.booking(from, to));
		
		from = LocalDateTime.parse("2021-01-01T14:30:09");
		to = LocalDateTime.parse("2021-01-02T14:38:11");
		System.out.println(bookingService.booking(from, to));
		
		from = LocalDateTime.parse("2021-01-02T14:29:10");
		to = LocalDateTime.parse("2021-01-02T14:30:00");
		System.out.println(bookingService.booking(from, to));
		
		from = LocalDateTime.parse("2020-01-01T00:00:00");
		to = LocalDateTime.parse("2030-01-01T00:00:00");
		System.out.println(bookingService.booking(from, to));
	}

}
