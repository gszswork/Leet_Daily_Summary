from _ast import List
'''
一个列表中有连续的sorted 数字，输出它们不重复的部分
建立一个双指针，一个表示前索引一个总长度，如果当前element与前一个一致，删除当前节点， length --
如果当前element与前一个节点不一致，i++ 扫描下一个
'''

class Solution:
    def removeDuplicates(self, nums):
        '''
        n = len(nums)
        for i in range(len(nums)):
            if i==0:
                continue
            print(i, ' ', i-1, nums[2])
            if nums[i] is nums[i-1]:
                print("what's wrong")
                nums.pop(i)
        '''
        i = 0
        n = len(nums)
        while i<n:

            if i==0:
                pass
            elif nums[i] == nums[i-1]:
                nums.pop(i)
                n -= 1
                continue
            i += 1





list = [0,0,1,1,1,2,2,3,3,4]
sol = Solution()
sol.removeDuplicates(list)
print(list)