# Big O

## What
- A system which simplifies a mathematical equations down to the largest order.
- For example the equation `5x^2 + 3x + 5` would be described in Big Notation as `O(x^2)`
- O comes from German word *ordnung*, meaning order. It may be helpful to just think of Big O as "Show-me-the-largest-order Notation"


## Why
Big O is useful for approximating the speed or amount of space required for a computer solution.

For programmers understanding Big O concepts helps you write fast, efficient code.

## Who
- Paul Bachmann, German Mathematician
- Edmund Landau, German Mathematician
- Hardy and Littlewood, British Mathematicians
- Donald Knuth, American Computer Scientist

## Where
Germany, England, and the United States.

## When
- Paul Bachmann introduced the O symbol in 1894.
- Edmund Landau added the Big O Notation in 1909.
- Hardy and Littlewood added the Omega notation in 1914.
- Donald Knuth popularized the system in the 1970's and added the Theta notation.

## How
1. Add different steps
2. Drop constants
3. Drop non-dominate terms.
4. Do *not* drop different terms.

## Pronunciation
- O(1) is pronounced "big oh of one" or "oh of one".
- O(n^2) is pronounced "big oh of n squared" or "oh of n squared"


## Example Functions
Realistically, here are the possible answers

| Function | n=100 | Human Meaning |
| - | - | - |
| O(1) | 1 | constant time |
| O(log n) | 2 | less then linear growth |
| O(n^(1/2)) | 10 | less then linear growth |
| O(n) | 100 | linear growth |
| O(n log n) | 1000 | just above linear growth |
| O(n^2) | 10,000| quadratic Growth |
| O(n^3) | 1,000,000| polynomial Growth |
| O(2^n) | 10^30 | exponential growth |
| O(n!) | 10^57 | factorial growth |

Notice how quickly 2^n (exponential) and n! (factorial) run away from the rest.

## Max Inputs for 1 Second Runtime
| Function | Max Input |
| - | - |
| O(log n) | 10^(10^9) |
| O(n) | 10^9 |
| O(n log n) | 10^7.5 = ~ 30M |
| O(n^2) | 10^4.5 = ~ 30k |
| O(2^n) | 30 |
| O(n!) | 12 |


## Example
O(64) < O(log_8 n) < O(log_2 n) < O(4n) < O(n log_6 n) < O(n log_2 n) < 8n^2 < 6n^3 < 8^(2n)

## Logs With Different Bases Only Vary By A Constant
- log_2(n) is Big O, Big Theta, and Big Omega of log_8(n)
- Base Change Rule: log_a⁡(n) = log_b(⁡n) / log_b⁡(a)

## Examples
### O(1)
```py
def increment(i):
  return i + 1  # O(1)
```

### O(log n)
- Each iteration the amount of work is being cut by a factor (the log base)
- Signature:
  1. A loop
  2. Division where there would normally by the increment
- A `while` loop may be a tip off. For a simple incrementing variable typically a `for` loop would be used, but if you do something unusual, a `while` loop is more appropriate.


```java
// Java
int sumDigits(int n) {
    int sum = 0;

    // Loop with the variable n
    while (n > 0) {
      sum += n % 10;

      // The amount of work is divided by 10
      n /= 10;
  }

  return sum;
}
```
Here's the above, rewritten as a `for` loop
```java
int sumDigits(int n) {
    int sum;

    for (sum = 0; n > 0; n /= 10) {
      sum += n % 10;
    }

    return sum;
 }
```

```ruby
# Ruby
# arr must be a sorted array
# key is the value to be found
def binary_search (arr,key)  
    lo = 0
    hi = arr.length - 1

    while (lo <= hi)
        # The amount of work is divided by 10
        mid = lo + ((hi - lo) / 2)

        if arr[mid] == key
            return mid
        elsif arr[mid] < key
            lo = mid + 1
        else
            hi = mid - 1
        end
    end

    return nil
end
```

### O(n)
```py
def increment_array_elements(array):
  for i in array:
    i += 1
  return array
```

### O(n^2)
```
# Psuedocode
function f(array) {
  loop through array {
    loop through array {
        print something
    }
  }
}
```

### O(2^n)
Work increases for every iteration!
```c
// C
int f(int n)
{
    if (n <= 1)
    {
      return 1;
    }
    else
    {
      return f(n - 1) + f(n - 1)
    }
}
```

## Academic Note
- O (Omikron) means  <=. Upper bound
  - O(n) = O(n^2) = O(n^3) = O(2^n) All true (but not precise)
- Θ (Theta) Means =  Lower and Upper Bound are the same.
- Ω (Omega) means >=. Lower bound

What a computer scientist would call Big O, the mathematician would call Big Theta. For example, a simple print loop for an array would be described O(n) by a computer scientist, but's it's also correct to describe it as O(n^2) and O(n!) because it is *less than or equal* to those.  The computer scientist means Θ(n). This is a pedantic point though.

## Space Complexity
- An `n` element array would be described as `O(n) space`

## Example Table
| Big O | Name | Examples |
| - | - | - |
| O(1) | Constant | Stack push / pop, linked list insert |
| O(log n) | Logarithmic |Binary search of a sorted list |
| O(n) | Linear | Linear search, compare two strings |
| O(n log n) | Linearithmic | Merge sort, quick sort (expected case)|
| O(n^2) | Quadratic | Bubble, selection and insertion sort, traverse 2d array |
| O(n^k) | Polynomial | ? |
| O(k^n) | Exponential | n-Queens, Traveling salesman |

## Summing Integers
1 + 2 + 3 + ... n = O(n^2)

## Summing Powers of 2
2^0 + 2^1 + 2^3 + ... 2^n = 2^(n+1) -1
2^(n+1) - 1 = O(2^n)

## Basic Java
For-each loop
```java
public class Main
{
	public static void main(String[] args) {

        String fruits[] = { "apple", "banana", "cantaloupe" };

        // iterating over an array
        // : means in
        for (String fruit : fruits) {

            // accessing each element of array
            System.out.print(fruit + "\n");
        }

	}
}
```
## Exponent Review
- 2^2 * 2^3 = 2^5
- 2^(2n) = 4^n
- sqrt n = n^(1/2) = n^0.5
- 5^(log_2 n) = n^(log_2 5) = n^(~2.3)

## Main Logarithm Rules Common To Algorithm Problems
- Power Rule: log_a⁡(n^k) = k * log_a(⁡n)
- Product Rule: log_a⁡(n * m) = log_a(⁡n) + log_a(⁡m)
- n^(log_a⁡(b)) = b^(log_a⁡(n))
- Base Change Rule: log_a⁡(n) = log_b(⁡n) / log_b⁡(a)

## Helpful Videos
- <https://www.youtube.com/watch?v=XiGedDZGOM8&index=6&list=PLTd6ceoshprfdzLWovxULl8Lt7RAFKTe5>
- <https://www.youtube.com/watch?v=v4cd1O4zkGw>
- <https://www.youtube.com/watch?v=D6xkbGLQesk>
