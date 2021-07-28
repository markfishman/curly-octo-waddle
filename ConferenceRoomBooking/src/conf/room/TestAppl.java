package conf.room;

import java.time.LocalDateTime;

public class TestAppl {

	public static void main(String[] args) {
		LocalDateTime from = LocalDateTime.parse("2021-01-01T14:10:10");
		LocalDateTime to = LocalDateTime.parse("2021-01-01T14:20:11");
		System.out.println(BookingService.booking(from, to));
		
		from = LocalDateTime.parse("2021-01-01T14:30:10");
		to = LocalDateTime.parse("2021-01-01T14:38:11");
		System.out.println(BookingService.booking(from, to));
		
		from = LocalDateTime.parse("2021-01-01T14:09:10");
		to = LocalDateTime.parse("2021-01-01T14:09:11");
		System.out.println(BookingService.booking(from, to));
		
		from = LocalDateTime.parse("2021-01-01T14:30:09");
		to = LocalDateTime.parse("2021-01-02T14:38:11");
		System.out.println(BookingService.booking(from, to));
		
		from = LocalDateTime.parse("2021-01-02T14:29:10");
		to = LocalDateTime.parse("2021-01-02T14:30:00");
		System.out.println(BookingService.booking(from, to));
	}

}
