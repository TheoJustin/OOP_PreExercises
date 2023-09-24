public class DateUpdater implements Runnable {
    private static final Object lock = new Object();
    private Thread t;
    private String threadName;
    private boolean running;
    private boolean paused;
    private int day;
    private int month;
    private int year;

    public DateUpdater(String threadName, int initialDay, int initialMonth, int initialYear) {
        this.threadName = threadName;
        day = initialDay;
        month = initialMonth;
        year = initialYear;
        running = false;
        paused = false;
    }

    @Override
    public void run() {
        synchronized (lock) {
            while (running) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                if (!paused) {
                    day++;
                    if (day > 30) {
                        day = 1;
                        month++;
                        if (month > 12) {
                            month = 1;
                            year++;
                        }
                    }

                    System.out.println(threadName + "   " + day + "-" + month + "-" + year);
                }
            }
        }
    }

    public void start() {
        t = new Thread(this, threadName);
        t.start();

        if (t == null) {
            running = true;
        }
        running = true;
    }

    public void stop() {
        running = false;
        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void pause() {
        paused = !paused;
        System.out.println(threadName + " paused: " + paused);
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }
}
