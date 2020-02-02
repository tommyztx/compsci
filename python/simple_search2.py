#! usr/bin/env python3

import random
import sys

#
# Simple Search is an algorithm searchs a list or a set of information in 
# a loop to locate an item.
#
# Find integer X in a list of random generated numbers, return its index 
# location or -1 if X is not in the list. X is provided as an argument 
# of the program.
#
# To run the program
#
#     % python3 simple_search.py <number>
#
#     where <number> can be any positive integer 
#

Numbered_List=[]

while len(Numbered_List) != 9:
    Rand_Num = random.randint(0, 100)
    if Rand_Num == sys.argv[1]:
        continue
    Numbered_List.append(Rand_Num)

Numbered_List.insert(random.randint(0, 9), sys.argv[1])

print(Numbered_List)

for i in range(0, 10, 1):
    if Numbered_List[i] == sys.argv[1]:
        index = i
        break

print(index)






