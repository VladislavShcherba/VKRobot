package wait;

import com.codeborne.selenide.Selenide;

public class EventWaiter {

    private static final long MAXIMUM_WAIT = 5000;
    private static final long POLL_INTERVAL = 500;

    private long maximumWait;
    private long pollInterval;

    public EventWaiter(long maximumWait, long pollInterval) {
        this.maximumWait = maximumWait;
        this.pollInterval = pollInterval;
    }

    public EventWaiter(long maximumWait) {
        this(maximumWait, POLL_INTERVAL);
    }

    public EventWaiter() {
        this(MAXIMUM_WAIT, POLL_INTERVAL);
    }

    public boolean waitFor(Event event) {
        long timeOfWait = 0;
        if(event.isOccurred()) {
            return true;
        }
        while(timeOfWait < maximumWait) {
            long sleep = Math.min(pollInterval, maximumWait - timeOfWait);
            Selenide.sleep(sleep);
            timeOfWait += sleep;
            if(event.isOccurred()) {
                return true;
            }
        }
        return false;
    }

}
