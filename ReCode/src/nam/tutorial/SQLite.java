package nam.tutorial;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SQLite extends Activity implements OnClickListener  {
    
	Button sqlUpdate,sqlView,sqlModify,sqlGetInfo,sqlDelete;
	EditText sqlName,sqlHotness,sqlRow;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sqllite);
		sqlUpdate=(Button)findViewById(R.id.bSQLUpdate);
		sqlName=(EditText)findViewById(R.id.etSQLName);
		sqlHotness=(EditText)findViewById(R.id.etSQLHostness);
		sqlView=(Button)findViewById(R.id.bSQLopenView);
		sqlUpdate.setOnClickListener(this);
		sqlView.setOnClickListener(this);
		
		sqlRow=(EditText)findViewById(R.id.etSQLrowInfo);
		sqlModify=(Button)findViewById(R.id.bSQLmodify);
		sqlGetInfo=(Button)findViewById(R.id.bgetInfo);
		sqlDelete=(Button)findViewById(R.id.bSQLdelete);
		
		sqlDelete.setOnClickListener(this);
		sqlModify.setOnClickListener(this);
		sqlGetInfo.setOnClickListener(this);
	}


	public void onClick(View v) {
		// TODO Auto-generated method stub
	   switch(v.getId()){
	   case R.id.bSQLUpdate:
		   boolean didItwork=true;
		   try{
		   String name=sqlName.getText().toString();
		   String hostness=sqlHotness.getText().toString();
		   
		   HostOrNot entry=new HostOrNot(SQLite.this);
		   entry.open();
		   entry.createEntry(name,hostness);
		   entry.close();}
		   catch(Exception e){
			   didItwork =false;
			   String eror=e.toString();
			   Dialog d=new Dialog(this);
			   d.setTitle("Dang it!");
			   TextView tv =new TextView(this);
			   tv.setText("eror");
			   d.setContentView(tv);
			   d.show();
		   }finally{
			   if(didItwork){
				   Dialog d=new Dialog(this);
				   d.setTitle("Heck Yeal!");
				   TextView tv =new TextView(this);
				   tv.setText("Success");
				   d.setContentView(tv);
				   d.show();
			   }
		   }
		   break;
	   case R.id.bSQLopenView:
		   Intent i=new Intent("nam.tutorial.SQLVIEW");
		   startActivity(i);
		   break;
	   case R.id.bgetInfo:
		   try{
		   String s=sqlRow.getText().toString();
		   long l=Long.parseLong(s);
		   HostOrNot hon=new HostOrNot(this);
		   hon.open();
		   String returnedName=hon.getName(l);
		   String returnedHotness=hon.getHotness(l);
		   hon.close();
		   sqlName.setText(returnedName);
		   sqlHotness.setText(returnedHotness);}
		   catch(Exception e){
			   String eror=e.toString();
			   Dialog d=new Dialog(this);
			   d.setTitle("Dang it!");
			   TextView tv =new TextView(this);
			   tv.setText("eror");
			   d.setContentView(tv);
			   d.show();}
		   break;
	   case R.id.bSQLmodify:
		   try{
		   String mName=sqlName.getText().toString();
		   String mHostness=sqlHotness.getText().toString();
		   String sRow=sqlRow.getText().toString();
		   long lRow=Long.parseLong(sRow);
		   HostOrNot ex=new HostOrNot(this);
		   ex.open();
		   ex.upddateEntry(lRow,mName,mHostness);
		   ex.close();}
		   catch(Exception e){
			   String eror=e.toString();
			   Dialog d=new Dialog(this);
			   d.setTitle("Dang it!");
			   TextView tv =new TextView(this);
			   tv.setText("eror");
			   d.setContentView(tv);
			   d.show();}
		   break;
	   case R.id.bSQLdelete:
		   try{
		   String sRow1=sqlRow.getText().toString();
		   long lRow1=Long.parseLong(sRow1);
		   HostOrNot ex1=new HostOrNot(this);
		   ex1.open();
		   ex1.deleteEntry(lRow1);
		   ex1.close();}
		   catch(Exception e){
			   String eror=e.toString();
			   Dialog d=new Dialog(this);
			   d.setTitle("Dang it!");
			   TextView tv =new TextView(this);
			   tv.setText("eror");
			   d.setContentView(tv);
			   d.show();}
		   break;
	   }
		
	}

}
