package conf.room;

import java.time.LocalDateTime;

public interface BookingService {
	public boolean booking(LocalDateTime from, LocalDateTime to);
	public void readState();

}
