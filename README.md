#PRIME

####Pitching Release Information and Mechanics Evaluation
=====

PRIME is a visualization tool used to examine pitchers release points over time.  The 8 release point variables captured from Pitch F/X are x0, z0, vx0, vy0, vz0, ax, ay, and az.  Both averages and standard deviations are examined to determine where the pitcher is heading and how consistant they are at their delivery.  This type of analysis may helpful in a number of ways inluding:

* **Predicting Injuries** - As a pitcher become more irradict or perhaps the arm starts dropping it may indicate there is pain or an injury developing.  Also you can monitor changes in a delivery that may induce injuries in the future.
* **Finding Untapped Potential** - Perhaps a guy had an off year or has very inconsistant mechanics on a certain pitch that could be corrected.  This could help uncover those players.

PRIME includes a REST-ful API to a Pitch F/X database.  The API is used to grab a list of players, details on a player, and aggregate pitching stats for that player that are related to their release point.

PRIME also includes a front end written in AngularJS that utilizes this API and displays a player's stats as visual graphs.


## Build

**(1)** Get Apache Tomcat, MySQL, NPM, Grunt, and Bower.

**(2)** Visit [Baseball Heat Maps](http://www.baseballheatmaps.com/pitch-fx-download/) and download the Pitch F/X database.  Import it into your database.  You may need to update application.properties depending on your database configuration.

**(3)** Run database_changes.sql in the database you just created.

**(4)** Edit build.gradle to point to your Tomcat installation.  Run the deployToTomcat Gradle task.  This will copy a WAR to your Tomcat installation.

**(5)** From the client folder run grunt deploy-production or grunt deploy-dev depending on if you want the files compiled or not.


## What's Next

* Allow side-by-side player comparisons.
* Compare players to MLB averages.
* Monitor players in real time and create alerts when they are outside a threshold.
* Future datasources beyond Pitch F/X may allow the capture of more data at the release point of the ball.  Right now the Pitch F/X data used in PRIME is taken from 50' from the mound.  With more accurate data at the actual release point, a better analysis could be done.
