"""
Author: Andrew Endres (Worked individually)

//create_game_state(size, token_max)
//is_valid_move(game_state, row, takes)
//update(game_state, row, takes)
draw_game_state(game_state)
is_over(game_state)
"""

def create_game_state(size, token_max):
    state = list()
    if size == 0:
        return state
    for i in range(1,size+1,1):
        if i <= token_max:
            state.append(i)
        else:
            state.append(token_max)
    return state

#print(create_game_state(5,3))

def is_valid_move(game_state, row, takes):
    row = int(row)
    takes = int(takes)
    if row.isdigit() or takes.isdigit():
        return False
    if row > game_state.size():
        return False
    if takes > 3 or takes < 1:
        return False
    if takes > game_state[row-1]:
        return False
    else:
        return True
    
def update(game_state, row, takes):
    state = game_state
    state[row] -= takes
    return state

#print(update([5,3,4,1], 2, 3))
    
def draw_game_state(game_state):
    bar = "===================="
    hash = "#"
    line = ""
    print(bar) 
    for i in range(1,len(game_state)+1, 1):
        line += str(i * hash)
        print(i, print)
        line = ""
    print(bar)

draw_game_state([5,2,3,1])


