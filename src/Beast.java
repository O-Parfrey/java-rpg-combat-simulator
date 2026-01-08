
public class Beast extends Creature {

	private int ferocity;
	
	public Beast(String name, int health, int attackPower, int ferocity) {
		super(name, health, attackPower);
		this.ferocity = ferocity;
	}
	
	public int getFerocity() {
		return ferocity;
	}
	
	public void setFerocity(int ferocity) {
		this.ferocity = ferocity;
	}
	
	public String attack(String target) {
		return getName() + " claws at " + target + " with ferocity " + ferocity + "!";
	}
	

}
