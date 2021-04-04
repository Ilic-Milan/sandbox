# sandbox-htec

Environment:

- Linux 20.04
  
- java version minimum 1.8

Navigate to the root of project:

``~/{path}/sandbox``

Run tests locally with command in chrome:

``mvn clean test -Djava.util.logging.config.file=logging.properties``

Run tests locally with command in firefox:

``mvn clean test -Dbrowser=firefox -Djava.util.logging.config.file=logging.properties``

TestNG Reports are generated within ``target/surefire-reports/index.html``

Extend TestNG Reports are generated within ``target/surefire-reports/Extent.html``

Logs are generated within ``.logs/sandbox.log``



