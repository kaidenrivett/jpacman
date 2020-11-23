# JPacman


## About

Pacman-like game used for teaching software testing.
It exposes students to the use of git, Gradle, JUnit, and mockito.

Parts of the code are well tested, whereas others are left untested intentionally. As a student in software testing, you can extend the test suite, or use the codebase to build extensions in a test-driven way. As a teacher, you can use JPacman to create your own testing exercises.



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





PART 2 Smoke Testing (2%) Jpacman

Exercise 4:
Execute the smoke test, with coverage enabled. Name 2 classes that are not well-tested, and explain why the smoke test does not cover it.

==> Two classes that are not well tested are the CollisionInteractionMap class, and the LevelFactory class. 
The smoke test does not cover the CollisionInteractionMap class very well because nowhere in the smoker test does it test 
pacman colliding with any of the ghosts. This is what leads to the 0% methods and 0% lines covered.
The smoke test does not cover the LevelFactory class very well either for the reason that the smoker test doesnt include 
pacman having the ability to eat the ghost and actually consuming one. The situation of having to spawn/creat another ghost
is never introduced in the smoker test, which causes the coverage of the LevelFactory class to be poor.



Exercise 5:
Have a look at class game.Game, method move. Is it covered by oursmoke test?Now, comment out the line in that method, which is invoking the move method from the Level class. Run thesmoke test again. Explain the failure you see, and explain to what extent you think the resulting test failure canbe helpful in fixing the system.

==> Before commenting out the line, the Game class have good coverage, with and 85% methods and 90% lines coverage.
After commenting out the line in the method that invokes the moving method from the Level class,
the Smoke test fails and we are given the warning that we were expecting a value that we did not receive.
We can also notice that the coverage of the class has gone down by a substantial amount, proving that our smoke test could include more tests to provide more coverage in a case like this.


Exercise 6:
Exercise 6 (0.5%): Undo the previous change, but now change board.Direction.getDeltaX so that it returns dy instead of dx.
Next, undo the changes you made, and ensure all tests pass again. Explain what you see. Was it easy to understand where the problem is?

==> After changing the getDeltaX return value to dy, it was obvious that the test had failed, however, I had not noticed a difference
in the method coverage or the line coverage for the Direction class. So in that case it can be rather hard to locate where the problem is laying.


Exercise 7:
Then, provide at most two paragraphs explaining how Game, Unit,Board, and Level classes are related to each other.

==> The similarity between these 4 classes is that they all have a reasonable amount of coverage from the smoker test.
This is most likely due to the fact that they are very general and important classes that are crucial to test in order to make sure the pacman game functions properly.




Lab 4 Understanding your tests
Tests can be divided into three parts: Arrange, Act, Assert (AAA). Let's discuss each of these parts. Answer any two of the following questions.

-   What can we do to avoid code repetition during the Arrange part of the unit test? 

To avoid code repetition in the Arrange part of the unit test, we can use the "@Before Each" annotation to signal that whatever is
inside the method block, it should be executed before each Test method. This cleans up a lot of the test code and decreases the amount of errors that could be produced by 
typing out what you want executed in each singular test case. Along with this, with every test thats run, everything inside the BeforeEach method will be freshly executed, which
will avoid the possibility of "weird" errors.


- JUnit and related libraries provide developers with different ways to do assertions. Some can be better than others in specific contexts.
Which one is a better assertion, supposing some int a? 1) assertEquals(1, a); or 2) assertTrue(1 == a)? Discuss the differences between both assertions.

The first assertion mentioned, assertEquals, asserts that two objects are equal and if they aren't the assertion error is thrown and 
a message is displayed showing the expected value and the actual value. The second assertion mentioned is assertTrue asserts that a 
particular condition is true, and if not, the assertion error is thrown, displaying only the particular condition that needs to be checked.
In my opinion, I think assertEquals is the better assertion to use, even with an integer because when the error is thrown, the error message is much more clear in what value it is looking for.


Lab 6 Testing Collisions

Exercise 2

- What is your opinion regarding achieving 100% code coverage? What are the advantages/disadvantages? How should one deal with such metrics, in your opinion?
This one should be easy?

Some of the advantages that are involved with 100% code coverage is that you have covered all of your code. However, this is not necessarily true because there will always be bugs in the code you are testing. A disadvantage 
to 100% code coverage is that it could take a long time to come up with 100% code coverage. Although it is very important to perform tests on code, it gets to a point where you may be spending too much time on testing it.
Ultimately, it depends on the type of testing you're doing which would make it more feasible to get 100% code coverage

- Our test suite is pretty fast. However, the more a test suite grows the more time it takes to execute. Can you think of scenarios (more than one) that can lead a single test (and eventually the entire test suite) to become slow? What can we do to mitigate the issue?

A possible scenario could be having all of your test cases in one class versus having them spread out. Having them all in the same class would cause the execution time to be much greater compared to having them in different classes. 
Another scenario that could cause an increase in execution time is the type of testing you are performing. E.g., if you are doing system testing, you have to have the entire system running and executing various tests. With unit testing 
you are only performing the various tests on a particular part of the system.


Lab 7 System Testing

Exercise 3

- Consider scenarios 2.4 and 2.5. Explain why it is harder to create system test cases(when compared to your previous experience with unit testing) for these scenarios.

Looking at scenario 2.4, it would be hard to create a
system test for this because the ghosts are AI and 
it is difficult to figure out in which direction they will go.
As for scenario 2.5, this would be difficult to create a 
system test for because it would be difficult to determine
whether all of the pellets are no longer on the map or not.


Exercise 5

- Answer the question in exercise 3 for User Story 3 (moving monsters).
As mentioned before, it is difficult to test the ghosts 
due to their unpredictable behaviour. It would also be 
difficult to determine the exact moment that a ghost 
would be covering a pellet or not.

