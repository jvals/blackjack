# Blackjack

## How to build
### Prerequisites
* JDK >= 1.8.0\_71
* Apache Maven >= 3.5.0

### Test
To perform the tests, run  
`mvn test`

### Compile
To compile the program, run
```
mvn package
java -cp target/blackjack-1.0-SNAPSHOT.jar app.Main
```

A random shuffled deck of cards is used if no command
line arguments are provided. A predefined deck of cards
can be supplied to the program like this:

`java -cp target/blackjack-1.0-SNAPSHOT.jar app.Main sampleInput.txt`

### Style
This codebase follows the [Google Style Guide](https://google.github.io/styleguide/javaguide.html).
Any contributions to this project should adhere to these rules.

`mvn verify` will fail if any violations has occurred.
To autofix any style related errors, run  
`mvn com.coveo:fmt-maven-plugin:format`


## About
This program simulates two players (Sam and the dealer)
playing a game of Blackjack. Both players draw two cards
at the start of the game. Both players know the value
of their hand at all times. Sam will draw cards from the
deck until his score is greater than or equal to 17.
After Sam is done drawing, the dealer will draw cards
until his score is greater than Sams score.
