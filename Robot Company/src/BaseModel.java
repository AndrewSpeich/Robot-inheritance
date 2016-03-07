
public class BaseModel {
	double battlevel;
	String serialnum;
	
	public String getSerial(){
		return serialnum;
	}
	public int getBatLevel(){
		return (int) Math.round(battlevel);
	}
	public void chargeBat(){
		battlevel = 100;
	}
	public void move(int distance){
		if((battlevel > 20)&& (battlevel > (distance*0.1127))){
		battlevel = battlevel - (distance * 0.1127);
		System.out.print("Moved "+distance+" feet, Charge Remaining "+getBatLevel()+"%");
		}
		else {
			System.out.println("Unable to comply, Requires Charging");
			chargeBat();
		}
	}
	
}
