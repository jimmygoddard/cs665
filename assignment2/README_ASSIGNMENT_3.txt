## Compile, Test and Run Application

Note: For assignment 3 I've added on to what I did for assignment 2.  The README has been renamed
to indicate which assignment it's appropriate for.  However, the jar is still named "assignment2"
even though it will contain the work done for assignment 3.

To compile on windows, rename the "gradle.properties.win" file to "gradle.properties" and edit that
file to point to the correct location of your Java installation.

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
I created an Accounting Module that performs both Accounts Payable as well as Accounts Receivable
functions.  There are a few new concepts in addition to Employees: Customers, Vendors, a Bank, Invoices,
and Services.

The Bank supports depositing and withdrawing amounts.  There is only one bank account and it supports
deposits and withdrawals.

Customers are objects from which the company receives money.  The company produces Invoices for customers.
Vendors are objects to which the company pays money for services.  Service objects represent the
services purchased from a vendor.  Also, Employees can run an expense account.  These expenses are
tracked using Invoices.

There are also two new interfaces which represent Accounts Payable and Accounts Receivable: the
Payable interface and the Receivable interface.  Vendors and Employees implement the Payable
interface as do Invoices and Line Items.  Customers and Services implement the Receivable interface.

I employed the Composite design pattern liberally in the new Accounting Module.  Also, the BankImpl
implements the Singleton.  Finally, I used a dependency injection pattern for the Accounting Service.
This allows for different Bank implementations to be used by the AccountingService.  For example,
if the BankImpl were to actually be connected to a real bank, a developer could implement (or use a
library like Mockito to generate) a Bank implementation that could be used for testing which did not
perform actions on an actual bank account.
