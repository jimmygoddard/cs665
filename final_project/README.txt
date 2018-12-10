## Compile, Test and Run Application

To compile on windows, rename the "gradle.properties.win" file to "gradle.properties" and edit that
file to point to the correct location of your Java installation.

To compile on Linux, rename or remove the gradle.properties file.  Gradle should
be able to locate your Java installation without specifically configuring the path.

Then run:

  > ./gradlew build

To run the application:

  > java -jar build/libs/final_project.jar

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
I created a Marketing Module to provide information and support for the sales functions of any company using our ERP software.

I moved Customer and Vendor storage into their own stores.  I also added Customer and Vendor services to allow clients to interact with each store.  The marketing module required a few extra fields in the Customer and Vendor objects which were fairly easy to add.  Also, I didn't realize until this last week's class that I have been using the Mediator behavioral design pattern throughout my assignments.  In this latest bit of work I use the Mediator to allow the Marketing Resource to access functioanlity in the Customer and Vendor stores.  Mediation is provided by the Marketing Service.  Also, the two new stores are both Singletons.