Uber system design
Two types of users - riders and drivers

Driver
    - Frequently send current location to backend server
    - Should be notified when a nearby customer books a ride
Riders
    - Should be able to see drivers in nearby location
    - Book ride using pickup and destination
    - On ride completion, driver should be available for other customer

Common
    - Both rider and driver should be able to see each others location for the entire duration, once the ride has been booked

---

Capacity Estimation
- My system should be able to scale to any numbers of customers, so I am skipping capacity estimation for now. Lets do estimation in terms of x and y


### Storing drivers location [DriverLocationHT]
We will be storing drivers location in redis hashmap
Fields to represent a driver
- DriverId [3 bytes to represent 62^3 = 2,38,328 drivers]
- HashValue for location 8 bytes
- Lets limit list's length to 3

24 bytes of information per user
For one million online drivers we will be consuming 24*1M = 24MB cache

If we are getting location data every second we have DriverId + LocationData = 3 + 8 => 10B => 10MB data transfer for 1 million users every three seconds
i.e we need 3MBPS for driverLocationUpdate api


# Broadcasting drivers location
We can use a message broker to do that, for example we are trying to use vernmq right now

- Subscribe the customers to all drivers in the nearby location.
- On each update the drivers location will be broadcast to all subscribed customers

Network estimations for broadcasting drivers location
1 M customers per day


Lets assume 5 drivers subscribed to 1 customer. So traffic requirements
500K(active customers) * 5(fanout) = 2.5million requests per second

Every request is 19bytes => 47.5Mb/s



### Notification service
Compute distance between driver and rider using google distance matrix api / osrm, and once the driver is within 100meters distance, send out a push notification.



### Advanced issues
All services will have multiple instances and kubernetes manager will make sure that they are all functional

### Billing
Handle billing and refunds in case a ride is cancelled

### Implement machine learning components in the system

### Fraud detection




