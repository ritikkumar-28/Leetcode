class Solution {
    public String minWindow(String s, String t) {
        if (t.isEmpty() || s.length() < t.length()){
            return "";
        }
        int[] need = new int[128];
        for(char c : t.toCharArray()){
            need[c]++;
        }
        int left = 0;
        int required = t.length();
        int minLength = Integer.MAX_VALUE;
        int startIndex = 0;

        for(int right = 0; right < s.length(); right++){
            char c = s.charAt(right);

            if(need[c] > 0){
                required --;
            }
            need[c]--;
            while(required == 0){
                int windowLength = right - left + 1;

                if(windowLength < minLength){
                    minLength = windowLength;
                    startIndex = left;
                }
                char leftChar = s.charAt(left);
                need[leftChar]++;

                if(need[leftChar] > 0){
                    required++;
                }
                left++;
            }
        }
        if(minLength == Integer.MAX_VALUE){
            return "";
        }
        return s.substring(startIndex, startIndex + minLength);
    }
}