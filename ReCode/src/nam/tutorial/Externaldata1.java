
//Chua hoan thanh
package nam.tutorial;

import java.io.File;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class Externaldata1 extends Activity implements OnItemSelectedListener{
	private TextView canWrite,canRead;
    private String state;
    boolean canW,canR;
    Spinner spiner;
    String[] paths={"Music","Picture","Download"};
    File path=null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.externaldata);
		canWrite=(TextView)findViewById(R.id.tvCanWrite);
		canRead=(TextView)findViewById(R.id.tvCanRead);
		state=Environment.getExternalStorageState();
		if(state.equals(Environment.MEDIA_MOUNTED)){
		canRead.setText("true");
		canWrite.setText("true");
		canR=canW=true;
		}else if(state.equals(Environment.MEDIA_MOUNTED_READ_ONLY)){
			canRead.setText("false");
			canWrite.setText("true");
			canR=true;
			canW=false;
		}else
		{
			canRead.setText("false");
			canWrite.setText("false");
			canR=canW=false;
			
		}
		ArrayAdapter<String> adapter=new ArrayAdapter<String>(Externaldata1.this,android.R.layout.simple_spinner_item,paths);
		spiner=(Spinner)findViewById(R.id.spiner);
		spiner.setAdapter(adapter);
		spiner.setOnItemSelectedListener(this);
		
	}
	public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
			long arg3) {
		// TODO Auto-generated method stub
		int possition=spiner.getSelectedItemPosition();
		switch(possition){
		case 0:
			//path=Environment.getExternalStorageDirectory(Environment.)
			break;
		case 1:
			break;
		case 2:
			break;
		}
	}
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub
		
	}
	

}
