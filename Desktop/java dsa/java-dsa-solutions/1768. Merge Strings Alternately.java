class Solution {
    public String mergeAlternately(String word1, String word2) {
        
        StringBuilder result = new StringBuilder();

        int i=0;
        while(i<word1.length()&& i<word2.length())
     {
        result.append(word1.charAt(i));
        result.append(word2.charAt(i));
        i++;

     }
     result.append(word1.substring(i));
     result.append(word2.substring(i));
     
     return result.toString();
    }
}