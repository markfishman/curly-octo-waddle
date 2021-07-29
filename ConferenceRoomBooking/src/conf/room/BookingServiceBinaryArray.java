package conf.room;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class BookingServiceBinaryArray implements BookingService {
	final static long slotSize = 600;
	private static boolean[] arr = new boolean[1000000];
	
	@Override
	public boolean booking(LocalDateTime from, LocalDateTime to) {
		long firstSlot = LocalDateTime.parse("2020-01-01T00:00:00").toEpochSecond(ZoneOffset.UTC)/slotSize;
		System.out.println(from);
		System.out.println(to);
		int slotFrom = (int) (from.toEpochSecond(ZoneOffset.UTC)/slotSize-firstSlot);
		int slotTo = (int) ((to.toEpochSecond(ZoneOffset.UTC)-1)/slotSize-firstSlot);
		int slotNumber = slotTo - slotFrom + 1;
//		System.out.println(slotFrom);
//		System.out.println(slotTo);
//		System.out.println(slotNumber);
		if (slotNumber <=0 ) return false;
		for(int i=slotFrom;i<=slotTo;i++) {
			if(arr[i]==true) return false;
		}
		for(int i=slotFrom;i<=slotTo;i++) {
			arr[i]=true;
		}
		return true;
	}

	private void saveState(long slotFrom, long slotNumber) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void readState() {
		// TODO Auto-generated method stub

	}

}
