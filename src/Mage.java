
public class Mage extends Creature {
	private int mana;
	private int spellPower;
	
	public Mage(String name, int health, int attackPower, int mana, int spellPower) {
		super(name, health, attackPower);
		this.mana = mana;
		this.spellPower = spellPower;
	}
	
	public int getMana() {
		return mana;
	}
	
	public void setMana(int mana) {
		this.mana = mana;
	}
	
	public int getSpellPower() {
		return spellPower;
	}
	
	public void setSpellPower(int spellPower) {
		this.spellPower = spellPower;
	}
	
	public String attack(String target) {
		if(mana >= 10) {
			mana -= 10;
			return getName() + " casts a spell at " + target + ", dealing " + (getAttackPower() + spellPower)
					+ " damage! " + mana + " mana left.";
		} else {
			return getName() + " tries to cast a spell but is out of mana!";
		}
	}
	
}
