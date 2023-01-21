### Postman Collections Exercise ###

Use [Postman](https://www.getpostman.com/apps) to make interact with a REST application that
provides CRUD operations on an Employee domain object. Data should be sent and received in JSON
format.

To run this project locally:

1. Create a new folder on your desktop called "postman-collections".
2. Download
   the [REST application](https://drive.google.com/open?id=1spshO056sA_A6NnHxHVuw-NNOk8qI_jH) you
   will use for this exercise and save it in the folder you just created.
3. Open Git Bash and change directories to the folder you just created by
   typing `cd ~/Desktop/postman-collections/`
4. Start the application by typing the following into Git Bash `java -jar postman-collections.jar`
5. Use Postman to interact with the REST application according to the table below.

#### Instructor Notes ####

Jar file was created using Maven. To recreate the jar file, click "Execute Maven Goals"
from the Maven window and select mvn install.

A complete jar file will be created in the target folder.

#### Employee API ####

| If you want to... | Use this method... | And this URI... |
| --- | ---| --- |
| Create an employee record | POST | http://localhost:8080/employees |
| Read all employee records | GET | http://localhost:8080/employees |
| Read an employee record by id | GET | http://localhost:8080/employees/{id} |
| Read employee records by their last name | GET | http://localhost:8080/employees/search?lastname={name} |
| Update an employee record | PUT | http://localhost:8080/employees/{id} |
| Delete an employee record | DELETE | http://localhost:8080/employees/{id} |

**NOTE**: There are four records in the database when the application is first started.

#### Employee Domain Object ####

The Employee object has the following properties:

* **id**. Number. The unique identifier for a record in the database. The id is auto-generated, so
  you do not need to include it when creating a new employee.


* **firstName**. String. The employee's first name.


* **lastName**. String. The employee's last name.


* **departmentCode**. Number. A number greater than 0 representing a department within the company (
  IT, sales, development, etc.)


* **officeLocation**. String. The city where the employee's office resides.

Example JSON object to use when creating an Employee record:

````
{
  "firstName": "Jane",
  "lastName": "Doe",
  "departmentCode": 34,
  "officeLocation": "Chicago"
}
````