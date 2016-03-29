package ro.pub.cs.systems.eim.practicaltest;

import java.util.Date;
import java.util.Random;

import android.R.array;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
 
public class ProcessingThread extends Thread {
 
	private Context context = null;
	private boolean isRunning = true;
 
	private Random random = new Random();
	private String answer;
 

	public ProcessingThread(Context context, String answer) {
		this.context = context;
		this.answer = answer;
	}
 
	@Override
	public void run() {
		Log.d("[ProcessingThread]", "Thread has started!");
		while (isRunning) {
			sendMessage();
			sleep();
		}
		Log.d("[ProcessingThread]", "Thread has stopped!");
	}
 
	private void sendMessage() {
    	Intent intent = new Intent();
    	intent.setAction("ACTION_INTENT");
    	
    	char array[] = new char[answer.length()];
    	
    	int number = random.nextInt()%(answer.length()-1);
    	Log.d("number is"+number, answer);
    	
    	for(int i = 0;i < answer.length();i++) {
    		if(i != number) {
    			array[i] = '*';
    		} else {
    			array[i] = answer.charAt(i);
    		}
    	}
    	
    	
    	
    	
    	String message = String.copyValueOf(array);
    	
    	
    	intent.putExtra("message", message);
    	context.sendBroadcast(intent);
	}
 
	private void sleep() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException interruptedException) {
			interruptedException.printStackTrace();
		}
	}
 
	public void stopThread() {
		isRunning = false;
	}
}
