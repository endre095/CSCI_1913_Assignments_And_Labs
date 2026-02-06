def odd(list):
    count = 0
    for number in list:
        if number % 2 != 0:
            count += 1
    return count

input_list = [0,1,2,3,4,5,6]

print(odd(input_list))