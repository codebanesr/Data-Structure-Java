### Functional requirements
Users should be able to add media
Users will be able to search for other users
Users should be able to follow other users
Users should be able to see other people's media in their feeds
Users should be able to chat with other people

### Non Functional requirements
System should be highly available
System should be eventually consistent
System should be highly reliable; any uploaded photo should never be lost

### SLA's - not required maybe

### Capacity planning
1M people coming over to instagram everyday
2 photo posts on an average => 2M photo uploads
average photo size 1MB

total space required for 1 day = 1MB * 2 * 1M => 10^6MB/1000GB => 1000GB
metadata will go into the database, based on which we can calculate the memory requirements.

20% of metadata size per day can be our memory requirement

### Schema Design
##### Photo
---
userid          int
photoPath       varchar(256)
photoLat        double
photoLon        double
userLat         double
userLon         double
creationDate    int

#### User
name, email, dob, created_at, last_login

#### UserFollow
userid1, userid2

### Api Design