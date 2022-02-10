### Add Job
if elevator is idle 
    add job directly
    set direction to whichever direction elevator should go
    set state to moving
else if: elevator is moving in opposite direction
    add to pending jobs
else if: elevator is moving in the moving up but user is below the currentfloor elevator is on
    add to pending jobs
else if: elevator is moving down but the user is on a floor above
    add to pending jobs


### Add to pending jobs
if user wants to go up
    upPendingJobs.add(request)
else 
    downPendingJobs.add(request)



### Start Elevator
while there are jobs in the current job queue:
    if currentDirection is up and state is moving
        processUpRequest
    else 
        processDownRequest

    if current job queue becomes empty:
    add pending jobs to queue;


### Add pending up jobs to current jobs list
if there are up pending jobs add them to the list
    update current direction and state
else 
    set current state to idle


