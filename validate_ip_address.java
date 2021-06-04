/* STRINGS                                                                      Date: 04-Jun-2021
Given a string IP, return "IPv4" if IP is a valid IPv4 address, "IPv6" if IP is a valid IPv6 address or "Neither" if IP is not a correct IP of any type.

A valid IPv4 address is an IP in the form "x1.x2.x3.x4" where 0 <= xi <= 255 and xi cannot contain leading zeros. For example, "192.168.1.1" and "192.168.1.0" are valid IPv4 addresses but "192.168.01.1", while "192.168.1.00" and "192.168@1.1" are invalid IPv4 addresses.

A valid IPv6 address is an IP in the form "x1:x2:x3:x4:x5:x6:x7:x8" where:

1 <= xi.length <= 4
xi is a hexadecimal string which may contain digits, lower-case English letter ('a' to 'f') and upper-case English letters ('A' to 'F').
Leading zeros are allowed in xi.

Example 1:
Input: IP = "172.16.254.1"
Output: "IPv4"
Explanation: This is a valid IPv4 address, return "IPv4".

Example 2:
Input: IP = "2001:0db8:85a3:0:0:8A2E:0370:7334"
Output: "IPv6"
Explanation: This is a valid IPv6 address, return "IPv6".

Example 3:
Input: IP = "256.256.256.256"
Output: "Neither"
Explanation: This is neither a IPv4 address nor a IPv6 address.
*/


public class validate_ip_address {
    public String validIPAddress(String IP) {
        if(IP.chars().filter(c -> c == '.').count() == 3) {
            for(String token : IP.split("\\.", -1)) {
                
                if(token.length() == 0 || token.length() > 3)
                    return "Neither";
                
                if(token.charAt(0) == '0' && token.length() != 1)
                    return "Neither";
                
                for(char c : token.toCharArray()) {
                    if(!Character.isDigit(c))
                        return "Neither";
                }
                
                if(Integer.parseInt(token) > 255)
                    return "Neither";
            }
            return "IPv4";
        }
        
        if(IP.chars().filter(c -> c == ':').count() == 7) {
            for(String token : IP.split(":", -1)) {
                
                if(token.length() == 0 || token.length() > 4)
                    return "Neither";
                
                for(char c : token.toCharArray()) {
                    if(!(c >= '0' && c <= '9' || c >= 'a' && c <= 'f' || c >= 'A' && c <= 'F'))
                        return "Neither";
                }
            }
            return "IPv6";
        }
        
        return "Neither";
    }
}
