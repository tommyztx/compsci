#!/usr/bin/env python3
# 
#
#    snow_flakes - a simple animation of snow flakes falling through 
#                  a black screen
#
#    Extra credit- How to change size of the screen
#                - How to change back ground color of the screen
#
#    Hint - Picking color from the pre-defined colors dictionary
#         - Use pre-defined functions(game_*)
#
#
#
#
#
#
#

import pygame
import random

colors = {
    'black'     : [  0,   0,   0],
    'aqua'      : [  0, 255, 255],
    'blue'      : [  0,   0, 255],
    'cyan'      : [  0, 238, 238],
    'gold'      : [255, 215,   0],
    'orange'    : [255, 128,   0],
    'red'       : [255,   0,   0],
    'pink'      : [255, 192, 203],
    'royalblue' : [ 65, 105, 225],
    'orchild'   : [218, 112, 214],
    'hotpink'   : [255, 105, 180],
    'indiared'  : [176,  23,  31],
    'green'     : [  0, 128,   0],
}

#    'beige' : [245, 245, 220],
#    'white' : [255, 255, 255],

boxsize = [500, 500]

snow_flakes = []

#
# PyGame - a libray of Python functions focus on programming games
#
#          
#
#
def game_start():
    
    # initialize game engine
    pygame.init()
    screen = pygame.display.set_mode(boxsize)

    return screen

def game_status():
    for event in pygame.event.get():
        if event.type == pygame.QUIT:
            return True
    return False


def game_stop():
    pygame.quit()



#
# fill up snow_flakes list with a random list of [x,y] coordinates 
#     with in the Box 
#
def create_snow_flakes(num):

    for i in range(num):
        x = random.randrange(0, 500)
        y = random.randrange(0, 500)
        snow_flakes.append([x,y])


#
# usage
#
def usage(progname):

    print('Usage: %s <setA-file> <setB-file> <merge|sub>' % progname) 

#
# main 
#
def main():

    screen = game_start()

    create_snow_flakes(75)

    clock = pygame.time.Clock()

    isDone = False

    back_color = 'black'
    num_ticks  = 0

    while isDone == False:

        isDone = game_status()

        if not num_ticks % 1000:
            back_color = random.choice( list(colors.keys()) )

        screen.fill(colors.get(back_color))

        for i in range( len(snow_flakes) ):
            pygame.draw.circle(screen, [255,255,255], snow_flakes[i], 2)
            snow_flakes[i][1] += 1

            if snow_flakes[i][1] > 500:
                y = random.randrange(-50, -10)
                snow_flakes[i][1] = y
                x = random.randrange(0, 500)
                snow_flakes[i][0] = x
        pygame.display.flip()
        clock.tick(20)
        num_ticks += 20
   
    game_stop()

if __name__ == "__main__":
    main()
