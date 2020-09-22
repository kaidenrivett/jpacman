# JPacman


## About

Pacman-like game used for teaching software testing.
It exposes students to the use of git, Gradle, JUnit, and mockito.

Parts of the code are well tested, whereas others are left untested intentionally. As a student in software testing, you can extend the test suite, or use the codebase to build extensions in a test-driven way. As a teacher, you can use JPacman to create your own testing exercises.

## Getting Started

### IntelliJ
1. Git clone the project
2. Open IntelliJ and create new project "from existing sources"
3. Select 'Gradle' in the following screen as external model, and click 'Next'
4. In the next screen, optionally adjust the Gradle options and click 'Finish'
5. To see JPacman in action: run `Launcher`
5. To run the test suite in IntelliJ: right click on a test or directory -> `Run` or `Run ...Test`

### Command line
1. Git clone the project
2. To see JPacman in action: `./gradlew run`
3. To run the test suite and static analysis tools: `./gradlew check`
    1. For tests only run `./gradlew test`
    2. For static analysis tools only run `./gradlew staticAnalysis`
	 
ANSWERS

Exercise 3: Why can’t we exhaustively test our entire software project? What should we do instead?

We are unable to exhaustively test our entire software project due to the fact that it could in some
cases take millions of years. If a software system has just 100 flags, that's a whopping 1+e30 
combinations that need to be tested. Instead of this, we can note that bugs aren't
uniformly distributed, and that a majority of the bugs in a system are located in one area.
By having a wide variation of testing in these places in the code, you have a better possibility
of detecting bugs.


Exercise 4: What is the pesticide paradox about and what does it imply to software testers?

The pesticide paradox refers to the technique of using the same tests over and over again in a
system. By doing this, the tests lose their effectiveness. This paradox implies that by no means 
is there a testing strategy that will allow you to find 100% of the bugs in a system. For every
method that you use to detect bugs, you will ultimately leave a trace amount of smaller bugs behind.


Exercise 5: Why should we automate, as much as possible, the test execution?

It is useful to automate the test execution because it saves software testers time.
This is because machines can go through a variety of steps much quicker than a human can, and 
this in turn provides quick feedback. As well as this, when test executions are automated, 
it can increase scoping of tests that improve the end result of the software quality. As well as this,
humans are prone to errors, by having test automation you will decrease the likelihood of small
errors in code.