#! user/bin/env python3


barn_i = 0
barn_j = 0
rock_i = 0
rock_j = 0
lake_i = 0
lake_j = 0

i = 0
with open("buckets.in", "r") as fp:
    for s in fp:
        j = 0
        for j in range(0, 9, 1):
            if s[j] == "B":
                barn_i = i
                barn_j = j
            if s[j] == "R":
                rock_i = i
                rock_j = j
            if s[j] == "L":
                lake_i = i
                lake_j = j
        i = i + 1


dist_br = abs(barn_i - rock_i) + abs(barn_j - rock_j)
dist_bl = abs(barn_i - lake_i) + abs(barn_j - lake_j)
dist_rl = abs(rock_i - lake_i) + abs(rock_j - lake_j)

value = 0

if (((barn_i == lake_i) or (barn_j == lake_j)) and dist_bl == (dist_br + dist_rl)):
    value = dist_bl + 1
else:
    value = dist_bl - 1

with open("buckets.out", "w") as wp:
    wp.write(str(value))
    wp.write("\n")




