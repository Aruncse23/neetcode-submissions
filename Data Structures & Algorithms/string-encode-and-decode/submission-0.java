class Solution {
    public String encode(List<String> strs) {
        StringBuilder ans = new StringBuilder();
        for (String s : strs) {
            ans.append((char) s.length()).append(s);
        }
        return ans.toString();
    }

    public List<String> decode(String str) {
      //  public List<String> decode(String s) {
            List<String> ans = new ArrayList<>();
            int i = 0, n = str.length();
            while (i < n) {
                int size = str.charAt(i++);
                ans.add(str.substring(i, i + size));
                i += size;
            }
            return ans;
        }
    }
