"""
Author: Andrew Endres (Worked individually)

Completed: 2/2/26 @ my home desk.
"""

#This function creates a game state by determing the size of the list required to 
#house the state information, and assigning values as neccesary to fill the list
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

#This function checks the validity of a move by checking if the location of the move
#within the state list and determining if the move will result in an unusable game-state
def is_valid_move(game_state, row, takes):
    if row.isdigit() == False or takes.isdigit() == False:
        return False
    row = int(row)
    takes = int(takes)
    if row < 1:
        return False
    if row > len(game_state):
        return False
    if takes > 3 or takes < 1:
        return False
    if takes > game_state[row-1]:
        return False
    else:
        return True
    
#This function copies the current state of the game, and changes this copy to reflect the move
#given in the function call, a deep copy is required to not just reference the pointer of the 
#previous state
def update(game_state, row, takes):
    state = game_state.copy()
    state[row] -= takes
    return state
#print(update([5,3,4,1], 2, 3))
    
#This function simply uses all given state information to draw the current state to the screen
#There is nothing explicitly changed in this function, (perhaps game_state should be constant?)    
def draw_game_state(game_state):
    bar = "===================="
    hash = "#"
    line = ""
    print(bar) 
    for i in range(0,len(game_state)):
        line += (hash*game_state[i])
        print((i+1), line)
        line = ""
    print(bar)

#draw_game_state([5,2,3,1])

#This function determines if the game is over by adding up all values of the game_state list, 
#if the sum is greater than zero then the game is not over
def is_over(game_state):
    total = 0
    for i in range(len(game_state)):
        total += game_state[i]
    if total == 0:
        return True
    else:
        return False


'''
Original authors: Daniel Kluver and Min Namgung
Changes by Adriana Picoral in Fall 2025

This is a PROGRAM that uses the nim code from nim.py.
It runs through a series of asserts and function calls
that will allow you to test if your code works the way we expect
'''

from nim import create_game_state, is_over, is_valid_move, draw_game_state, update

if __name__ == "__main__":
    print("Starting tests")

    assert create_game_state(0, 0) == []
    assert create_game_state(5, 5) == [1, 2, 3, 4, 5]
    assert create_game_state(4, 3) == [1, 2, 3, 3]
    assert create_game_state(7, 9) == [1, 2, 3, 4, 5, 6, 7]
    assert create_game_state(1, 1) == [1]
    assert create_game_state(1, 3) == [1]
    assert create_game_state(8, 4) == [1, 2, 3, 4, 4, 4, 4, 4]
    assert create_game_state(6, 1) == [1, 1, 1, 1, 1, 1]
    assert create_game_state(13, 9) == [1, 2, 3, 4, 5, 6, 7, 8, 9, 9, 9, 9, 9]

    print("Passed all create_game_state tests")

    state = [5, 4, 3, 2]
    assert is_valid_move(state, '1', '2') == True

    state = [8, 7, 6, 5, 4]
    assert is_valid_move(state, '5', '2') == True

    state = [4, 3]
    assert is_valid_move(state, '1', '1') == True

    state = [4, 3]
    assert is_valid_move(state, '3', '4') == False

    state = [5, 4, 3, 2]
    assert is_valid_move(state, '5', '4') == False

    state = [5, 4, 3, 2]
    assert is_valid_move(state, "a", "a") == False

    state = [5, 4, 3, 2]
    assert is_valid_move(state, "a", "2") == False

    state = [5, 4, 3, 2]
    assert is_valid_move(state, "1", "a") == False

    state = [5, 4, 3, 2]
    assert is_valid_move(state, "0", "1") == False

    state = [5, 4, 3, 2]
    assert is_valid_move(state, "4", "3") == False

    state = [5, 4, 3, 2]
    assert is_valid_move(state, "1", "4") == False
    
    state = [5, 4, 3, 2]
    assert is_valid_move(state, "3", "3") == True

    print("Passed all is_valid_move tests")

    state = [3, 2, 1]
    result = update(state, 2, 1)
    assert (state, result) == ([3, 2, 1], [3, 2, 0])

    state = [4, 3, 2, 1, 0]
    result = update(state, 3, 1)
    assert (state, result) == ([4, 3, 2, 1, 0], [4, 3, 2, 0, 0])

    state = [9, 8, 7, 6, 5, 4, 3]
    result = update(state, 6, 2)
    assert (state, result) == ([9, 8, 7, 6, 5, 4, 3], [9, 8, 7, 6, 5, 4, 1])

    state = [8, 7, 6, 5]
    result = update(state, 0, 3)
    assert (state, result) == ([8, 7, 6, 5], [5, 7, 6, 5])

    state = [5, 4, 3, 2, 1]
    result = update(state, 1, 1)
    assert (state, result) == ([5, 4, 3, 2, 1], [5, 3, 3, 2, 1])

    state = [4, 3, 2, 1]
    result = update(state, 1, 2)
    assert (state, result) == ([4, 3, 2, 1], [4, 1, 2, 1])
    
    print("Passed all update tests")

    print("Board drawing requires visual checking")
    state = [5,4,3,2,1]
    print("before call")
    draw_game_state(state)
    print("after call")
    # before call
    # ====================
    # 1 #####
    # 2 ####
    # 3 ###
    # 4 ##
    # 5 #
    # ====================
    # after call

    state = [5,4,3,4,1,0,0,9,1]
    print("before call")
    draw_game_state(state)
    print("after call")
    # before call
    # ====================
    # 1 #####
    # 2 ####
    # 3 ###
    # 4 ####
    # 5 #
    # 6
    # 7
    # 8 #########
    # 9 #
    # ====================
    # after call

    state = [1]
    print("before call")
    draw_game_state(state)
    print("after call")
    # before call
    # ====================
    # 1 #
    # ====================
    # after call

    assert is_over([0]) == True
    assert is_over([1,4,1,3,1,0]) == False
    assert is_over([0,1,2,3,2]) == False
    assert is_over([1,2,3,4,0]) == False
    assert is_over([0,0,0,0,0,0,0,0]) == True
    assert is_over([1,2,0,2,1,3]) == False

    print("Passed all is_over tests")




