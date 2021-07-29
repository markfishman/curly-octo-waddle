package conf.room.services;

import java.util.concurrent.ConcurrentHashMap;

public class BookingServiceHashMap implements BookingService {

	private static ConcurrentHashMap<Integer, Long> map = new ConcurrentHashMap<Integer,Long>();
	private static int basketSize = 128;
	
	@Override
	public boolean booking(int from, int to) {
		if(from>to) return false;
		boolean changeMode = false;
		if(!walk(from,to,changeMode)) return false;
		changeMode = true;
		return walk(from,to,changeMode);
	}

	private boolean walk(int from, int to, boolean changeMode) {
		int currentBasket = from / basketSize;
		int fromIntoBasket = from - currentBasket * basketSize;
		while(from<=to) {			
			int toIntoBasket = Math.min(to - currentBasket * basketSize, basketSize-1);
			if(!checkBusket(currentBasket,fromIntoBasket,toIntoBasket,changeMode)) return false;
			from = currentBasket * basketSize + toIntoBasket+1;
			currentBasket++;
			fromIntoBasket = 0;
		}
		return true;
	}

	private boolean checkBusket(int currentBasket, int fromIntoBasket, int toIntoBasket, boolean changeMode) {
		Long basket = map.get(currentBasket);
		if(basket==null) {
			if(!changeMode) {
				return true;
			} else {
				map.put(currentBasket, convertIntervalToLong(fromIntoBasket,toIntoBasket));
				return true;
			}
		};
		Long conv = convertIntervalToLong(fromIntoBasket,toIntoBasket);
		if(!changeMode) {
			return ((basket&conv)==0);
		} else {
			map.put(currentBasket,(basket|conv));
			return true;
		}		
	}

	private Long convertIntervalToLong(int fromIntoBasket, int toIntoBasket) {
		long res = 0;
		long degree2 = 1;
		for(int i=0;i<fromIntoBasket;i++) {
			degree2 = (degree2 << 1);
		};
		for(int i=fromIntoBasket;i<=toIntoBasket;i++) {
			res+=degree2;
			degree2 = (degree2 << 1);
		};		
		return res;
	}

	@Override
	public void readState() {
		// TODO Auto-generated method stub
		
	}
}
