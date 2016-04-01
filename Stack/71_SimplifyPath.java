/*
Given an absolute path for a file (Unix-style), simplify it.

For example,
path = "/home/", => "/home"
path = "/a/./b/../../c/", => "/c"
*/

public String simplifyPath(String path) {

    if(path == null || path.length() == 0)
        return "";

    Stack<String> stack = new Stack<String>();
    String[] strArr = path.split("/");
    for(int i = 0; i < strArr.length; i++) {
        if(strArr[i].equals(""))
            continue;
        if(strArr[i].equals("."))
            continue;
        if(strArr[i].equals("..")) {
            if(!stack.isEmpty())
                stack.pop();
        } else {
            stack.push(strArr[i]);
        }
    }

    StringBuilder sb = new StringBuilder();
    if(stack.isEmpty()) {
        return "/";
    }
    while(!stack.isEmpty()) {
        sb.insert(0, stack.pop());
        sb.insert(0, "/");
    }
    return sb.toString();
}
