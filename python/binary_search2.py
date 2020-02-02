#! usr/bin/env python3

import random
import sys

#
# Simple Search is when the algorithm searchs a list or a set of information by
# one or in terms of O time O=n
#
# 
#
#
# This code will use an integer argument to put into a randomly generated list
# of 9 items (plus the argument) and find the index number of the integer.
#
# To run the program
#
#     % python3 simple_search.py <number>
#
#     where <number> can be any positive integer to indicate the size of 
#     the list of numbers
#

Numbered_List=[]

for i in range(0, 10, 1):
    Rand_Num = random.randint(0, 10)
    if Rand_Num in Numbered_List == True:
        continue
    Numbered_List.append(Rand_Num)

print(Numbered_List)

value = int(sys.argv[1])

value2 = sys.argv[1]

min = 0

max = len(Numbered_List)

mid = int(((max - min) / 2) + min)

while value != Numbered_List[int(mid)]:
    if value < Numbered_List[int(mid)]:
        max = mid
        mid = int(((max - min) / 2) + min)
    elif value > Numbered_List[mid]:
        min = mid
        mid = int(((max - min) / 2) + min)
print(mid)
