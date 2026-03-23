'''def get_average(list):
    if len(list) == 0:
        return 0
    sum = 0
    for num in list:
        sum += num
    return sum/float(len(list))



numbers = [1, 2, 3, 4, 5, 6]
assert get_average(numbers)  == 3.5

assert get_average([]) == 0 # empty list'''

def adjust_grades(list):
    for i,grade in enumerate(list):
        if (grade > 60):
            remainder = grade % 5
            print(remainder)
            if (5-remainder) < 1:
                list[i] = grade + (5-remainder)
    return list

spring_2026 = [59.7, 69.6, 64.5, 73, 79, 79.5, 84.1]
print(adjust_grades(spring_2026))
assert spring_2026 == [59.7, 70.0, 65.0, 73, 79, 80, 85]