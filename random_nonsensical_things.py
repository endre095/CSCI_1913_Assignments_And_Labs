def count_vowels(word):
    count = 0
    vowel_list = "a,e,i,o,u,A,E,I,O,U"
    for char in word:
        if char in vowel_list:
            count += 1
    return count        

print(count_vowels("banana"))