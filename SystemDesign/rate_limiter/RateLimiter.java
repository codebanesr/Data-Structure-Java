// https://dev.to/satrobit/rate-limiting-using-the-sliding-window-algorithm-5fjn
@RequiredArgsConstructor
public class RateLimiter {
    int capacity, time_unit, cur_time;
    Callback forward_callback, drop_callback;

    RateLimiter(int capacity, int time_unit, Callback forward_callback, Callback drop_callback, int cur_time) {
        this.capacity = capacity;
        this.time_unit = time_unit;
        this.forward_callback = forward_callback;
        this.drop_callback = drop_callback;

        this.cur_time = new Date().getTime();
        this.pre_count = capacity;
        this.cur_count = 0;
    }


    /**
        if the current interval has expired, reset cur_count to zero and prev count to current count
        calculate estimated count, based on sliding window algorithm; 
        if estimated count is greater than, limit execute drop callback with the packet
        else execute forward callback passing the packet
    */
    public void handle(int packet) {
        // if the time between two consecutive packets
        // is more than window size, set cur_count = 0
        int clock_time = getTimePassedSinceTheNewTimer();
        if (clock_time > this.time_unit) {
            this.cur_time = new Date().getTime();
            this.prev_count = this.cur_count;
            this.cur_count = 0;
        }
        
        this.ec = this.pre_count * this.time_unit - (clock_time - this.curr_time) / time_unit + this.cur_time;
        if (ec > this.capacity) {
            this.drop_callback(packet);
            return;
        }


        this.cur_count += 1;
        return this.forward_callback(packet);
    }
}
