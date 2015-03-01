package edu.utdallas.hack.buyforme;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public class MainActivity extends Activity {
	private static final String LOCAL_PREFERENCES_NAME = "Local_Preferences";
	private static final String KEY_RETURNING_INSTANCE = "isReturningInstance";
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        SharedPreferences sp = getSharedPreferences(LOCAL_PREFERENCES_NAME, 0);
        boolean isFirstTimeLaunch = sp.getBoolean(KEY_RETURNING_INSTANCE, false);
        if(isFirstTimeLaunch)
        	launchFirstTime();
        else
        	launchHomeActivity();
    }


	private void launchHomeActivity() {
		// TODO Auto-generated method stub
		
	}


	private void launchFirstTime() {
		setContentView(R.layout.activity_main);
        
        Button verifyPhoneButton = (Button) findViewById(R.id.verifyPhoneButton);
        verifyPhoneButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View view) {
				onVerifyPhoneClicked(view);
			}
		});
	}


    protected void onVerifyPhoneClicked(View view) {
		Intent intent = new Intent(this, SignUpActivity.class);
		startActivity(intent);
	}


	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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
