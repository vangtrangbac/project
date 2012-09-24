package nam.tutorial;

public class XMLDataCollected {
int temp =0;
String city =null;
public void setCity(String c){
	city =c;
}
public void setTemp(int t){
	temp =t;
}
public String dataTostring(){
	return "In" +city + "the Current Time in F is "+temp +"degree";
}
}
