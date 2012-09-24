package nam.tutorial;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ExternalData extends Activity implements OnClickListener{

	TextView dataResults;
	EditText sharedData;
	FileOutputStream  Fos;
	String FILENAME="Internal String";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sharedpreferences);
		setup();
	}
	private void setup(){
		Button save=(Button)findViewById(R.id.bSave);
		Button load=(Button)findViewById(R.id.bLoad);
		sharedData=(EditText)findViewById(R.id.etSharedPrefs);
		dataResults=(TextView)findViewById(R.id.tvLoadSharedPrefs);
		save.setOnClickListener(this);
		load.setOnClickListener(this);
		try{
			Fos=openFileOutput(FILENAME,Context.MODE_PRIVATE);
				Fos.close();
				
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
		case R.id.bSave:
		/*	File f=new File(FILENAME);
			try{
				Fos=new FileOutputStream(f);
				//Write some data
				Fos.close();
			}catch(FileNotFoundException e){
				e.printStackTrace();
			}*/
			String data=sharedData.getText().toString();
			File f=new File(FILENAME);
			try{
			Fos=openFileOutput(FILENAME,Context.MODE_PRIVATE);
			
			Fos.write(data.getBytes());
			Fos.close();
			}catch(IOException e){
				e.printStackTrace();
			}
			break;
		case R.id.bLoad:
			/*String collected=null;
			FileInputStream fis=null;
			try{
				fis=openFileInput(FILENAME);
				byte[] dataArray=new byte[fis.available()];
				while(fis.read(dataArray)!=-1){
					collected=new String(dataArray);
				}
			}catch(FileNotFoundException e){
				e.printStackTrace();
				
			}catch(IOException e){
				e.printStackTrace();
			}finally{
				try{
				fis.close();
				dataResults.setText(collected);
				}catch(IOException e){
					e.printStackTrace();
				}
			}*/
			new loadSomeStuff().execute(FILENAME);
			break;
		}
	}
	public class loadSomeStuff extends AsyncTask<String,Integer,String>{

		ProgressDialog dialog;
		protected void onPreExecute(){
			//example of seting up some thingis
			dialog=new ProgressDialog(ExternalData.this);
			dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
			dialog.setMax(100);
			dialog.show();
		}
		@Override
		protected String doInBackground(String... params) {
			// TODO Auto-generated method stub
			String collected=null;
			FileInputStream fis=null;
			
			for(int i=0;i<20;i++){
				publishProgress(5);
				try {
					Thread.sleep(88);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			dialog.dismiss();
			try{
				fis=openFileInput(FILENAME);
				byte[] dataArray=new byte[fis.available()];
				while(fis.read(dataArray)!=-1){
					collected=new String(dataArray);
				}
			}catch(FileNotFoundException e){
				e.printStackTrace();
				
			}catch(IOException e){
				e.printStackTrace();
			}finally{
				try{
				fis.close();
				return collected;
				}catch(IOException e){
					e.printStackTrace();
				}
			}
			return null;
		}
		protected void onProgessUpdate(Integer ...progress){
			dialog.incrementProgressBy(progress[0]);
		}
		protected void onPostExecute(String results){
			dataResults.setText(results);
		}
		
	}
	
  
}
