/* STACKS & QUEUES                                                           Date: 16-July-2021
Given a string A denoting a stream of lowercase alphabets. You have to make new string B.

B is formed such that we have to find first non-repeating character each time a character is inserted to the stream and append it at the end to B. If no non-repeating character is found then append '#' at the end of B.

Input 1:
 A = "abadbc"

Output 1:
 "aabbdd"

Explanation 1:

    "a"      -   first non repeating character 'a'
    "ab"     -   first non repeating character 'a'
    "aba"    -   first non repeating character 'b'
    "abad"   -   first non repeating character 'b'
    "abadb"  -   first non repeating character 'd'
    "abadbc" -   first non repeating character 'd'

Input 2:
 A = "abcabc"

Output 2:
 "aaabc#"

Explanation 2:

    "a"      -   first non repeating character 'a'
    "ab"     -   first non repeating character 'a'
    "abc"    -   first non repeating character 'a'
    "abca"   -   first non repeating character 'b'
    "abcab"  -   first non repeating character 'c'
    "abcabc" -   no non repeating character so '#'


*/

import java.util.*;


public class first_non_repeating_char_in_stream {
    public String solve(String A) {
        Queue<Character> q = new ArrayDeque<>();
        
        HashMap<Character, Integer> map = new HashMap<>();

        String ans = "";
        for(int i = 0; i < A.length(); i++) {
            char ch = A.charAt(i);

            map.put(ch, map.getOrDefault(ch, 0) + 1);

            if(map.get(ch) == 1)
                q.add(ch);

            while(q.size() > 0 && map.get(q.peek()) > 1)
                q.remove();

            ans += (q.size() == 0) ? "#" : q.peek();
        }

        return ans;
    }
}
