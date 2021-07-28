package conf.room;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Map.Entry;
import java.util.TreeMap;

public class BookingService {

	final static long slotSize = 600;
	static TreeMap<Long,Long> map = new TreeMap<>();
	
	public synchronized static boolean booking(LocalDateTime from, LocalDateTime to) {
		System.out.println(from);
		System.out.println(to);
		long slotFrom = from.toEpochSecond(ZoneOffset.UTC)/slotSize;
		long slotTo = (to.toEpochSecond(ZoneOffset.UTC)-1)/slotSize;
		long slotNumber = slotTo - slotFrom + 1;
		System.out.println(slotFrom);
		System.out.println(slotTo);
		System.out.println(slotNumber);
		if (slotNumber <=0 ) return false;
		Entry<Long, Long> entryNextSlot = map.ceilingEntry(slotFrom);
		if(entryNextSlot!=null && entryNextSlot.getKey()<slotFrom+slotNumber) return false;
		Entry<Long, Long> entryPrevSlot = map.lowerEntry(slotFrom);
		if(entryPrevSlot!=null && slotFrom<entryPrevSlot.getKey()+entryPrevSlot.getValue()) return false;
		map.put(slotFrom, slotNumber);
		saveMap(map);
		return true;
	}

	private static void saveMap(TreeMap<Long, Long> map2) {
		// TODO Auto-generated method stub
		
	}

	private static void readMap() {
		// TODO Auto-generated method stub
		
	}
}
