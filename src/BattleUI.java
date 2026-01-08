public class BattleUI {

    public static void separator(String type) {
        switch (type.toLowerCase()) {
            case "turn":
                System.out.println("———— ⚔ TURN END ⚔ ————");
                break;

            case "victory":
                System.out.println("🌟✨ Victory! ✨🌟");
                System.out.println("══════════════════════════════════════════════");
                break;

            case "flee":
                System.out.println("💨 You’ve escaped safely! 💨");
                System.out.println("══════════════════════════════════════════════");
                break;

            case "magic":
                System.out.println("🔮 The mana shield flashes, reflecting the attack! 🔮");
                break;

            case "counter":
                System.out.println("🐾 Savage counterattack! 🪓");
                break;

            default:
                System.out.println("--------------------------------------------");
        }
    }
}