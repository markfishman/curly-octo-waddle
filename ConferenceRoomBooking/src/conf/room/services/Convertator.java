package conf.room.services;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

import conf.room.Timeframe;

public class Convertator {
	final static long slotSize = 600;
	public static int[] convertToInt(Timeframe timeframe) {
		long firstSlot = LocalDateTime.parse("2020-01-01T00:00:00").toEpochSecond(ZoneOffset.UTC)/slotSize;
		int slotFrom = (int) (timeframe.getFrom().toEpochSecond(ZoneOffset.UTC)/slotSize-firstSlot);
		int slotTo = (int) ((timeframe.getTo().toEpochSecond(ZoneOffset.UTC)-1)/slotSize-firstSlot);
		int slotNumber = slotTo - slotFrom + 1;
		System.out.println(slotFrom);
		System.out.println(slotTo);
		return new int[] {slotFrom,slotTo,slotNumber};
	}
}
