import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

public class Main {

	private static User user = new User(100, 100, 100, 0, 0, 0, 0, 0);
	Scanner scan = new Scanner(System.in);

	Vector<Event> events = new Vector<>();
	Vector<Event> gatheringEvents = new Vector<>();
	
	Timer timer = new Timer(user, events);
	Thread myThread = new Thread(timer);
	
	
	public Main() {
		System.out.println("Maximoaxion");
		System.out.println("Press enter to continue");
		scan.nextLine();
		
		int inp = -1;
		do {
			System.out.println("1. Play\r\n"
					+ "2. Register\r\n"
					+ "3. Highscore\r\n"
					+ "4. How to play\r\n"
					+ "5. Exit\r\n"
					+ ">>");
			inp = scan.nextInt(); scan.nextLine();
			switch(inp) {
			case 1:
				login_func();
				break;
			case 2:
				register_func();
				break;
			case 3:
				highScore();
				break;
			case 4:
				System.out.println("This game goal is to survive as long as possible.\r\n"
						+ "However there will be disaster and event that will deal you damage.\r\n"
						+ "In order to survive you must gather resources, build shelter, and never go out at night.\r\n"
						+ "Goodluck! you gon need that\r\n"
						+ "\r\n"
						+ "Press [Enter] to continue..");
				scan.nextLine();
				break;
			}
			
		}while(inp != 5);
	}

	private void highScore() {
		// TODO Auto-generated method stub
		System.out.println("HighScore");
		System.out.println("juara 1 : T122 - Theo :)");
	}

	private void register_func() {
		// TODO Auto-generated method stub
		System.out.println("Input username");
		scan.nextLine();
		
		System.out.println("Input password");
		scan.nextLine();
		playGame();
	}

