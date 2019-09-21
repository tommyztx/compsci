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

x = 0

def sum(x):
    if x == len(Numbered_List):
        return 0
    else:
        return Numbered_List[x] + sum(x+1)
total = Numbered_List[x] + sum(x+1)
print(total)
