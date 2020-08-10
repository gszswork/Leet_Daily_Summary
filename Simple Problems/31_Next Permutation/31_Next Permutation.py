from _ast import List
'''
    非常经典的问题，当时帮pyq笔试时候遇到过：将给定数字序列重新排列成字典序中下一个更大的排列(下一个，更大）
    思路： 1. i 从右向左找 nums[i-1] < nums[i],就说明nums[i-1]至少比nums[i:]中一个小，定j=i-1
    2. 从nums[i:]中找到比nums[j]大的最小的数，从右往左搜到比nums[j]大的就是, 定k
    3. 交换nums[j]和nums[k]，交换后对nums[i:]部分进行一个排序
    
    '''
class Solution:
    def nextPermutation(self, nums):
        n = len(nums)
        for i in range(n-1, 0, -1):
            j = i-1
                if nums[i] > nums[j]:                       # Note 1
                    #swap
                    for k in range(n-1, j, -1):
                        if nums[k] > nums[j]:               # Note 2
                            temp = nums[k]
                            nums[k] = nums[j]
                            nums[j] = temp
                            break
                
                    res = nums[i:]
                    res.sort()                              # Note 3
                    for k in range(len(res)):
                        nums[k+i] = res[k]
            
                            return

    nums.reverse()

