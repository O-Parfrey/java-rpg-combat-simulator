import java.util.Scanner;
import java.util.Random;

public class BattleTurn {
	 
	
	public static boolean playerTurn(Creature player, Creature enemy, Scanner scanner) {
		Random rand = new Random();
		
		System.out.println("It's your turn, what will you do?");
		
		while(true) {
			System.out.println("Battle Menu");
			System.out.println("===========");
			System.out.println("1. Attack");
			System.out.println("2. Defend");
			System.out.println("3. Heal");
			System.out.println("4. Flee");
			//System.out.println("Your health: " + player.getHealth() + " Enemy health: " + enemy.getHealth());
			String input = scanner.nextLine();
			int choice;
			
			try {
			    choice = Integer.parseInt(input);
			} catch (NumberFormatException e) {
			    System.out.println("Invalid input! Please enter a number 1–4.");
			    continue;
			}
			
			if(choice > 4 || choice < 1) {
				System.out.println("Please select a valid option");
				continue;
			}
			
			switch(choice){
			
			case 1:
				System.out.println("You attack!");
				System.out.println(player.attack(enemy.getName()));
				enemy.takeDamage(player.getAttackPower());
				
				if(enemy.isAlive()) {
					System.out.println("The enemy attacks!");
					System.out.println(enemy.attack(player.getName()));
					player.takeDamage(enemy.getAttackPower());
				}
				System.out.println("--------------------------------------------");
				return true;
			
			case 2:
				System.out.println("\nYou defend!");
				int blockChance = rand.nextInt(100) + 1;
				int counterChance = rand.nextInt(100) + 1;
				
				int successRate;
				int counterRate = 0;
				
				if(player instanceof Warrior) {
					successRate = 60; 
				} else if (player instanceof Mage) {
					successRate = 40;
				} else if (player instanceof Beast) {
					successRate = 50;
					counterRate = 50;
				} else {
					successRate = 50;
				}
				
				if(player instanceof Warrior && blockChance <= 5) { //warrior special
					System.out.println("Sparks flow as you block all the damage!");
					System.out.println(enemy.attack(player.getName()));
					player.takeDamage(0);
					System.out.println("--------------------------------------------");
					return true;
				}
				
				if(blockChance <= successRate) {
					System.out.println("You blocked the attack!");
					System.out.println();
					
					if(player instanceof Mage) {//mage special abilities
						Mage mage = (Mage) player;
						System.out.println(enemy.attack(player.getName()));
						
						if(mage.getMana() >= 10) { // mages reflect/absorb shield
							mage.setMana(mage.getMana() - 10);
							System.out.println("You use your mana and create a dazzling shield blocking some of the damage!");
							int absorbed = enemy.getAttackPower() / 4;
							int reflected = enemy.getAttackPower() / 2;
							player.takeDamage(absorbed);
							enemy.takeDamage(reflected);
							System.out.println("You reflected some damage back!");	
							if(!enemy.isAlive()) {
								System.out.println(enemy.getName() +  " was destroyed by reflected magic!");
								System.out.println("--------------------------------------------");
								return true;
							}
						} else {
							System.out.println("You don't have enough mana to use your mana shield.");
							player.takeDamage(enemy.getAttackPower());
						}
					}
					if(player instanceof Beast) { //beast special abilities
						System.out.println(enemy.attack(player.getName()));
						player.takeDamage(enemy.getAttackPower() / 4);
						
						if(counterChance <= counterRate) { // counter rate for beast
							System.out.println("You counterattacked!");
							System.out.println(player.attack(enemy.getName()));
							enemy.takeDamage(player.getAttackPower());
						}
					} else{ //everyone else, new classes
						System.out.println(enemy.attack(player.getName()));
						player.takeDamage((enemy.getAttackPower() / 4));
						
					}
				} else {
					System.out.println("You failed to block!");
					System.out.println(enemy.attack(player.getName()));
					player.takeDamage(enemy.getAttackPower());
				}
				System.out.println("--------------------------------------------");
			return true;	
			
				
				
			case 3:
				System.out.println("You stop to focus and heal...");
				int healAmount;
				if(player instanceof Warrior) {
					healAmount = rand.nextInt(10) + 10;
				} else if (player instanceof Mage) {
					healAmount = rand.nextInt(15) + 15;
				} else if (player instanceof Beast) {
					healAmount = rand.nextInt(7) + 9;
				} else {
					healAmount = rand.nextInt(6) + 10;
				}
				
				int newHealth = player.getHealth() + healAmount;
				if(newHealth > player.getMaxHealth()) {
					newHealth = player.getMaxHealth();
				}
				
				player.setHealth(newHealth);
				System.out.println("You restored some health! (" + player.getHealth() + "/" + player.getMaxHealth() + ")");
				System.out.println("The enemy attacks you while you recover!");
				System.out.println(enemy.attack(player.getName()));
				player.takeDamage(enemy.getAttackPower());
				 System.out.println("--------------------------------------------");
				return true;
				
			case 4: 
				System.out.println("You try to flee!");
				int fleeChance = rand.nextInt(100) + 1;
				int fleeRate = 50;

					if(player instanceof Warrior) { //Flee chance and flee options of warrior
						fleeRate = 40;
						
						if(fleeChance <= fleeRate) {
						System.out.println("You successfully ran away!");
						 System.out.println("--------------------------------------------");
						return false;
					} else {
						System.out.println("Warriors rarely flee... you failed to escape");
						System.out.println(enemy.attack(player.getName()));
						player.takeDamage(enemy.getAttackPower());
						 System.out.println("--------------------------------------------");
						return true;
						
					}
					}
					
					if(player instanceof Mage) {  //Flee chance and flee options of mage
						fleeRate = 60;
						
						if(fleeChance <= fleeRate) {
						System.out.println("You disappeared in a flash of smoke!");
						 System.out.println("--------------------------------------------");
						return false;
					} else {
						System.out.println("Your magic failed to help you escape...");
						System.out.println(enemy.attack(player.getName()));
						player.takeDamage(enemy.getAttackPower());
						 System.out.println("--------------------------------------------");
						return true;
					}
					}
					
					if(player instanceof Beast) {  //Flee chance and flee options of beast 
						fleeRate = 70;
						
						if(fleeChance <= fleeRate) {
						System.out.println("You ran off to the other beasts to lick your wounds...");
						 System.out.println("--------------------------------------------");
						return false;
					} else {
						System.out.println("You weren't fast enough to get away...");
						System.out.println(enemy.attack(player.getName()));
						player.takeDamage(enemy.getAttackPower());
						 System.out.println("--------------------------------------------");
						return true;
					}
					}
					
				}
			}
		}
	}

