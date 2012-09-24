package nam.tutorial;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.preference.PreferenceManager;

public class Splash extends Activity{
      MediaPlayer ourSong;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash);
		//Tao bai nhac dao dau cho ung dung
		ourSong =MediaPlayer.create(Splash.this, R.raw.a);
		SharedPreferences getprefs=PreferenceManager.getDefaultSharedPreferences(getBaseContext());
		boolean music =getprefs.getBoolean("checkbox", true);
		if(music==true){
		ourSong.start();
		}
		
		//Tao thread can chinh thoi gian de chay qua intent tiep theo
		Thread timer=new Thread(){
			public void run(){
				try{
					sleep(5000);
				}catch(InterruptedException e){
					e.printStackTrace();
				}finally {
					//Nhay qua intent khac menu.class
					Intent open=new Intent("nam.tutorial.MENU");
					startActivity(open);
				}
			}
		
		
	} ;
	timer.start();
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		ourSong.release();
		finish();
	}
	
}
