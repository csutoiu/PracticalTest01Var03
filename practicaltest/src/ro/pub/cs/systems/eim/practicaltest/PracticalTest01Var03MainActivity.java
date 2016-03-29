package ro.pub.cs.systems.eim.practicaltest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class PracticalTest01Var03MainActivity extends Activity {
	
	Button playBtn;
	EditText riddleText, answerText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var03_main);
        playBtn = (Button)findViewById(R.id.button1) ;
        playBtn.setOnClickListener(new clickListener());
        
        riddleText = (EditText)findViewById(R.id.riddle);
        answerText = (EditText)findViewById(R.id.answer);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.practical_test01_var03_main, menu);
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
			case R.id.button1:
				Intent intent = new Intent(getApplicationContext(), Practicaltest01Var03PlayActivity.class);
				intent.putExtra("ANSWER_KEY", answerText.getText().toString());
				intent.putExtra("RIDDLE_KEY", riddleText.getText().toString());
				startActivityForResult(intent, 100);
				break;

			default:
				break;
			}
		}
    	
    }
}
