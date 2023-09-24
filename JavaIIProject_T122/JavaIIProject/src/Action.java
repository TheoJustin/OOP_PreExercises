class Action {
    public static void printStatus(User user) {
        System.out.printf("Health : (%d%%)\n", user.getHealth());
        System.out.printf("Hunger : (%d%%)\n", user.getHunger() );
        System.out.printf("Thirst : (%d%%)\n", user.getThirst());
        System.out.printf("Shelter: (%d%%)\n", user.getShelter());
        System.out.println("Resources:");
        System.out.println("- Wood: " + user.getWood());
        System.out.println("- Food: " + user.getFood());
        System.out.println("- Water: " + user.getWater());
        System.out.println("- Herb: " + user.getHerb());
        System.out.println();
    }

    public static void printActions() {
        System.out.println("Actions:");
        System.out.println("1. Gather wood");
        System.out.println("2. Build shelter");
        System.out.println("3. Hunt for food");
        System.out.println("4. Consume food");
        System.out.println("5. Collect water");
        System.out.println("6. Drink water");
        System.out.println("7. Gather herbs");
        System.out.println("8. Use herbs");
        System.out.println("Enter 0 to unpause");
    }
    
    public static void printEvent(Event event) {
    	System.out.println(event.getMessage());
    }
    
    public static void cls() {
    	for(int i = 0; i<10; i++) {
    		System.out.println("");
    	}
    }
}