	private void playGame() {
		// TODO Auto-generated method stub
		inputEvents();
		timer.setEvents(events);
		
		myThread.start();
		
		int inp = -1;
		do {
			inp = scan.nextInt(); scan.nextLine();
			
			switch(inp) {
			case 1:
				gatherWood();
				break;
			case 2:
				buildShelter();
				break;
			case 3:
				huntFood();
				break;
			case 4:
				consumeFood();
				break;
			case 5:
				collectWater();
				break;
			case 6:
				drinkWater();
				break;
			case 7:
				gatherHerbs();
				break;
			case 8:
				useHerbs();
				break;
			}
			
		}while(inp != 0);
		
		scan.nextInt(); scan.nextLine();
		
		timer.stopTimer();
		
		try {
			myThread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	private void useHerbs() {
		// TODO Auto-generated method stub
		Random rand = new Random();
		int x = rand.nextInt(10) + 1;
		if(timer.getUser().getWood() < x) {			
			System.out.println("Not enough water!");
		}else {
			timer.getUser().setHerb(timer.getUser().getHerb()-x);
			timer.getUser().setHealth(timer.getUser().getHealth() + 10);
			System.out.println("You used " + x + " herb.\r\n"
					+ "You use the herbs you collected to make a healing potion and drink it.");
		}
	}

	private void gatherHerbs() {
		// TODO Auto-generated method stub
		Random rand = new Random();
		int x1 = rand.nextInt(5) + 5;
		timer.getUser().setHerb(timer.getUser().getHerb() + x1);
		
		int reduce = rand.nextInt(5);
		timer.getUser().setHunger(timer.getUser().getHunger() - reduce);
		timer.getUser().setThirst(timer.getUser().getThirst() - (5 - reduce));
		
		System.out.println("You obtained " + x1 + " herb.\r\n"
				+ "You search the area for herbs and find some useful plants.");
	}

	private void drinkWater() {
		// TODO Auto-generated method stub
		Random rand = new Random();
		int x = rand.nextInt(10) + 1;
		if(timer.getUser().getWater() < x) {			
			System.out.println("Not enough water!");
		}else {
			timer.getUser().setWater(timer.getUser().getWater()-x);
			timer.getUser().setThirst(timer.getUser().getThirst() + 10);
			System.out.println("You used " + x + " water.\r\n"
					+ "You take a drink of water and feel refreshed.");
		}
	}

	private void collectWater() {
		// TODO Auto-generated method stub
		Random rand = new Random();
		int x1 = rand.nextInt(5) + 5;
		timer.getUser().setWater(timer.getUser().getWater() + x1);
		
		int reduce = rand.nextInt(5);
		timer.getUser().setHunger(timer.getUser().getHunger() - reduce);
		timer.getUser().setThirst(timer.getUser().getThirst() - (5 - reduce));
		
		System.out.println("You obtained " + x1 + " water.\r\n"
				+ "You find a stream and collect some water in a container.");
	}

	private void consumeFood() {
		// TODO Auto-generated method stub
		Random rand = new Random();
		int x = rand.nextInt(10) + 1;
		if(timer.getUser().getWood() < x) {			
			System.out.println("Not enough food!");
		}else {
			timer.getUser().setFood(timer.getUser().getFood()-x);
			timer.getUser().setHunger(timer.getUser().getHunger() + 10);
			System.out.println("You used " + x + " food.\r\n"
					+ "You consume some food and feel your strength returning.");
		}
	}

	private void huntFood() {
		// TODO Auto-generated method stub
		Random rand = new Random();
		int x1 = rand.nextInt(5) + 5;
		timer.getUser().setFood(timer.getUser().getFood() + x1);
		
		int reduce = rand.nextInt(5);
		timer.getUser().setHunger(timer.getUser().getHunger() - reduce);
		timer.getUser().setThirst(timer.getUser().getThirst() - (5 - reduce));
		
		System.out.println("You obtained " + x1 + " food.\r\n"
				+ "You search the nearby area for food and manage to catch a rabbit.");
	}

	private void buildShelter() {
		// TODO Auto-generated method stub
		Random rand = new Random();
		int x = rand.nextInt(10) + 1;
		if(timer.getUser().getWood() < x) {			
			System.out.println("Not enough wood!");
		}else {
			timer.getUser().setWood(timer.getUser().getWood()-x);
			timer.getUser().setShelter(timer.getUser().getShelter() + 10);
			System.out.println("You used " + x + " wood.\r\n"
					+ "You use the wood and other resources you have to build a shelter.");
		}		
	}

	private void gatherWood() {
		// TODO Auto-generated method stub
		Random rand = new Random();
		int x1 = rand.nextInt(5) + 5;
		timer.getUser().setWood(timer.getUser().getWood() + x1);
		
		int reduce = rand.nextInt(5);
		timer.getUser().setHunger(timer.getUser().getHunger() - reduce);
		timer.getUser().setThirst(timer.getUser().getThirst() - (5 - reduce));
		
		System.out.println("You obtained " + x1 +" wood.\r\n"
				+ "You swing your ax and chop some wood from a nearby tree.");
	}

	private void inputEvents() {
		// TODO Auto-generated method stub
		Random rand = new Random();
		int x1 = rand.nextInt(5) + 1;
		events.add(new Event("Volcanic Eruption", "Neutral", "The ground is shaking and\r\n"
				+ "the sky is darkened by ash\r\n"
				+ "- a volcano has erupted!", x1));
		
		x1 = rand.nextInt(5) + 3;
		events.add(new Event("Massive Thunderstorm", "Neutral", "The sky is dark and\r\n"
				+ "lightning is striking\r\n"
				+ "everywhere - a massive\r\n"
				+ "thunderstorm is raging!\r\n"
				+ "", x1));
		
		x1 = rand.nextInt(3) + 1;
		events.add(new Event("Massive Bird Migration", "Neutral", "The sky is filled with birds\r\n"
				+ "of all kinds, moving in a\r\n"
				+ "massive migration.\r\n"
				+ "", x1));
		
		x1 = rand.nextInt(4) + 1;
		events.add(new Event("Massive Earthquake", "Day", "The ground is shaking\r\n"
				+ "violently and buildings are\r\n"
				+ "collapsing - a massive\r\n"
				+ "earthquake is underway!\r\n"
				+ "", x1));
		
		x1 = rand.nextInt(5) + 4;
		events.add(new Event("Solar Eclipse", "Day", "The sun is obscured by the\r\n"
				+ "moon, casting an eerie\r\n"
				+ "shadow on the world - it's\r\n"
				+ "a solar eclipse!\r\n"
				+ "", x1));
		
		x1 = rand.nextInt(1);
		events.add(new Event("Schorching Sun", "Day", "The sun is burning hot and\r\n"
				+ "the air is stifling - it's a\r\n"
				+ "scorching day"
				+ "", x1));
		
		x1 = rand.nextInt(5) + 5;
		events.add(new Event("Blood Moon", "Night", "The sun is burning hot and\r\n"
				+ "the air is stifling - it's a\r\n"
				+ "scorching day"
				+ "", x1));
		
		x1 = rand.nextInt(5) + 3;
		events.add(new Event("Massive Bats Invasion", "Night", "The sky is filled with\r\n"
				+ "swarms of bats, covering\r\n"
				+ "the world in darkness."
				+ "", x1));
		
		x1 = rand.nextInt(5) + 3;
		events.add(new Event("Alien Invasion", "Night", "Strange objects are falling\r\n"
				+ "from the sky and people\r\n"
				+ "are running in fear - it's an\r\n"
				+ "alien invasion!\r\n"
				+ "", x1));
		
		x1 = rand.nextInt(1);
		events.add(new Event("BlackOut", "Night", "The world is dark and\r\n"
				+ "silent, as a massive\r\n"
				+ "blackout has plunged\r\n"
				+ "everything into darkness\r\n"
				+ "", x1));
	
		events.add(new Event("Fall", "-", "It's too dark, you trip since you\r\n"
				+ "can't see clearly", 5));
	
		events.add(new Event("Wolf Attack", "-", "This is a wolf territory and\r\n"
				+ "they don't like intruders", 8));
	
		events.add(new Event("Shadow Attack", "-", "A figure attacks you from the\r\n"
				+ "dark", 15));
	}

	private void login_func() {
		// TODO Auto-generated method stub
		System.out.println("Input username");
		scan.nextLine();
		
		System.out.println("Input password");
		scan.nextLine();
		playGame();
	}

	public static void main(String[] args) {
		new Main();
	}

}
