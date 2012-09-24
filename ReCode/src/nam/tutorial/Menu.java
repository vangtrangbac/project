package nam.tutorial;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Menu extends ListActivity {
    //Tao 1 mang chua danh sach cac me nu
	String classes[]={"ReCodeActivity","Text","ExternalData","SQLite"
			,"HttpExam","WeatherXMLParsing"
			};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		//FullScreen activation
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		
		setListAdapter(new ArrayAdapter<String>(Menu.this,android.R.layout.simple_list_item_1,classes));
		
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		String cheese=classes[position];
		Class ourClass;
		
			try {
				ourClass=Class.forName("nam.tutorial."+cheese);
				Intent ourIntent =new Intent(Menu.this,ourClass);
				startActivity(ourIntent);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}

	@Override
	public boolean onCreateOptionsMenu(android.view.Menu menu) {
		// TODO Auto-generated method stub
		super.onCreateOptionsMenu(menu);
		MenuInflater blowup=getMenuInflater();
		blowup.inflate(R.menu.cool_menu, menu);
		return true;
		
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		 super.onOptionsItemSelected(item);
		 switch(item.getItemId()){
		 case R.id.aboutUs:
			 Intent i=new Intent("nam.tutorial.ABOUTUS");
			 startActivity(i);
			 break;
		 case R.id.prefs:
			 Intent s=new Intent("nam.tutorial.PREFS");
			 startActivity(s);
			 break;
		 case R.id.exit:
			 
			 finish();
			 break;
		 }
		 return false;
	}
	
	
	
	
			
	
}
