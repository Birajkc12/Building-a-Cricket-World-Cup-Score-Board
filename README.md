
# Java MySQL Database Interaction

This Java program allows you to interact with a MySQL database for managing a cricket score table. You can view, insert, update, and delete records in the database. It's a console-based application that demonstrates how to connect to a MySQL database and perform basic CRUD (Create, Read, Update, Delete) operations.

## Prerequisites

Before using this program, ensure you have the following prerequisites:

Java Development Kit (JDK)
MySQL Server installed and running
MySQL Connector/JDBC driver (for connecting to MySQL)
A MySQL database named "cricket" with a table named "scoretable" having columns: ID, NAME, RUNS, BALLS

## How to Use

1. Compile the Java program:
   ```
   javac Main.java
   ```

2. Run the program:
   ```
   java Main
   ```

3. Follow the on-screen prompts to choose one of the following options:
View the scoreboard
Insert a new record
Update a record
Delete a record
Exit the program

## Options and Features

**View the scoreboard**: Displays the existing records in the "scoretable" of the "cricket" database.

**Insert a new record**: Allows you to add a new record to the "scoretable" by providing ID, player name, runs scored, and the number of balls faced.

**Update a record**: Update the runs and balls for a player in the "scoretable" by specifying the player's ID.

Delete a record: Delete a player's record from the "scoretable" based on the player's ID.

**Exit the program**: Terminates the program.

## Note

Make sure to replace the MySQL database connection details (e.g., database URL, username, and password) in the Java code if they are different from the default values used in this sample code.


## Author

- Biraj Kc
