# BoundedPriorityQueue

A priority queue that can only hold n elements (n is set at initialization). Implemented using Java's PriorityQueue class. When adding to the queue the element is added to the correct place but if the size of the queue is greater than n the element with the least priority is removed. Implements a fail-fast iterator that iterates through elements based on priority. Useful for implementing Nearest Neighbor queries in KD-trees and PR Quadtrees. 
