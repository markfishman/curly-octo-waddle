package conf.room;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import conf.room.services.BookingService;
import conf.room.services.Convertator;

@RestController
@CrossOrigin(origins="*")
public class BookingController {
	
	@Autowired
	BookingService bookingService;
	
	@PostMapping(path="/booking")
	public boolean bookingRoom(@RequestBody Timeframe timeframe) {
		int[] timeframeInt = Convertator.convertToInt(timeframe);
		return bookingService.booking(timeframeInt[0],timeframeInt[1]);
	}




}
