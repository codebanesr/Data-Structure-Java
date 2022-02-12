### Sliding Window [https://www.quinbay.com/blog/understanding-rate-limiting-algorithms]
A hybrid approach that combines the low processing cost of the fixed window algorithm, and the improved boundary conditions of the sliding log algorithm. Like the fixed window algorithm, we track a counter for each fixed window. Next, we account for a weighted value of the previous window’s request rate based on the current timestamp to smooth out bursts of traffic.


For example, if the current window is 25% through, then we weight the previous window’s count by 75%. The relatively small number of data points needed to track per key allows us to scale and distribute across large clusters.

![Alt text](/sliding_window.png?raw=true "Rate Limiter")