package conf.room.services;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Map.Entry;
import java.util.TreeMap;

import org.springframework.stereotype.Component;

@Component
public class BookingServiceTreeMap implements BookingService{

	private static TreeMap<Integer,Integer> map = new TreeMap<>();
	
	public synchronized boolean booking(int slotFrom, int slotTo) {
		int slotNumber = slotTo - slotFrom + 1;
//		System.out.println(slotFrom);
//		System.out.println(slotTo);
//		System.out.println(slotNumber);
		if (slotNumber <=0 ) return false;
		Entry<Integer, Integer> entryNextSlot = map.ceilingEntry(slotFrom);
		if(entryNextSlot!=null && entryNextSlot.getKey()<slotFrom+slotNumber) return false;
		Entry<Integer, Integer> entryPrevSlot = map.lowerEntry(slotFrom);
		if(entryPrevSlot!=null && slotFrom<entryPrevSlot.getKey()+entryPrevSlot.getValue()) return false;
		map.put(slotFrom, slotNumber);
		saveState(slotFrom, slotNumber);
		return true;
	}

	private void saveState(long slotFrom, long slotNumber) {
		// TODO Auto-generated method stub
		
	}

	public void readState() {
				
	}
}
