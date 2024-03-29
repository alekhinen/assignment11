Assignment 11 - MyGradeBook
===========================
This is a gradebook system developed for CS3500: Object-Oriented Design. 

### Developers
- [Nick Alekhine](https://github.com/alekhinen)
- Chris Clark
- [Austin Colcord](https://github.com/ajdcolcord)
- Charles Perrone

### Technologies Used
- Eclipse IDE
- Java 6
- JUnit 4 Testing Library

### Interface
Need to work on this.

### Methods
- [x] initialize() AUSTIN
- [ ] initializeWithFile(String filename) !!!
- [ ] initializeWithString(String startingString)  !!!
- [ ] processFile(String filename) !!!
- [ ] processString(String additionalString) !!!
- [x] changeGrade(String assignmentName, String username, double newGrade) AUSTIN
- [x] average(String assignmentName) CHARLES
- [x] median(String assignmentName) CHARLES
- [x] min(String assignmentName) CHARLES
- [x] max(String assignmentName) CHARLES
- [x] getStudent(String username) NICK (need to throw exceptions)
- [x] currentGrade(String username) NICK
- [x] currentGrades() NICK (need to throw exceptions)
- [x] assignmentGrade(String assignmentName, String username) NICK (need to throw exceptions)
- [x] outputCurrentGrades() AUSTIN
- [x] outputStudentGrades(String username) AUSTIN 
- [x] outputAssignmentGrades(String assignName) AUSTIN
- [X] outputGradebook() AUSTIN

### Testing CheckList
#### MyGradeBookTest.java
- [ ] MyGradeBook AUSTIN
	- These both may be able to be covered in BlackBox Testing
		- [ ] initialize methods need to be tested CHARLES
		- [ ] processing methods need to be testing CHARLES
- [x] Course AUSTIN
- [x] Assignment AUSTIN
- [x] Student AUSTIN

#### BlackBoxTests.java
- [ ] MyGradeBook CHRIS


### Distribution of Work
#### Nick Alekhine
- Build User Interface
- Collaborate with Charles on file i/o
- Build several methods for Gradebook 
    - getStudent 
    - currentGrade 
    - currentGrades
    - assignmentGrades
- Quality Control with testing, commenting, and formatting

#### Charles Perrone
- Build file i/o 
- Parse files and text inputs
- Build several methods for Gradebook
    - Average
    - median
    - min
    - max

#### Austin Colcord
- Work on methods for Gradebook
    - changeGrade
    - all output methods
- Quality Control, Testing (WhiteBox - MyGradeBookTest.java)
- Student Comparator (by username)
- Linking MyGradebook to Gradebook
- Equals methods for all classes
- Hashcode methods for all classes

#### Chris Clark
- BlackBox Testing

### Task List
- Build the interface
- Build the file / text parser
- Finish all methods in Gradebook
- Test every method in Gradebook
- Create a readme
- Seperate interface and MyGradeBook into different packages


