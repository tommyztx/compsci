#! usr/bin/env python3

import sys

#
# Binary Search is an algorithm that splits the information using a mid point
# to find the specific data requested.
#
# This code uses Binary search to find <number> in a list of numbers.
#
# To run the program
#
#     % python3 binary_search.py <number>
#
#     where <number> can be any positive integer between the list of numbers
#     
#

Numbered_List = []

print(Numbered_List)

def quicksort(Numbered_List):
    if len(Numbered_List) <= 2:
        return Numbered_List
    else:
        pivot = Numbered_List[int((len(Numbered_List)-1)/2)]
        Numbered_List.remove(pivot)
        Less_Than = []
        Greater_Than = []
        for i in Numbered_List:
            if i <= pivot:
                Less_Than.append(i)
            elif i > pivot:
                Greater_Than.append(i)
        return quicksort(Less_Than) + [pivot] + quicksort(Greater_Than)
if len(Numbered_List) <= 2:
    print("List is already sorted")
    exit(1)
else:
    print(quicksort(Numbered_List)) 

