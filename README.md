![screenshot](https://raw.github.com/robnamahoe/surferpedia/master/doc/index.png)

Overview
--------
A dynamic Play application that provides an encyclopedia of surfers.

Installation
------------
NOTE: Must have MySQL configured and installed before proceeding.

**Configuration**
* Create environment variables for `SURFERPEDIA_ADMIN_EMAIL` and `SURFERPEDIA_ADMIN_PASSWORD` (ex. SURFERPEDIA_ADMIN_EMAIL=admin@example.com, SURFERPEDIA_ADMIN_PASSWORD=password). These will be the admin credentials to use to login.
* Create a database using MySQL, and create environment variables for `DATABASE_URL_DB` (database name), `DATABASE_USERNAME_DB` (username to access database), `DATABASE_PASSWORD_DB` (password to access database)

**Setup**
* Download the .zip file from GitHub
* Unzip and cd into the directory
* Invoke the Play console
* Execute the run command to see the application at http://localhost:9000.


Usage
-----
**Description**

The application includes 30 surfer profiles as well as an administrative user account.  Users can log in or create an account on the login page. NOTE: Users registered in the database have extended privileges than that of anonymous users.

**Searching**

Use the search widget located on the right side of the navigation bar to find bio information on surfers.  Search results can be curated by three criteria (surfer name, gender, and country).

![screenshot](https://raw.github.com/robnamahoe/surferpedia/master/doc/allsurfers.png)

**Registered Users**

From the the surfer bio page, you are presented with the option to either edit or delete the surfer from the database.

![screenshot](https://raw.github.com/robnamahoe/surferpedia/master/doc/surferbio.png)

New surfers can be added to the database by clicking 'New' in the navigation bar. Data validation is included to assist in including appropriate information.

![screenshot](https://raw.github.com/robnamahoe/surferpedia/master/doc/editerror.png)

Updates to the database can be viewed by clicking 'Updates' in the navigation bar.

Special Features
-----
Users can play a game called "Name This Surfer!" where they are presented with a picture of a surfer and given five names to choose from.  This encourages users to browse through our database in search of the "mystery surfer" and discover new surfers along the way.

![screenshot](https://raw.github.com/robnamahoe/surferpedia/master/doc/game.png)

An additional feature is the user profile page, where users can view all the activity related to their account.  They can keep track of surfer pages they've created and updated, as well as see the last 10 surfer pages they visited.

![screenshot](https://raw.github.com/robnamahoe/surferpedia/master/doc/profile.png)

ER Diagram
-----
![erd](https://raw.github.com/robnamahoe/surferpedia/master/doc/surferpedia-erd.png)
This ER diagram shows how the entities interact in order for the application to do several things:
* Search for surfers based on three filters: Name, Gender, Country
* Display a list of updates made to the database
* Display a list of updates made by each user
* Display a user's view history

The assumptions shown on the model include:
* A user can make no updates and view none of the surfer pages (but that's no fun, is it?)
* A Country and Gender does not exist in the database unless there is at least one surfer belonging to the country or gender.
* User and Surfer hold a many-to-many relationship that is represented by a PageView.

Credits
-------
[Eva Shek](https://github.com/evashek) and [Rob Namahoe](https://github.com/RobNamahoe) would like to thank ICS 341, Fall 2013, for support.