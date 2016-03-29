package ro.pub.cs.systems.eim.practicaltest;


import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class PracticalTest01Var03Service extends Service{

	private ProcessingThread processingThread = null;
		
	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}
		
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		String answer = intent.getStringExtra("ANSWER_KEY");
		processingThread = new ProcessingThread(this,answer);
		processingThread.start();
		return Service.START_REDELIVER_INTENT;
	}

}

