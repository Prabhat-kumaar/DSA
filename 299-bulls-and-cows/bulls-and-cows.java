class Solution {
    public String getHint(String secret, String guess) {

        HashMap<Character, Integer> map = new  HashMap<>();

        int bull = 0, cows =0;

        for(int i=0; i<secret.length(); i++) {
            char s = secret.charAt(i);
            char g = guess.charAt(i);

            if(s == g) {
                bull++;
            } else {
                map.put(s, map.getOrDefault(s,0)+1);
            }
        }

        for(int i=0; i<secret.length(); i++) {
            char s = secret.charAt(i);
            char g = guess.charAt(i);

            if(s != g && map.getOrDefault(g,0) >0) {
                cows++;
                map.put(g, map.get(g) - 1);
            } 
        }
        return bull + "A" + cows +"B";
    }
}