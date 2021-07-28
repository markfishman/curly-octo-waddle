package conf.room;

import java.time.LocalDateTime;

public class Timeframe {
	LocalDateTime from;
	LocalDateTime to;
	public Timeframe() {
		super();
	}
	public Timeframe(LocalDateTime from, LocalDateTime to) {
		super();
		this.from = from;
		this.to = to;
	}
	public LocalDateTime getFrom() {
		return from;
	}
	public void setFrom(LocalDateTime from) {
		this.from = from;
	}
	public LocalDateTime getTo() {
		return to;
	}
	public void setTo(LocalDateTime to) {
		this.to = to;
	}
	@Override
	public String toString() {
		return "Timeframe [from=" + from + ", to=" + to + "]";
	}
	
	

}
