#! user/bin/env python3

barn_i=0
barn_j=0
rock_i=0
rock_j=0
lake_i=0
lake_j=0

a=0
Farm=[0,0,0]
i=0
with open("buckets.in","r") as fp:
    for s in fp:
        j=0
        while j<10:
            if(s[j] == "B"):
                if Farm[0] == 0:
                    barn_i = i
                    barn_j = j
                    Farm[0] = 1
                else:
               	    print("More than one Barn on Map")
                    break
            if(s[j] == "R"):
                if Farm[1] == 0:
                    rock_i = i
                    rock_j = j
                    Farm[1] = 1
                else:
                    print("More than one Rock on Map")
                    break
            if(s[j] == "L"):
                if Farm[2] == 0:
                    lake_i = i
                    lake_j = j
                    Farm[2] = 1
                else:
                    print("More than one Lake on Map")
                    break
            j = j + 1
        if j < 10:
            break
        i = i + 1
    if i < 10:
        exit(1)
if sum(Farm) < 3:
    print("There is 1 or more missing from R,B,L")
    exit(1)

 
dist_br=abs(barn_i - rock_i)+abs(barn_j-rock_j)
dist_bl=abs(barn_i - lake_i)+abs(barn_j-lake_j)
dist_rl=abs(rock_i - lake_i)+abs(rock_j-lake_j)


# Barn is next to Lake
#
if dist_bl == 1:
    print("Barn can't be next to Lake")
    exit(1)

value=0

if (((barn_i == lake_i)or(barn_j == lake_j)) and dist_bl == (dist_br + dist_rl)):
   value = dist_bl+1 
else:
   value = dist_bl-1


with open("buckets.out","w") as wp:
    wp.write(str(value))
    wp.write("\n")
