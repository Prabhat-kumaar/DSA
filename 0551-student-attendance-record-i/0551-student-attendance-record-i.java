class Solution {
    public boolean checkRecord(String s) {

        int Absent = 0;
        int late = 0;

        for(int i=0; i<s.length(); i++) {

            char ch = s.charAt(i);

            if (ch == 'A') {
                Absent++;
                late = 0;

                if (Absent >= 2) {
                    return false;

                }

            }
            else if (ch == 'L') {
                late++;

                if (late >= 3) {
                    return false;
                }
            }
            else {
                late = 0;
                
            }
        }
        return true;
        
    }
}