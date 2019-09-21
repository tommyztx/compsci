#!/usr/bin/env python3
#
#
'''
define a variable list,list is an array of positive integers ordered from 1-10
in a sorted list, the list index starts at 0. write an algorithm to do a 
simple search of number 8 from
the list, returns the location of number 8 on the list if found, or error -1 if
not found.



var number_list=[1,2,3,4,5,6,7,8,9,10]
var int size_list=length(number_list)
var int index=1
While (number_list[index] != 8) {
    index+1
    if (index > size_list) then 
        break
}
if (index > size_list) then {
    print(-1)
}
else {
    print(index)
}

var number_list=[1,2,3,4,5,6,7,8,9,10]
var int index=1
While (number_list[index] != 8 and index < 11) {
    index+1
}
if (index > 10) then {
    print(-1)
}
else {
    print(index)
}
'''




#number_list=[1,2,3,4,5,6,7,8,9,10]
number_list=[1,5,23,17,56,33,67,78,89,10]
size_list=len(number_list)
index=0
while number_list[index] != 89:
    index += 1
    if index >= size_list:
        break

if index >= size_list: 
    print(-1)

else: 
    print(index)

