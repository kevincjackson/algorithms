# What are five problems every programmer should be able to answer?

- Source: https://www.quora.com/What-are-five-problems-every-programmer-should-be-able-to-answer
- Zaki Shaheen, Softare Engineer at Yelp, Answered Aug 3, 2015
- I have interviewed 100s of people in last 4 years and have some typical questions - but the set is pretty large.
- Well, 5 is a pretty small number. But if I have to interview 1000 people for their programing abilities and I can only make a set of 5 questions (and assuming they are given a written test all at once), then it will contain the following questions:

1. Excel uses column names like A, B,C ... AA, AB, AC up to infinite. Write a function to convert the column name to its column index and vice versa.
2. Software is built around components and components have dependencies with each other. Write a function to calculate the compile sequence for a component X, given list of all components and their dependencies. (identify your own input format).
3. You are given a complete binary tree. We are augmenting the datastructure
to include a pointer \*next in node structure. It is supposed to point to the
node at the right. Write code to populate all next pointers. What if it is not a
complete binary tree?
4. Implement auto-complete like in the browser search bar.
5. Check if a given tree is a BST.

- First question is more of an 'adhoc' question but it basically tests the programmer's mathematics and warms up.
- Second question revolves around recursion and graphs (its essentially topological sort question).
- Third question is related to trees and recursion (or stack) and identifying edge cases.
- Fourth question is both a design question and DS/Algo question with a lot to talk about (even if they know I am going to ask this question, there is no way to win without being smart).
- Fifth question: 95% fresh grads get it wrong because of its devilish simplicity. Its merely not good enough to do it like we do inorder/postorder traversal. Think deep.
- Obviously, apart from the code of solution itself, I'm expecting time/space complexity and alternate methods to all these questions - but these are usually discussed in the interview.
- If you can solve these questions, I'll definitely hire you (after a cultural check, of course.) Now you know how to win my heart.
