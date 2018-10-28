## Compile, Test and Run Application

Note: For assignment 3 I've added on to what I did for assignment 2.  The README has been renamed
to indicate which assignment it's appropriate for.  However, the jar is still named "assignment2"
even though it will contain the work done for assignment 3.

To compile on windows, edit the gradle.properties file to point to the correct
location of your Java installation.

To compile on Linux, rename or remove the gradle.properties file.  Gradle should
be able to locate your Java installation without specifically configuring the path.

Then run:

  > ./gradlew build

To run the application:

  > java -jar build/libs/assignment2.jar

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

