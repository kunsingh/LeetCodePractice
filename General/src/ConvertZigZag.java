/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 *
 * Write the code that will take a string and make this conversion given a number of rows:
 *
 * string convert(string s, int numRows);
 * Example 1:
 *
 * Input: s = "PAYPALISHIRING", numRows = 3
 * Output: "PAHNAPLSIIGYIR"
 * Example 2:
 *
 * Input: s = "PAYPALISHIRING", numRows = 4
 * Output: "PINALSIGYAHRPI"
 * Explanation:
 *
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 */
public class ConvertZigZag {
    public String convert(String s, int numRows) {

        StringBuilder result = new StringBuilder("");
        for(int i=0;i<4;i++){
            result.append(s.charAt(i));
            int j=i;
            while(j < s.length()) {
                j = j+numRows + (numRows-2);
                if(j<s.length())
                result.append(s.charAt(j));
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(new ConvertZigZag().convert("PAYPALISHIRING", 4));
    }
}
