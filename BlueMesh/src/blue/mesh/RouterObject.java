package blue.mesh;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothSocket;
import android.os.Handler;


public class RouterObject {

	private Handler handler;
	private BluetoothAdapter adapter;
	
	RouterObject( Handler mHandler, BluetoothAdapter mAdapter) {
		handler = mHandler;
		adapter= mAdapter;
	}
	
	//TODO: MAKE THIS CALL SYNCHRONIZED
	public int BeginConnection(BluetoothSocket mSocket) {
		
		//Great Success!
		return 1;
	}
	
	public int WriteAll(byte buff[]) {
		//Great Success!
		return 1;
	}
	
	public byte [] GetUserMessage() {
		byte arr[] = null;
		return arr;
	}
	
	public int stop() {
		//Great Success!
		return 1;
	}
}

