class Solution {
    public String longestNiceSubstring(String s) {
        if (s.length() < 2) return "";
        
        // Use a set to track unique characters
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            set.add(c);
        }
        
        // Find a character that breaks the "niceness" property
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // If either uppercase or lowercase is missing
            if (set.contains(Character.toUpperCase(c)) && 
                set.contains(Character.toLowerCase(c))) {
                continue;
            }
            
            // This character breaks the property, so split and check both sides
            String left = longestNiceSubstring(s.substring(0, i));
            String right = longestNiceSubstring(s.substring(i + 1));
            
            return left.length() >= right.length() ? left : right;
        }
        
        // All characters satisfy the property
        return s;
    }
}