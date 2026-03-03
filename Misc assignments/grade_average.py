def calculate_class_average(list):
    total = 0
    count = 0
    for i in range(len(list)):
        for j in range(len(list[0])):
            total += list[i][j] 
            count += 1
    return round(total/count, 2)

gradebook = [
    [85, 92, 78, 90], # Student 1's grades
    [88, 76, 95, 82], # Student 2's grades  
    [90, 87, 93, 89], # Student 3's grades
    [72, 68, 84, 79]  # Student 4's grades
]

assert calculate_class_average(gradebook) == 84.25
