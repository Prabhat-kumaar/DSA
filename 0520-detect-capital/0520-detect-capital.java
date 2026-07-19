class Solution {
    public boolean detectCapitalUse(String word) {


        if(word.length() <= 1) {
            return true;
        }

        boolean isUpper = Character.isUpperCase(word.charAt(1));

        if(!Character.isUpperCase(word.charAt(0)) && isUpper) {
            return false;
        }

        for (int i = 2; i<word.length(); i++) {

            if(Character.isUpperCase(word.charAt(i)) != isUpper){
                return false;
            }
        }
        return true;
        
    }
}