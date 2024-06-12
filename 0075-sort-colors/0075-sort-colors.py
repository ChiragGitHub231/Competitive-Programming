class Solution:
    def sortColors(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        zero_num = 0
        one_two_num = len(nums) - 1
        
        i = 0
        while i <= one_two_num:
            if nums[i] == 0:
                nums[i], nums[zero_num] = nums[zero_num], nums[i]
                zero_num += 1
                i += 1
                continue
            if nums[i] == 2:
                nums[i], nums[one_two_num] = nums[one_two_num], nums[i]
                one_two_num -= 1
                continue
            i += 1
        return