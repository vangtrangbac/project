package nam.tutorial;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class SQLView extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sqlview);
		TextView tv=(TextView)findViewById(R.id.tvSQLinfo);
		HostOrNot info= new HostOrNot(this);
		info.open(); 
		String data =info.getData();
		info.close();
		tv.setText(data);
		
	}
   
}
