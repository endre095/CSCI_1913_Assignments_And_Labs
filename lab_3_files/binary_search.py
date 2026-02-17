import random

def create_list(size):
    return_list = []
    for i in range(size):
        random_int = random.randint(0,50)
        return_list.append(random_int)
    return return_list


def binary_search(list, value):
    high = len(list)-1
    low = 0
    while low <= high:
        middle = (high-low)//2
        if list[int(middle)] == value:
            return middle
        elif value < list[int(middle)]:
            low = middle-1
        else:
            high = middle+1
    return -1

def bubble_sort(list):
    for i in range(len(list)-1):
        for j in range(len(list)-1 - i):
            if (list[j] > list[j+1]):
                temp = list[j]
                list[j] = list[j] + 1
                list[j+1] = temp
    return list

test = create_list(100)
print(test)
print(bubble_sort(test))