
if __name__ == "__main__":
    nums = [5,3,7,1,9,89]
    
    def selection_sort(nums):
        for j in range(len(nums)-1):
            min = nums[j]
            for k in range(j+1, len(nums)):
                if nums[k] < min:
                    min = nums[k]
            list[j],list[min] = list[min], list[j]
        return list
    
    print(selection_sort(nums))
    assert nums == [1,3,5,7,9,89]