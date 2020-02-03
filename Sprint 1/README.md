# Sprint 1
All information about the first sprint will be stored in this folder. Additionally, short summaries of our daily scrum meetings will be updated and stored below. [View our Trello board here.](https://trello.com/b/cFd1UodL/ac31007-agile-project)

---
## Day 1 (27/01/2020) - Scrum Meeting Summary (10am)
The Scrum Master for this meeting was **Neilson Desa**

### Members Present:
Neilson, Christian, Haonan, Finn, Archie, Ryan

### Members Not Present:
All members present

### Summary of Conversation:
The team currently has prioritised three main aims to get up and running first:
1. The google maps api with Java/Javascript - Neilson & Finn
2. The website with place holder UI for all the functionality that will be provided for searching procedures - Archie & Christian
3. The database which will host all the information about procedures - Ryan and Haonan

Today's focus is primarily on initliasing some base functionality for each of our aims and making sure they are stable and can be worked upon.

## Day 1 follow-up meeting (12:15pm)
Everyone was present for this meeting.

### Summary of Progress:
A jsp file was setup that was able to interface with the google maps api via javascript. A bootstrap for the front-end of the website was created. Both these changes were commited to the github. The database is currently in the midddle of transferring in the csv file's data.

### Summary of what we'll work on next
Haonan, Neilson, Ryan - Outlining Views and Procedures for the database, outlining methods for the Java code that connects to the Database.

Christian, Archie, Finn - Integrating the bootstrap html with the jsp file that contains the dynamic google maps. Add some basic functionality for adding and removing markers for specific hospitals.

---
## Day 2 (28/01/2020) - Scrum Meeting Summary (10am)
The Scrum Master for this meeting was **Neilson Desa**

### Members Present:
All members present 

### Summary of Conversation
The team concluded their current progress with the creation of the front-end website that contains the boostrap UI and google maps. The database was set-up with both the full data entries and some views and procedures to access the data in Java.

The current aims of the team for today's scrum are:
1. Getting the jsp web files (i.e. our website) hosted online and continue improving the UI and functionality.
2. Testing dummy data from a MySQL database in Java on the jsp files to practice for the real data.
3. Create search function for cost and distance in Java.

## Day 2 follow-up meeting (12:15pm)
Everyone was present for this meeting.

### Summary of Progress:
Jsp web files were hosted online via the University silva.computing.ac.uk domain with some of UI's drop-down, search bar and draggable scale being improved. The Java code was succesfully able to connect and run with the MySQL database when run locally. The database was setup on google servers via a quicker method; the original database is still in the process of uploading the full data, but partial entries for testing are available now.

### Summary of what we will work on next
Improving our functionality with the google maps api by letting the marker shown on the google maps represent the actual data entries from within the database is a primary objective; to accomplish this we must now work on linking the java code and database connection into the website files, as well as continue to populate the database with data and queries. 

---
## Day 3 (29/01/2020) - Scrum Meeting Summary (10am)
The Scrum Master for this meeting was **Neilson Desa**

### Members Present:
All members present

### Summary of Conversation
The team concluded their current progress with the creation of the basic search query for a procedure on a local Java application, as well as the key aspects of the database being populated. 

There was quite a few problems in each of our sections to do with:
1. A limited rate in which we could query the google api.
2. The Java code not functioning properly in the jsp file
3. The Java code was crashing the hosted website.
4. The distance matrix api was not functioning with our code.

Our objectives for today will be to fix our problems and work from them. Additionally we will continue to improve UI and the database's functionality & data entries.

## Day 3 follow-up meeting (12:15pm)
Everyone was present for this meeting.

### Summary of Progress:
The Java code now succesffully runs in the jsp file and connects with the MySQL database hosted on silva. The UI encompasses all core functionality that a user would need to search for procedures with reference to Cost, Distance and Rating. The database has received some refactoring with the splitting up of hospitals and procedures into seperate, full tables.

### Summary of what we will work on next
The team will begin to integrate the different sections of the front-end and back-end that haven't been fully joined. Additionally the team will work on finishing the core search function of hospitals by procedure in a basic form (this will enable us to build upon it as a team and add searching by cost, rating and/or distance). The team will continues to work on improving the problems that occur with the live-hosted website crashing during java code execution, and with coming up to a solution to solve our troublesome limited query rate with the google api (Only 10 requests allowed per second which is not ideal when searching hundreds of hospitals).

---
## Day 4 (30/01/2020) - Scrum Meeting Summary (11:30am)
The Scrum Master for this meeting was **Neilson Desa**

### Members Present:
All members present

### Summary of Conversation
The team concluded their current progress with the integration of the basic search procedure with the google maps api, database and front-end UI, all ran on a local server.

The aims for today are:
1. Fixing the limited query rate with the google api; our solution to this is to store the coordinates of each hospital in the database.
2. Fixing the java compilation error for the live website.
3. Adding the ability to remove markers on the map for multiple procedure searches.
4. Adding the ability to add a visual radius when doing the search medical procedure by distance.
5. Create the Java methods for searching by distance and by cost

## Day 5 (31/01/2020) - Scrum Meeting Summary (11:30am)
The Scrum Master for this meetgin was **Neilson Desa**

### Members Present:
All members present

### Summary of Converstaion
The team conlcuded their current progress with a demo-able application that, when run locally, could allow clients to search for procedures by a distance certain (appearing as a radius on the map). The SQL procedures for searchin by cost and rating were created.

The aims for today are:
1. storing longitude and latitude of each hopsital zipcode and passing them through to Java via a SQL procedure.
2. Preparing for the Sprint Review with the clients.
3. Fixing any compilation errors on the local host.
