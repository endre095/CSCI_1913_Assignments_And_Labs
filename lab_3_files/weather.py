# Template file for Lab03 -- weather. By Peter Wang and Daniel Kluver
# Additions made by: Andrew Endres

# Import Statements
import csv  # imported for DictReader
import math  # imported for


# provided functions -- one handles some tedious loading details, and the other can help make sure you know what you're
# working with -- it's worth reading both carefully, and trying to learn from what you're seeing.


def load(filename):
    """load the CSV file by name, return list of dictionaries, each dictionary describes one row. of the file"""
    reader = csv.DictReader(
        open(filename), dialect="excel", skipinitialspace=True
    )
    return list(reader)


# provided function
def min_min_temp(file_list):
    """The input is a list of dictionaries like would be returned by the load function. The output is the minimum temperature
    observed in the dataset. We are tacitly assuming that the min temperature for a day is always below the max temperature
    """
    min_temp = math.inf
    for row in file_list:
        row_min_temp = float(row["Min_Temperature"])
        if row_min_temp < min_temp:
            min_temp = row_min_temp
    return min_temp

# Put your functions below this.


def F_to_C(f_temp):
    return 5*(float(f_temp)-32)/9


def F_to_C_file(file_list):
    for lists in file_list:
        print(lists["Max_Temperature"])
        lists["Max_Temperature"] = F_to_C(lists["Max_Temperature"])
        lists["Min_Temperature"] = F_to_C(lists["Min_Temperature"])
    print(file_list)

def clean(file_list, column):
    remove_set = {'T', 'M', 'S', 'A', ''}
    new_list = []
    for row in file_list:
        if row[column] not in remove_set:
            new_list.append(row)
        #print(repr(row[column]))

    return new_list


        


#print(load("test_file.csv"))
#cleaned_list = clean(load("test_file.csv"), "Precipitation")
#print("----------------------------")
#print(cleaned_list)

def average(file_list, column):
    average_list = clean(file_list, column)
    count = 0
    average = 0
    for list in average_list:
        #print(type(list[column]), list[column])
        count += 1
        average += float(list[column])
    return average/count

def total_rain_by_year(file_list):
    cleaned = clean(file_list, "Precipitation")
    totals = {}   
    counts = {}   
    for row in cleaned:
        year = int(row["Date"][:4])
        rain = float(row["Precipitation"])
        if year not in totals:
            totals[year] = 0
            counts[year] = 0
        totals[year] = totals[year] + rain
        counts[year] = counts[year] + 1
    averages = {}
    for year in totals:
        total_rain = totals[year]
        number_of_days = counts[year]
        avg = total_rain / number_of_days
        averages[year] = avg
    return averages


dictionaries = load("original.csv")
column = "Max_Temperature"
#print(dictionaries)
#print("---------------------------------")
#print(average(dictionaries, column))

print(total_rain_by_year(dictionaries))
##print(clean(dictionaries, "Precipitation"))