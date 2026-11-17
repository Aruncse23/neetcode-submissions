class Solution {
    public boolean isPalindrome(String s) {
        if(s.isEmpty()){
            return true; 
        }

        int start = 0;
        int end = s.length() - 1;
        while(start <= end){
            int S = s.charAt(start);
            int E = s.charAt(end);

            if(!Character.isLetterOrDigit(S)){
                start++;
            } else if(!Character.isLetterOrDigit(E)){
                end--;
            } else {
                if(Character.toLowerCase(S) != Character.toLowerCase(E)) {
                    return false;
                }
                start++;
                end--;
            }
        }
        return true;
    }
}
