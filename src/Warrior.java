
public class Warrior extends Creature {
	private int strength;
	private String weapon;
	
	public Warrior(String name, int health, int attackPower, int strength, String weapon) {
		super(name, health, attackPower);
		this.strength = strength;
		this.weapon = weapon;
	}
	
	public int getStrength() {
		return strength;
	}
	
	public void setStrength(int strength) {
		this.strength = strength;
	}
	
	public String getWeapon() {
		return weapon;
	}
	
	public void setWeapon(String weapon) {
		this.weapon = weapon;
	}
	
	public String attack(String target) {
		return getName() + " attacks " + target + " with a " + weapon + ", dealing " + (getAttackPower() + strength) + " damage.";
	}
	
}
