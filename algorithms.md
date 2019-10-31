# Algorithms
## History
- Formalized by Church and Turing in the 1930's.
- Most algorithms have been discovered recently!
- Important algorithms are discovered by undergrads in algorithm courses!
- "I will, in fact, claim that the difference between a bad programmer and a
good one is whether he considers his code or his data structures more
important. Bad programmers worry about the code. Good programmers
worry about data structures and their relationships." - Linus Torvalds
- "Algorithms + Data Structures = Programs." - Niklaus Wirth

## Manual Testing
- Test with manual numbers.
- Test with large numbers to catch over flow errors.
  - Check numbers over 2^32 / ~2.1 billion / 2 * 10^9
  - Summary, check numbers of 2 billion.
- Test with lots of numbers to catch time limit errors.
  - A modern CPU runs about 10^9, or a billion operations / second.
  - A quadratic (slow) algorithm, checking a dataset of 10^5 (ten thousand),
    would have 10^10 operations, or 10 billion operations. That would take about 10 seconds.  
  - Summary: check with a dataset of 10,000.

## Stress Testing
- Test on two different implementations of an algorithm.
  - Test with random numbers to catch corner cases.
- Implementation:
  - Stress test should loop, and spit out the test data and OK if the test matches,
  or quit if it fails.

## Levels of Algo Desgin
1. Naive Algorithm:
  - Slow, definition based
2. Algorithm by way of Standard Tools
  - Use standard techniques
3. Optimized
  - Improve existing algorithm
4. Magic Algorithm
  - Requires unique insight
