# Ride Sharing

Implement a ride-sharing application with the below-expected features.

### Features

1. The application allows users to share rides on a route.
2. Users can either offer a shared ride (Driver) or consume a shared ride (Passenger).
3. Users can search and select one from multiple available rides on a route with the same source and destination.

### Requirements

1. add_user(user_detail) - Add basic user details
2. add_vehicle(vehicle_detail) - Add the user’s vehicle(s) details
3. offer_ride(ride_detail) - User should be able to offer a shared ride on a route with details. Ride will have details like vehicle, origin, destination, available seats. (A ride will have no intermediate stops.)
4. select_ride(source, destination, seats, selection_strategy) - Users can select a ride from multiple offered rides using a selection strategy. (A user can only request a ride (only for 1 or 2 people))
   - selection strategies - Preferred Vehicle (Activa/Polo/XUV), most vacant.
5. end_ride(ride_details) - System should be able to end the ride. User can only offer a ride for a given vehicle, once there are no active offered rides for that vehicle.
6. print_ride_stats() - Find total rides offered/taken by all users.
7. [BONUS] If the user’s origin/destinations are not available directly but it’s possible via multiple rides, then the application should output multiple rides (Example: for input: Bangalore to Mumbai, the output can be Bangalore to Goa and Goa to Mumbai)

### Expectations

1. Write a driver class for demo purposes. Which will execute all the commands in one place in the code and test cases.
2. Do not use any database or NoSQL store, use in-memory data-structure for now.
3. Do not create any UI for the application.
4. Please prioritize code compilation, execution, and completion.
5. Work on the expected output first and then add good-to-have features of your own.
6. Make sure that you have a working and demonstrable code.
7. Make sure that the code is functionally correct.
8. Use of proper abstraction, modeling, separation of concerns is required.
9. Code should be modular, readable and unit-testable.
10. Code should easily accommodate new requirements with minimal changes.
11. Proper exception handling is required.

### Testcases

1. > ADDU RAM <br>
   > ADDU SHYAM <br>
   > ADDU GYAM <br>
   > ADDU DHYAM <br>
   > ADDU LYAM <br>
   > ADDU GAUX <br>
   > ADDV RAM 100 HATCHBACK 4 <br>
   > ADDV SHYAM 200 SUV 4 <br>
   > ADDV GYAM 300 SEDAN 2 <br>
   > OFFER RAM INDIA PAKISTAN 100 <br>
   > OFFER SHYAM PAKISTAN AMERICA 200 <br>
   > OFFER GYAM AMERICA NEPAL 300 <br>
   > OFFER GAUX INDIA AMERICA 400 <br>
   > BOOK DHYAM INDIA PAKISTAN 2 <br>
   > BOOK LYAM AMERICA NEPAL 1 <br>

2. > ADDU RAM <br>
   > ADDU SHYAM <br>
   > ADDU GYAM <br>
   > ADDU DHYAM <br>
   > ADDU LYAM <br>
   > ADDV RAM 100 HATCHBACK 4 <br>
   > ADDV SHYAM 200 SUV 4 <br>
   > ADDV GYAM 300 SEDAN 2 <br>
   > OFFER RAM INDIA PAKISTAN 100 <br>
   > OFFER SHYAM PAKISTAN AMERICA 200 <br>
   > OFFER GYAM AMERICA NEPAL 300 <br>
   > BOOK DHYAM INDIA AMERICA 2 <br>

## Reference

1. [GeeksForGeeks - Ride Sharing](https://www.geeksforgeeks.org/flipkart-machine-coding-round-experience/)
