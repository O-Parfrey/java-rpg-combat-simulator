
public abstract class Creature {
	private String name;
	private int health;
	private int attackPower;
	private int maxHealth;
	
	public Creature(String name, int health, int attackPower) {
		this.name = name;
		this.health = health;
		this.maxHealth = health;
		this.attackPower = attackPower;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getHealth() {
		return health;
	}
	
	public void setHealth(int health) {
		this.health = health;
	}
	
	public int getAttackPower() {
		return attackPower;
	}
	
	public void setAttackPower(int attackPower) {
		this.attackPower = attackPower;
	}
	
	public void takeDamage(int damage) {
		health -= damage;
		if(health < 0) {
			health = 0;
		} 
	}
	
	public boolean isAlive() {
		return health > 0;
	}
	
	public String displayInfo() {
		return name + " | HP: " + health + " | Attack: " + attackPower;
}
	public abstract String attack(String target); 
	
	public int getMaxHealth() {
		return maxHealth;
	}
	
	public void setMaxHealth(int maxHealth) {
		this.maxHealth = maxHealth;
	}
}
	
