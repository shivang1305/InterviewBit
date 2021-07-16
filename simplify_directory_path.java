/* STACKS & QUEUES                                                           Date: 09-July-2021
Given a string path, which is an absolute path (starting with a slash '/') to a file or directory in a Unix-style file system, convert it to the simplified canonical path.

In a Unix-style file system, a period '.' refers to the current directory, a double period '..' refers to the directory up a level, and any multiple consecutive slashes (i.e. '//') are treated as a single slash '/'. For this problem, any other format of periods such as '...' are treated as file/directory names.

The canonical path should have the following format:

The path starts with a single slash '/'.
Any two directories are separated by a single slash '/'.
The path does not end with a trailing '/'.
The path only contains the directories on the path from the root directory to the target file or directory (i.e., no period '.' or double period '..')
Return the simplified canonical path.

 

Example 1:

Input: path = "/home/"
Output: "/home"
Explanation: Note that there is no trailing slash after the last directory name.

Example 2:

Input: path = "/../"
Output: "/"
Explanation: Going one level up from the root directory is a no-op, as the root level is the highest level you can go.
*/


import java.util.*;


public class simplify_directory_path {
    public String simplifyPath(String path) {
        Stack<String> st = new Stack<>();
        
        String[] str = path.split("\\/"); 
        
        for(String p : str) {
            if(p.length() == 0 || p.equals("."))
                continue;
            
            else if(p.equals("..")) {
                if(!st.empty())
                    st.pop();
            }
            
            else 
                st.push(p);
        }
        
        String ans = "";
        while(!st.empty()) 
            ans = st.pop() + "/" + ans;
        
        if(ans.length() == 0)
            return "/";
        
        return "/" + ans.substring(0, ans.length() - 1); // removing the last / from the string and putting it in the front of the ans string
    }
}
