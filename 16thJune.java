Smallest distinct window

Given a string 's'. The task is to find the smallest window length that contains all the characters of the given string at least one time.
For eg. A = aabcbcdbca, then the result would be 4 as of the smallest window will be dbca.

 

Example 1:

Input : "AABBBCBBAC"
Output : 3
Explanation : Sub-string -> "BAC"
  
  
Example 2:
Input : "aaab"
Output : 2
Explanation : Sub-string -> "ab"
  
 
Example 3:
Input : "GEEKSGEEKSFOR"
Output : 8
Explanation : Sub-string -> "GEEKSFOR"
 


Your Task:  
You don't need to read input or print anything. Your task is to complete the function findSubString() which takes the string  S as input and returns the length of the smallest such window of the string.


Expected Time Complexity: O(256.N)
Expected Auxiliary Space: O(256)

 

Constraints:
1 ≤ |S| ≤ 105
String may contain both type of English Alphabets.
------------------------------------------------------------------------------------------------------------------------------------------------------------------------

Code:

class Solution {
    public int findSubString( String str) {
        HashSet<Character>set=new HashSet<>();
        Map<Character,Integer>map=new HashMap<>();
        for(int i=0;i<str.length();i++){
            set.add(str.charAt(i));
        }
        int i=0;
        int j=0;
        int ans=str.length();
        while(i<str.length())
        {
            map.put(str.charAt(i),map.getOrDefault(str.charAt(i),0)+1);
            if(map.size()==set.size())
            {
                while(map.get(str.charAt(j))>1)
                {
                    map.put(str.charAt(j),map.get(str.charAt(j))-1);
                    j++;
                }
                ans=Math.min(ans,i-j+1);
            }
            i++;
        }
        return ans;
    }
}
