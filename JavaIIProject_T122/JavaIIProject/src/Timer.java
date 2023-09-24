import java.util.Random;
import java.util.Vector;

public class Timer implements Runnable{

	boolean running;
    private User user;
	int event_time;
	int event_percent;
	int event_idx;
	Vector<Event> events;
	
	public Timer(User user, Vector events) {
		// TODO Auto-generated constructor stub
		running = true;
		this.user = user;
		event_time = 0;
		event_percent = 5;
		event_idx = -1;
		this.events = events;
	}
	
	public int getEvent_time() {
		return event_time;
	}

	public void setEvent_time(int event_time) {
		this.event_time = event_time;
	}

	public int getEvent_percent() {
		return event_percent;
	}

	public void setEvent_percent(int event_percent) {
		this.event_percent = event_percent;
	}

	public int getEvent_idx() {
		return event_idx;
	}

	public void setEvent_idx(int event_idx) {
		this.event_idx = event_idx;
	}

	public Vector<Event> getEvents() {
		return events;
	}

	public void setEvents(Vector<Event> events) {
		this.events = events;
	}

	public void stopTimer() {
		running = false;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		int count = 0;
		while(running) {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			count++;
			event_percent += 1;
			
			Random rand = new Random();
			int event_going = rand.nextInt(100) + 1;
			
			if(event_percent >= event_going) {
				if(count <= 60) {
					event_idx = rand.nextInt(6);					
				}else if(count <= 120) {
					event_idx = rand.nextInt(7);					
				}
				
				if(count <= 120 && event_idx > 2) {
					event_idx += 2;
				}
				
				event_percent = 5;
				event_time = 10;
			}
			
			
			cls();
			System.out.printf("Day %d\n", count);
			if(event_time > 0) {
				Action.printEvent(events.get(event_idx));
				event_time--;
			}
			
			if(event_time == 0) {
				event_idx = -1;				
			}
			Action.printStatus(user);
	        Action.printActions();
		}
	}
	
	public boolean isRunning() {
		return running;
	}

	public void setRunning(boolean running) {
		this.running = running;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public static void cls() {
		for(int i = 0; i<10; i++) {
			System.out.println("");
		}
	}

}
