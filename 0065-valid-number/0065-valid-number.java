class Solution {
    public boolean isNumber(String s) {

        boolean digitSeen = false;
        boolean dotSeen = false;
        boolean eSeen = false;

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            // Case 1: If character is a digit
            if (Character.isDigit(ch)) {
                digitSeen = true;
            }

            // Case 2: If character is a decimal point
            else if (ch == '.') {

                if (dotSeen || eSeen) {
                    return false;
                }

                dotSeen = true;
            }

            // Case 3: If character is e or E
            else if (ch == 'e' || ch == 'E') {

                if (eSeen || !digitSeen) {
                    return false;
                }

                eSeen = true;
                digitSeen = false;
            }

            // Case 4: If character is + or -
            else if (ch == '+' || ch == '-') {

                if (i != 0 && s.charAt(i - 1) != 'e'
                           && s.charAt(i - 1) != 'E') {
                    return false;
                }
            }

            // Case 5: Any other character is invalid
            else {
                return false;
            }
        }

        return digitSeen;
    }
}