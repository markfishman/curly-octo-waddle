package conf.room.services;

public class BookingServiceBinaryArray implements BookingService {

	private static boolean[] arr = new boolean[1000000];
	
	@Override
	public synchronized boolean booking(int slotFrom, int slotTo) {
		if(slotFrom>slotTo) return false;
		for(int i=slotFrom;i<=slotTo;i++) {
			if(arr[i]==true) return false;
		}
		for(int i=slotFrom;i<=slotTo;i++) {
			arr[i]=true;
		}
		return true;
	}

	private void saveState(int slotFrom, int slotTo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void readState() {
		// TODO Auto-generated method stub

	}

}
