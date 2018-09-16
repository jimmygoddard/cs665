## Compile, Test and Run Application

To compile on windows, edit the gradle.properties file to point to the correct
location of your Java installation.

To compile on Linux, rename or remove the gradle.properties file.  Gradle should
be able to locate your Java installation without specifically configuring the path.

Then run:

  > ./gradlew build

To run the application:

  > java -jar build/libs/assignment1.jar

To quit the application use Ctrl-C.

To run the unit tests: 

  > ./gradlew test

You can see the test results using Google Chrome (this is on Linux Mint, for other
operating systems or browsers navigate to the below listed index.html and open 
it in your browser of choice):

  > google-chrome build/reports/tests/test/index.html 

You can compile the javadocs using:

  > ./gradlew javadoc

The resulting documentation can be found in the build/docs/javadoc directory.

This assignment was created using IntelliJ.  The application and its tests can
also be run in IntelliJ.

## Project Description

This application has two main concepts: a Beverage Machine and the Beverages it
can produce.  The Beverage Machine is responsible for prompting the user and
manipulating the beverage being made according to the user's instructions.  The 
Beverage is the coffee or tea being made for the user.

Adding new beverages should be fairly simple in general.  New beverages would
need to implement the Beverage interface.

Only allowing milk or sugar for coffee did complicate this application.  Currently
the condiment management is contained within the Coffee object.  This makes adding
another beverage in the future that also takes condiments more difficult.

The overall application is quite simple with only four classes doing all of the work.

Implementing the Beverage Machine using a compositional pattern for the Beverages
helped mitigate having to duplicate code.  The machine can instantiate whatever
beverage it is preparing and manipulate it through the defined Beverage interface.
