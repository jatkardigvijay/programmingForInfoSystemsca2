# How to run this application

Open fron-end folder using Visual Studio Code and run below command on terminal
-- ng serve --open

Then open Eclipse IDE run, main file(JavaBackendApplication.java)
also open Ms-SQL side by side for database for backend connection

# Unit Testing

Junit tests written for service layer in Java.
StudentServiceImplTest.java class run and test the APIs

# Individual Contribution

Febin Skariya worked on Front-end technologies:
--Angular(Typescript)
--bootstrap
- My role was to create the front end so I create it using Angular. Initially, I tried to create the project using vanilla JavaScript, but couldn’t succeed, because it’s easy to deal with there is no need to create a different HTML file for different sections. In Angular, I have created four different components for four sections such as student-list, create-student,update-student, and delete-student.
- Another reason to use Angular is it has an in-build router which makes it easy to develop the high-end project. In total, I have 21 commits to this project. Firstly, I created a student-list component and then later connected it to the back end using the service module. Then later added the routing component in app.component.specs.ts and added a navigation bar and footer in app.component.html.
- Next I created a component for create-student and then created create student form, later connected angular with create student api, before that I tested the api in Postman to check whether the api’s are valid. Created angular components on update and delete student.

vishalsingh as crystalsedge
--Technoloies Used
  Bootstrap
  HTML5
  CSS3
  JavaScript
  TypeScript
  Angular

Vishal Singh
- I created view-student component in angular using JavaScript and mainly TypeScript and using Web Technologies such as HTML5, CSS3 and Bootstrap. 
- Further I also created getStudentById REST Api and wrote controller, service and DAO(Database Access Object) layer for the same and tested it using REST client ie. POSTMAN.
- For the Webservice, application properties were researched and put into the respective files by me. 
- I wrote JUnit test cases for service layer considering both, the positive as well as the negative scenarios.


Digvijay Jatkar as jatkardigvijay
backend technologies:
--Java
--SQL
--Spring framework
--Hibernate/JPA as orm tool

Digvijay Jatkar
- As a group assignment, we built a Student Management System for CA2 of Programming and Information Systems. The technology stack used in this project was Core Java, MS-SQL, Spring Boot Framework, HTML, CSS, JavaScript, TypeScript, Angular.
- My role as an individual contributor (IC), was to create REST APIs in Java programming language.
- I used all the programming paradigms, the concepts of OOPS while building the APIs. After developing the REST APIs and connecting with the database, I tested them using POSTMAN as the rest client tool.
- Further, considering client can test the API, I also implemented SWAGGER UI in Java and ran it successfully. For the successful code coverage, I wrote Junit tests also for the service layer as per the industry standards and ran them successfully so that they can be measured while deploying the project using CI/Cd pipeline.


# Reference:
Angular Documentation Available at: https://angular.io/(Accessed: 08th December 2022)
Java Documentation Available at: https://docs.oracle.com/en/java/(Accessed: 22th November 2022)
Java Geeks for Geeks Available at: https://www.geeksforgeeks.org/reference-variable-in-java/ (Accessed: 25th November 2022)
Junit testing framework Available at: https://www.tutorialspoint.com/junit/junit_test_framework.html (Accessed: 14th December 2022)
Junit organization Available at: https://junit.org/junit4/ (Accessed: 14th December 2022)
Spring boot project Available at: https://spring.io/projects/spring-boot (Accessed: 22th November 2022)
Spring boot reference documentation Available at: https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/ (Accessed: 21th November 2022)

# Documentation:
API documentation written on each API. It is seen on Controller, each method has a written documentation.
5 Web services created. i.e. getAllStudents, getStudentById, DeleteStudent, UpdateStudent, InsertStudent
5 Client APIS created for the 5 web services.

