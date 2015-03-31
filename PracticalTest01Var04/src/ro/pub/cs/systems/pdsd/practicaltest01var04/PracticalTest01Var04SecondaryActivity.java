package ro.pub.cs.systems.pdsd.practicaltest01var04;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class PracticalTest01Var04SecondaryActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_practical_test01_var04_secondary);
		
		/*TextView sequence;
		sequence = (TextView) findViewById(R.id.sequence);
		sequence.setText("");
		*/
		Intent i = getIntent();
		if(i!=null)
		{
			String c_user = i.getExtras().getString("seq");
			if(c_user=="do, mi, sol, do',")
			{
				Toast.makeText(this, "The activity returned with result "+c_user, Toast.LENGTH_SHORT).show();
				setResult(RESULT_OK, new Intent());
		          finish();
			}
			else{
				Toast.makeText(this, "The activity returned with result "+c_user, Toast.LENGTH_SHORT).show();
				setResult(RESULT_CANCELED, new Intent());
		          finish();
			}
			
		}
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater()
				.inflate(R.menu.practical_test01_var04_secondary, menu);
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


}
