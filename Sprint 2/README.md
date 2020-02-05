# Sprint 2
All information about the first sprint will be stored in this folder. Additionally, short summaries of our daily scrum meetings will be updated and stored below. [View our Trello board here.](https://trello.com/b/cFd1UodL/ac31007-agile-project)

---
## Day 1 (03/02/2020) - Scrum Meeting Summary (10am)
The Scrum Master for this meeting was **Neilson Desa**

### Members Present:
All members present 

### Summary of Conversation
The team concluded their current progress with a successful Scrum Review that gave plenty of insight on how to improve this week's Sprint. This week's emphasis is on a much more active sprint backlog partcipation by each member of the team, as well as a more heavy focus on TDD.

The aims for today are:
1. Creating Java functions that call the SQL procedures that sort medical procedures based on highest cost and highest rating.
2. Creating coloured markers that represent different costs for procedures on the google map.
3. Updating the UI to reflect the changes covered in the Scrum Review (change names of the search button and shift searching to the homepage).
4. Creat Sprint Backlog for this week and begin process of updating it throughout week. 

---
## Day 2 (04/02/2020) - Scrum Meeting Summary (10am)
The Scrum Master for this meeting was **Neilson Desa**

### Members Present:
All members present

### Summary of Conversation
The team concluded their current progress with some of the tests for each of the procedures in SQL called through Java methods. Additionally the searh procedure by distance was updated to store longitude & latitude in the distance to bypass the query limit google's api provided. The UI has been updated to improve visability and to begin including the layout for doing sorts after a search. The cost of each procedure on the map now has a colour which reflects how expensive they are.

Todays aims are:
1. Changing the colour of the procedure markers on the map to reflect their costs.
2. Finishing the tests for the search procedure by distance and integrating it with the front-end.
3. Creating and finshing the tests for the two other procedures search via cost and rating.
4. Updating the UI to allow user to allow them to search by cost or ratings (instead of by distance - default option).

---
## Day 3 (05/02/2020) - Scrum Meeting Summary (10am)
The Scrum Master for this emeting **Neilson Desa**

### Members Present:
All members present

### Summary of Converstaion
The team concluded their current progress with the completion of Java Unit tests on all functions that called SQL procedures. Additionally, the hospital markers were colour coordinated to match the price of the procedure they offer, the front-ent had UI for sorting that connected to the backend, the backend had encapsulated the entire searching and sorting functioanlity for rating and cost into one Java functions, and the longtitude's and latitude's of each hospital were now stored in the database to bypass goodgle's query limit.

Aims for today:
1. Continue improving UI for ease of use and visibility.
2. Updating and finishing the functionality to restrict a search by distance and sort it by distance.
3. Integrating distance calculations from the backend with the front-end.
