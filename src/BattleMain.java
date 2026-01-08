import java.util.Scanner;

public class BattleMain {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int playerWin = 0;
		int enemyWin = 0;

		
		while(true) {
		//BattleUI.separator("turn");   TO DO LATER FOR BATTLEUI
		//BattleUI.separator("victory");
		//BattleUI.separator("flee");
			
		Warrior warrior = new Warrior("Hero Warrior", 60, 10, 8, "Sword");
		Mage mage = new Mage("Arcane Mage", 45, 5, 40, 15);
		Beast beast = new Beast("Savage Wolf", 50, 8, 6);
		
		
		Creature player = CharacterSelect.chooseCharacter(scanner, warrior,mage,beast);
		if(player == null) {
			System.out.println("Exiting game...");
			break;
		}
		Creature enemy = CharacterSelect.chooseEnemy( warrior, mage, beast);

		System.out.println("Battle Begins! " + player.getName() + " VS " + enemy.getName());
		
		while(player.isAlive() && enemy.isAlive()) {
			boolean continueBattle = BattleTurn.playerTurn(player, enemy, scanner);
			if(!continueBattle) {
				System.out.println("You escaped the battle!");
				break;
			}
			
			System.out.println();
			
			System.out.println(player.getName() + ": " + player.getHealth() + " HP | "
			+ enemy.getName() + ": " + enemy.getHealth() + " HP\n");
			 System.out.println("--------------------------------------------");
			 
		}
		
		if (player.isAlive() && enemy.isAlive()) {
			
		} else if(player.isAlive()) {
			System.out.println("You defeated " + enemy.getName() + "!");
			playerWin++;
		 } else if(enemy.isAlive()) {
			 System.out.println("You fled the battle!");
		 } else { 
			 System.out.println(enemy.getName() + " Defeated you! Try again!");
			 enemyWin++;
		 }
		

		
		while(true) {
			System.out.println("Would you like to try again?(Y/N)");
			String choice = scanner.nextLine().trim();
			
		if(choice.equalsIgnoreCase("Y")) {
			System.out.println("================================================");
			System.out.println("Starting a new battle!");
			System.out.println("You have won " + playerWin + " times. The enemy has won " + enemyWin + " times.");
			System.out.println("================================================");
			break;
		} else if (choice.equalsIgnoreCase("N")){
			System.out.println("Goodbye!");
			return;	
		} else {
			System.out.println("Please enter either Y or N to continue.\n");
			
		}
		}
		
 
		
		
		}
		scanner.close();

	}

}
