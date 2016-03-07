
public class BendingUnit extends BaseModel {
	
	public BendingUnit(String name, double batt){
		serialnum = name;
		battlevel = batt;
		
	}
	public void bendGirder(){
		if (battlevel > 20){
			System.out.println("Operation Complete");
			battlevel = battlevel - (5* (Math.random()*4 +1));
			System.out.println(getBatLevel());
		}
		else {
			System.out.println("Charging Needed");
			chargeBat();
		}
	}

}
