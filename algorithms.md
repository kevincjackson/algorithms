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

## Important Powers of Two
| Power of 2 | Exact Value | Approx Value | Bytes Name | Common Type |
| - | - | - | - | - |
| 8 | 256 | - | byte | Byte, Char |
| 10 | 1024 | 1 k | 1 kilobyte |
| 16 | 65,536 | 4 k | 64 kilobyte | Short |
| 20 | 1,048,576 | 1 million | 1 megabyte |
| 30 | 1,073,741,824 | 1 billion | 1 gigabyte |
| 32 | 4,294,967,296 | 4 billion | 4 gigabye | Int, Float |
| 40 | 1,099,511,627,776 | 1 trillion | 1 terabyte |
| 48 | - | - | - |
| 50 | 1,125,899,906,842,624 | ? | 1 petabyte |
| 64 | 18,446,744,073,709,551,616 | 18 quintillion, 10^18 | - | Long, Double |

## Learning
- If you're stuck for 25 minutes on a problem, stop and look up the answer. You probably don't have domain knowledge. This will prevent you from being stuck for hours, when you just don't have the the knowledge you need. After you learn the answer, test yourself using timed intervals on your new knowledge.

## Writing Code
- Make sure to walk the code with concrete values. Pretend you are the compiler, parser, evaluator.

## Greedy Algorithms
- A greedy algorithm is one in which, an optimal move is made which reduces the main problem to a similar sub problem.
- Ideal for problems where initial knowledge is enough to make an optimal move. Not ideal for solutions which require different moves on sub problems.
- To make a greedy algorithm,
  - Make a greedy / optimal choice which reduces your problem to a sub-problem.
  - Iterate on your subproblem, until there is no problem left.

## Divide & Conquer Algorithms
- Break the problem into non-overlapping problems of the same type.
- Solve the subproblems.
- Combine the results.

## Dynamic Programming
- Storing results
  1. Top down is called memoization (memory)
  2. Bottom up is called tabulation.

## Recurrence Relation
- A sequence of values defined in terms of a recursive function
  - Ex) The naive recursive definition of Fibonacci numbers.
  - For divide and conquer algorithms the time of n is usually determined as a recurrence relation
    - Ex) T(n) = T(n-1) + c for Linear Search
  - In a recursion tree, you show the input n and the work as a column, along with all the subproblems.

## Questions

## Todo
- Be able to quickly write mergesort, quicksort, quicksort3, & insertionSort from scratch.
- Be able to write binarySearch from scratch.
- Do the trivium on the Master Theorem.
- Solve Majority Element using Divide and Conquer / Figure out the Conquer!

## Tips
- Insertions are slow. Prefer swapping in arrays (fast).
