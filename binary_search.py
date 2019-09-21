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

Numbered_List = [1,2,3,4,5,6,7,8,9,10]

print(Numbered_List)

value = int(sys.argv[1])

min = 0

max = len(Numbered_List)

mid = int((max - min) / 2.0 + min)

#print(type(mid))

if value <= int(min) or value > int(max):
    print(-1)
    exit(1)

while value != Numbered_List[mid]:
    if int(value) < Numbered_List[mid]:
        max = mid
        mid = int(((max - min) / 2) + min)
    elif int(value) > Numbered_List[mid]:
        min = mid
        mid = int(((max - min) / 2) + min)
print(mid)
