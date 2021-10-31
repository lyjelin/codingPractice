## Quick sort / Bubble Sort 설명

Quick sort is one example of divide-and-conquer sorting approach. It starts by choosing a pivot item from the given data structure, which is normally an array or list. Once the pivot item is selected, then the array is partitioned, rearranged into 2 sub-divided arrays where left subarray should contain the elements smaller than pivot item, while the right subarray should contain the element with bigger value than the pivot item. There will be an exchange of items if either there is item with greater value than pivot from the left array, or smaller item than pivot is found from the right subarray. Quick sort has average time complexity of O(nlogn), but it can increase to O(n^2) in worst case

Bubble sort is a comparison-based algorithm with time complexity of O(n^2) in any cases. It compares the adjacent neighbours throughout the loop and swaps item if they are not in order 

## Stack, Tree, Queue, Heap의 개념에 대해 설명할 수 있나요

Stack is a linear data structure which follows LIFO/FILO performance. It is usually used when we need to access data in reverse order of the arrival.
Queue is also linear data structure. It is example of Abstract Data Type like Stack. Queue follows FIFO order. Unlike Stack, we can access the least recently added data through queue (via enqueue)

Tree is a non-linear data structure, where each data, nodes, are connected by edges. There are several types of Tree structure, and I think the most commonly used one is Binary Tree. 

Heap is one type of Binary Tree structure. And there are 2 types of Heap; known as Min Heap and Max Heap. Min Heap has smallest element in its root node, and Max Heap has biggest valued element in its root node

Set - no duplicates, only one null value, random order
Map - Key-value pair, allow multiple null value while keys are unique 
Vector implements a dynamic array - similar to ArrayList but synchronised

Wrapper 클래스와 연관 - Generics mean parameterized types

## Briefly explain about HashTable

Hash table is one form of data structure that used to map key-value pair. The key is used to distinguish each value data, so it is important to prevent duplication of key as much as possible by using optimal hash function.

When there are 2 or more same key data, we say hash collision happen. There are 2 ways of solving this problem. 1) Open Addressing 2) Separate chaining

For Open Addressing, when the key from newly added key-value pair has same key as the exiting one in Hash Table, the newly added pair is stored in empty slot next to it, or additional hash function can be used.

For Separate chaining, the problem is solved by implementing a linked list structure. So basically, the two or more key-value pairs with same keys will form a linked list when hash collision occurs. Insertion or deletion can be done quick and fast as it inherits LinkedList’s feature.


## 데이터베이스의 index에 대해 설명해 주세요

Indexing is a data structure technique that allows user to quickly retrieve records from a database file. Index is small table having only two columns; The first column comprises a copy of the primary or candidate key of a table, and its second column contains a set of pointers for holding address of the disk block where that specific key value stored

## AVL Tree

AVL tree is a height-balanced tree, so they don’t allow trees to get skewed on one side. The time taken for all operations are O(h), where h stands for the height of the Tree. 
AVL tree helps this by restricting the height of the tree, and in doing so, it can keep the upper bound of time limitations of all the operations to be max O(log n), where n is the number of nodes

## Dynamic Data Structure 

It is a data structure that can extend and contract as a program runs. It provides flexible means of manipulating data as it can adjust according to the size of the data. 
Dynamic Data Structure is used to reduce time complexity of the code. 
Example is Linked List

## Huffman Algorithm

Huffman algorithm is one example of Greedy algorithm. It is well-known lossless data compressing method. Huffman code is variable-length encoding scheme for assigning binary codes depending on the frequency of characters occurring in a given text. The most frequently occurring character will have the smallest code, and the least frequently occurring character will have the largest code.
