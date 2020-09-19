#### What I did:
- Added boolean as return value for the operations saveEmployee, deleteEmployee and updateEmployee to check if the operation has been correctly performed
- Exceptions management on all the 5 operations
- Handling of null values for Spring JPA
- Added Spring Security for url protection
- Added Spring Cache for the caching logic of database calls
- Create Dto of Entity bean and expose it in the Controller, 
- Created ApiConfig
- Created documentation for the API: [https://github.com/nathantakahashi/alj-java-challenge/doc/index.html]
- ### Added Okta authentication and authorization with role: 
    - #### username: axademo@demo.demo 
    - #### password: axCoding1
    - #### secretAnswer: axaDemo
 
#### What I would have done
- Finish Unit test cases
- General bugfix


-------------------------------------------------------------------

### How to use this spring-boot project

- Install packages with `mvn package`
- Run `mvn spring-boot:run` for starting the application (or use your IDE)

Application (with the embedded H2 database) is ready to be used ! You can access the url below for testing it :

- Swagger UI : http://localhost:8080/swagger-ui.html
- H2 UI : http://localhost:8080/h2-console

> Don't forget to set the `JDBC URL` value as `jdbc:h2:mem:testdb` for H2 UI.



### Instructions

- download the zip file of this project
- create a repository in your own github named 'java-challenge'
- clone your repository in a folder on your machine
- extract the zip file in this folder
- commit and push

- Enhance the code in any ways you can see, you are free! Some possibilities:
  - Add tests
  - Change syntax
  - Protect controller end points
  - Add caching logic for database calls
  - Improve doc and comments
  - Fix any bug you might find
- Edit readme.md and add any comments. It can be about what you did, what you would have done if you had more time, etc.
- Send us the link of your repository.

#### Restrictions
- use java 8


#### What we will look for
- Readability of your code
- Documentation
- Comments in your code 
- Appropriate usage of spring boot
- Appropriate usage of packages
- Is the application running as expected
- No performance issues
