class Solution:
    def mergeAlternately(self, word1: str, word2: str) -> str:
        result = ""

        i = 0


        while i < len(word1) and i < len(word2):
            result += word1[i]
            result += word2[i]
            i += 1

        result += word1[i:]
        result += word2[i:]
        
        return result
        
class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        
        n = len(haystack)
        m = len(needle)

        for i in range(n - m + 1):
            
            if haystack[i:i+m] == needle:
                return i

        return -1