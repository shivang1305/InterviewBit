/* STRINGS                                                                      Date: 04-Jun-2021
Given a string s containing only digits, return all possible valid IP addresses that can be obtained from s. You can return them in any order.

A valid IP address consists of exactly four integers, each integer is between 0 and 255, separated by single dots and cannot have leading zeros. For example, "0.1.2.201" and "192.168.1.1" are valid IP addresses and "0.011.255.245", "192.168.1.312" and "192.168@1.1" are invalid IP addresses. 

Input: s = "25525511135"
Output: ["255.255.11.135","255.255.111.35"]

Input: s = "0000"
Output: ["0.0.0.0"]

Input: s = "1111"
Output: ["1.1.1.1"]
*/

import java.util.*;

public class restore_valid_ip_addresses {
    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        
        for(int i = 1; i < s.length() &&  i < 4; i++) {
            String first = s.substring(0, i);
            
            if(!isValidPart(first))
                continue;
            
            for(int j = 1; i + j < s.length() && j < 4; j++) {
                String second = s.substring(i, i + j);
                
                if(!isValidPart(second))
                    continue;
                
                for(int k = 1; i + j + k < s.length() && k < 4; k++) {
                    String third = s.substring(i + j, i + j + k);
                    String fourth = s.substring(i + j + k);
                    
                    if(!isValidPart(third) || !isValidPart(fourth))
                        continue;
                    
                    ans.add(first + "." + second + "." + third + "." + fourth);
                }
            }
        }
        return ans;
    }
    
    public boolean isValidPart(String str) {
        if(str.length() > 3)
            return false;
        
        if(str.charAt(0) == '0' && str.length() != 1)
            return false;
        
        return Integer.parseInt(str) >= 0 && Integer.parseInt(str) <= 255;
    }
}
