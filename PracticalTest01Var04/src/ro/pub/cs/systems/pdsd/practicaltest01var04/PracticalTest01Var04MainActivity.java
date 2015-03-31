package ro.pub.cs.systems.pdsd.practicaltest01var04;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class PracticalTest01Var04MainActivity extends Activity {
	private final static int SECONDARY_ACTIVITY_REQUEST_CODE = 1;
	static final int REQUEST_M = 1;
	private String sinput = "";
	private int nr_total = 0;
	private int nr_corr = 0;
	private int nr_fail = 0;
	TextView sequence;
	Button bt1;
	Button bt2;
	Button bt3;
	Button bt4;
	Button btn;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_practical_test01_var04_main);
		if (savedInstanceState != null) 
		{
			if (savedInstanceState.getInt("nr_total")!=0)
				nr_total = savedInstanceState.getInt("nr_total");
			if (savedInstanceState.getInt("nr_fail")!=0)
				nr_fail = savedInstanceState.getInt("nr_fail");
			if (savedInstanceState.getInt("nr_total")!=0)
				nr_corr = savedInstanceState.getInt("nr_corr");
		}
		sequence = (TextView) findViewById(R.id.sequence);
        Button bt1 = (Button) findViewById(R.id.button_do);
        Button bt2 = (Button) findViewById(R.id.button_mi);
        Button bt3 = (Button) findViewById(R.id.button_sol);
        Button bt4 = (Button) findViewById(R.id.button_do_);
        Button btn = (Button) findViewById(R.id.navigate_to_secondary_activity_button);
        bt1.setOnClickListener(new OnClickListener() {

        	@Override
        	public void onClick(View v) {
        		// TODO Auto-generated method stub
        		//Toast.makeText(MainActivity.this, "return stuff", Toast.LENGTH_LONG).show();
        		
        		sinput = sinput + "do, ";
        		sequence.setText(sinput);
        	}
        });
        bt2.setOnClickListener(new OnClickListener() {

        	@Override
        	public void onClick(View v) {
        		sinput = sinput + "mi, ";
        		sequence.setText(sinput);
        	}
        });
        bt3.setOnClickListener(new OnClickListener() {

        	@Override
        	public void onClick(View v) {
        		sinput = sinput + "sol, ";
        		sequence.setText(sinput);
        	}
        });
        bt4.setOnClickListener(new OnClickListener() {

        	@Override
        	public void onClick(View v) {
        		sinput = sinput + "do', ";
        		sequence.setText(sinput);
        	}
        });
        btn.setOnClickListener(new OnClickListener() {

        	@Override
        	public void onClick(View v) {
        		Intent i = new Intent (ro.pub.cs.systems.pdsd.practicaltest01var04.PracticalTest01Var04MainActivity.this,
        				ro.pub.cs.systems.pdsd.practicaltest01var04.PracticalTest01Var04SecondaryActivity.class);
        		i.putExtra("seq", sinput);
        		startActivityForResult(i, SECONDARY_ACTIVITY_REQUEST_CODE);
				
        	}
        });
        String nrf = "" + nr_fail;
        String nrt = "" + nr_total;
        String nrc = "" + nr_corr;
        Log.w("nr_total ", nrt);
        Log.w("nr_failed ", nrf);
        Log.w("nr_tcorrect ", nrc);
        
		
	}
	@Override
	protected void onSaveInstanceState(Bundle savedInstanceState) {
		savedInstanceState.putInt("nr_total", nr_total);
		savedInstanceState.putInt("nr_total", nr_corr);
		savedInstanceState.putInt("nr_total", nr_fail);

		


	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.practical_test01_var04_main, menu);
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

	 @Override
	  public void onActivityResult(int requestCode, int resultCode, Intent intent) {
		 
		 sinput = "";
		 nr_total++;
		
		        if (resultCode == RESULT_OK) {
		        	Toast.makeText(this, "OK: The activity returned with result "+resultCode, Toast.LENGTH_SHORT).show();
		            nr_corr++;
		        }
		        else
		        	if (resultCode == RESULT_CANCELED) 
		        	{
		        		Toast.makeText(this, "BAD: The activity returned with result "+resultCode, Toast.LENGTH_SHORT).show();
		        		nr_fail++;
		        	}
		    
		 

	  }

}
