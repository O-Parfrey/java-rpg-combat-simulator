import java.util.Scanner;
import java.util.Random;

public class CharacterSelect {
	
	
	public static Creature chooseCharacter(Scanner scanner, Warrior w, Mage m, Beast b) {
		//Scanner scanner = new Scanner(System.in);
		
	while(true) {
		System.out.println("Please choose a character to use!");
		System.out.println("=================================");
		System.out.println("1. " + w.getName() + " |HP: " + w.getHealth() + " |ATK:  " + w.getAttackPower() + " | Weapon: " + w.getWeapon() + " |STR: " + w.getStrength() );
		System.out.println("2. " + m.getName() + " |HP: " + m.getHealth() + " |ATK: " + m.getAttackPower() + " |Mana: " + m.getMana() + " |Spell Power: " + m.getSpellPower());
		System.out.println("3. " + b.getName() + " |HP: " + b.getHealth() + " |ATK: " + b.getAttackPower() + " |Ferocity: " + b.getFerocity());
		System.out.println("4. Exit");
		//int choice = scanner.nextInt(); temp fix for double input bug
		//scanner.nextLine(); 
		String input = scanner.nextLine();
		int choice;

		try { // temp fix for double input bug
		    choice = Integer.parseInt(input);
		} catch (NumberFormatException e) {
		    System.out.println("Invalid input! Please enter a number 1–4.");
		    continue;
		}
		
		
		if(choice > 4 || choice < 1) {
			System.out.println("Please input a valid command.");
			continue;
		}
		
		switch(choice){

			
			case 1:  
				System.out.println("You chose the mighty warrior!!!");
				Warrior playerWarrior = new Warrior("Hero Warrior", 60, 10, 8, "Sword");
				System.out.println("You are ready for battle!");
				System.out.println(playerWarrior.displayInfo());
				System.out.println();
				return playerWarrior;
								
			case 2:
				System.out.println("You chose the mighty mage!!!");
				Mage playerMage = new Mage("Arcane Mage", 45, 5, 40, 15);
				System.out.println("You are ready for battle!");
				System.out.println(playerMage.displayInfo());
				System.out.println();
				return playerMage;
				
				
			case 3: 
				System.out.println("You chose the Savage Wolf!");
				Beast playerBeast = new Beast("Savage Wolf", 50, 8, 6);
				System.out.println("You are ready for battle!");
				System.out.println(playerBeast.displayInfo());
				System.out.println();
				return playerBeast;
				
			case 4:
				System.out.println("Goodbye!");
				return null;
		}
		
		
	}
	}
	
	public static Creature chooseEnemy(Warrior w, Mage m, Beast b) {
		Random rand = new Random();
		int choice = rand.nextInt(3)+ 1;
		
		switch(choice) {
		
		case 1: 
			System.out.println("An enemy warrior appears!");
			Warrior enemyWarrior = new Warrior("Hero Warrior", 60, 10, 8, "Sword");
			System.out.println("He looks angry!");
			System.out.println(enemyWarrior.displayInfo());
			System.out.println();
			return enemyWarrior;
			
		case 2:
			System.out.println("An angry mage appears!");
			Mage enemyMage = new Mage("Arcane Mage", 45, 5, 40, 15);
			System.out.println("He's bursting with magical energy!");
			System.out.println(enemyMage.displayInfo());
			System.out.println();
			return enemyMage;
			
		case 3:
			System.out.println("A savage wolf appears!");
			Beast enemyBeast = new Beast("Savage Wolf", 50, 8, 6);
			System.out.println("It looks ready to rip you apart!");
			System.out.println(enemyBeast.displayInfo());
			System.out.println();
			return enemyBeast;
		}
		return null;
	}


}
