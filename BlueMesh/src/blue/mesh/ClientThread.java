package blue.mesh;
import java.io.IOException;
import java.util.Set;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.os.Handler;
import android.os.ParcelUuid;
import android.util.Log;



public class ClientThread extends Thread{
	private static final String TAG = "ClientThread";
	private Handler handler;
	private BluetoothAdapter adapter;
	private RouterObject router;

	public ClientThread(  
			Handler mHandler, 
			BluetoothAdapter mAdapter, 
			RouterObject mRouter )  {

		handler = mHandler;
		adapter = mAdapter;
		router = mRouter;
	}

	//function run gets list of paired devices, and attempts to 
	//open and connect a socket for that device, which is then 
	//passed to the router object
	public void run() {
		
		while (true)
		{
			if(this.isInterrupted()){
				if(Constants.DEBUG) Log.d(TAG, "interrupted");
				break;
			}
			//get list of all paired devices
			Set <BluetoothDevice> pairedDevices = adapter.getBondedDevices();

			for (BluetoothDevice d : pairedDevices)
			{
				BluetoothSocket clientSocket = null;
				try {
					//TODO: ask the router if it is already connected
					//to that device before trying to connect to it
					clientSocket = d.createRfcommSocketToServiceRecord(
							Constants.MY_UUID);
				}

				catch (IOException e) {
					Log.e(TAG, "Socket create() failed", e);
				}

				//once a socet is opened, try to connect and then pass to router
				try {
					clientSocket.connect();
					router.beginConnection(clientSocket);
				}

				catch (IOException e) {
					Log.e(TAG, "Socket connect() failed", e);
				}
			}
		}
		return;
	}
};


