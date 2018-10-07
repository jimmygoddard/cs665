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

This application is organized using a layered architecture.  The client layer is
in the edu.bu.cs665.App.java class which makes use of the Chooser interface for user input.
The Chooser implementation makes calls against the Service layer.

It is in the Service layer where the business logic resides.  The Service layer then
interacts with the Data Access Object (DAO) layer which in turn makes calls to the
Persistence layer as needed.

I intentionally made the Persistence layer very thin so that the DAO and Service
layers would have a bit more functionality.  In a more realistic scenario, the 
Persistence layer would probably be an ORM like Hibernate.  The Application would
be able to make use of whatever database methods were appropriate: querying, updating,
inserting, etc.  This layered architecture makes such changes isolated to DAO and
would require minimal changes in the Service layer and above. Similarly, if there
were a need to implement a REST interface for this application, the changes would
be isolated to above the Service layer with minimal to no changes required for
the DAO layer and below.

I implemented each of the Service, DAO and Persistence layers as Singletons.  The 
main data object (DTO or Data Transfer Object) is the Employee which makes use
of a Builder to allow the user more flexibility when creating Employee objects.
The Employee object has many data members, which can be set as needed via the 
Builder.

I opted to use a random data generator for creating Employee objects to make 
user interactions with this app more convenient.  In a more realistic environment,
we would need another layer of prompts in the Chooser to prompt the user for what 
fields to set on the Employee.  Of course, it would be even more convenient if the
app would accept some simple structured input format (like CSV or JSON) to create
Employee objects.

The unit tests are all fairly straightforward and designed to isolate each method
in each layer to validate that they work as expected.  Each unit test has a javadoc
comment describing what steps are performed in the validation.