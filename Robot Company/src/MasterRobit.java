import java.util.ArrayList;

public class MasterRobit extends BaseModel{
	ArrayList<BaseModel> connections = new ArrayList<BaseModel>();
	
	public MasterRobit(String name, double batt){
		serialnum = name;
		battlevel = batt;
	}

	public void connectBot(BaseModel name){
		connections.add(name);
		
	}
	public void disconnectBot(BaseModel name){
		connections.remove(name);
	}
	
	public void viewConnections(){
		for(BaseModel count: connections){
			System.out.println(count.serialnum+ ", "+ count.getBatLevel());
		}
	}
	public boolean checkBat(BaseModel name){
		boolean needcharge = false;
		if(name.getBatLevel()<30){
			name.chargeBat();
			needcharge = true;
			System.out.println(name.serialnum + " Needs to be charged");
		}
		return needcharge;
	}
	public void activate(BaseModel name){
		if(!(checkBat(name))){
			((BendingUnit) name).bendGirder();
		}
		
		
	}
	public static void main(String[] args) {
		BendingUnit Bender = new BendingUnit("Bender1", 87.32);
		BendingUnit Bender2 = new BendingUnit("Bender2", 27.32);
		BendingUnit Bender3 = new BendingUnit("Bender3", 17.32);
		BendingUnit Bender4 = new BendingUnit("Bender4", 57.32);
		BendingUnit Bender5 = new BendingUnit("Bender5", 97.32);
		MasterRobit Fry = new MasterRobit("fry" , 37.02);
		Fry.connectBot((BaseModel) Bender);
		Fry.connectBot((BaseModel) Bender3);
		Fry.connectBot((BaseModel) Bender2);
		Fry.connectBot((BaseModel) Bender4);
		Fry.connectBot((BaseModel) Bender5);
		Fry.viewConnections();
		Fry.disconnectBot(Bender);
		Fry.activate(Bender2);
		Fry.activate(Bender2);
		Fry.move((int) Math.round(Math.random()*100));
	}

}
