
##### Individual In-Class Assignment README Requirement



### Assignment Description
The objective of thsi assignment was to learn the jenkins piplines, understand docker, other testign tools and devops tools.


### Technologies & Tools Used


- Jenkins: Continuous Integration and pipeline automation.

- Git: Version control.

- GitHub: Source code repository.

- Java: Programming language, if required by the project.

- JUnit: Automated testing, if used.

- Docker: Containerization, if used.

- Maven: Building and managing Java dependencies, if used.


### Design Approach & Implementation Method

The assignemt introduces to use of a jenkins pipline to automate code testig.
The pipline can be configured to retrive sorce code form GitHub, install or resolve dependecies, bouild the application, run automated testign, and report the result. 

A jenkinfil can be used to define pipline stages as code. That makes tesign and buildign process eassier to repeat.

### Testing & Quality Assurance Steps

Testing was used to check whether the configured pipeline could execute its intended tasks.

1. Jenkins starts the pipeline = The pipeline starts successfully
2. Source code is retrieved = The correct repository is checked out
3. Build stage runsy = The application builds successfull
4. Automated tests run = Test results are reported
5. Pipeline finishes = The final build status is displayed


### How to Run

#### Prerequisites: 
* Git, Github repository containing the assignment
* Jenkins installed and running
* Any programming language runtime and build tools required by the project



#### Steps
1. Clone the repository: git clone <GITHUB_REPOSITORY_URL>
2. jenkins in yours browser http://localhost:8080
3. Create or open the Jenkins job configured for the repository.
4. Configure the repository URL and required build settings.
5. Run the pipeline using Build Now.
6. Open the build's Console Output to check each stage and identify errors.
7. Review the final build status and any available test reports.

