class Solution:
    def findTheDifference(self, s: str, t: str) -> str:
        count = [0] * 26

        for ch in s:
            count[ord(ch) - ord("a")] += 1

        for ch in t:
            count[ord(ch) - ord("a")] -= 1

            if count[ord(ch) - ord("a")] < 0:
                return ch
