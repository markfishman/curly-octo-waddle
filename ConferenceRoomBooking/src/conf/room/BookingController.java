package conf.room;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins="*")
public class BookingController {
	
	@Autowired
	BookingService bookingService;
	
	@PostMapping(path="/booking")
	  public boolean bookingRoom(@RequestBody Timeframe timeframe) {
		  return bookingService.booking(timeframe.from,timeframe.to);
	 }

}
