# sandbox-htec

Environment:

- Linux 20.04
  
- java version minimum 1.8

Navigate to the root of project:

``~/{path}/sandbox``

Run tests locally with command in chrome:

``mvn test -Djava.util.logging.config.file=logging.properties``

Run tests locally with command in firefox:

``mvn test -Dbrowser=firefox -Djava.util.logging.config.file=logging.properties``

Reports are generated within ``target/surefire-reports/index.html``

Logs are generated within ``.logs/sandbox.log``



