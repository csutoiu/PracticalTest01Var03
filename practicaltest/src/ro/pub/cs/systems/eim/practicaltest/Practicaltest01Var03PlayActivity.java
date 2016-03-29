package ro.pub.cs.systems.eim.practicaltest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Practicaltest01Var03PlayActivity extends Activity {

	Button checkBtn, backBtn;
	EditText riddleText, answerText, scorText;
	String correctAnswer;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_practicaltest01_var03_play);
		
		checkBtn = (Button)findViewById(R.id.check);
		checkBtn.setOnClickListener(new clickListener());
		
		backBtn = (Button)findViewById(R.id.back);
		backBtn.setOnClickListener(new clickListener());
		
		riddleText = (EditText)findViewById(R.id.secondRiddle);
		answerText = (EditText)findViewById(R.id.secondAnswer);
		scorText = (EditText)findViewById(R.id.scor);
		
		Intent parentIntent = getIntent();
		if(parentIntent != null) {
			Bundle bundle =  parentIntent.getExtras();
			riddleText.setText((CharSequence) bundle.get("RIDDLE_KEY"));
			correctAnswer = bundle.getString("ANSWER_KEY");
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.practicaltest01_var03_play, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	 private class clickListener  implements View.OnClickListener {

			@Override
			public void onClick(View arg0) {
				int id = ((Button)arg0).getId();
				switch (id) {
				case R.id.check:
					if(correctAnswer.equals(answerText.getText().toString())) {
						Toast.makeText(getApplicationContext(),"Correct Answer" , 
								   Toast.LENGTH_LONG).show();
					} else {
						Toast.makeText(getApplicationContext(),"Wrong Answer" , 
								   Toast.LENGTH_LONG).show();
					}
					break;
				case R.id.back:
					finish();

				default:
					break;
				}
			}
	    	
	    }
}
