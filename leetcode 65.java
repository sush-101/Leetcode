//https://leetcode.com/problems/valid-number/
//https://www.youtube.com/watch?v=0qac3ngAZmE

import java.util.regex.*;
class Solution {
    /*     
     +-
     12.23
     .23
     123
     eE
     +-
     123
    */
    public boolean isNumber(String s) {
        String regex = "^[+-]?((\\d+\\.\\d*)|(\\.\\d+)|(\\d+))([eE][+-]?\\d+)?$";
        return Pattern.matches(regex,s);
    }
}
// class Solution { // Method 2
//     /* 
//     We have followings in valid string
//     1) digits   boolean
//     2) + -      int because it can be at max 2
//         Invalid:    +23++4 , 12+, 3-, +e5, ++5,  4+34
//     3) e/E      boolean
//         Invalid:   e23E12,  123e, e34   
//     4) dot      boolean
//         Invalid:    23e34.34   .23.   .  +.  e.
//     */
//     public boolean isNumber(String s) {
//         boolean seenDigit = false, seenE = false,seenDot = false;
//         int countPlusMinus = 0, n = s.length();
//         for(int i = 0 ; i < n ; i++){
//             char ch = s.charAt(i);
//             if(Character.isDigit(ch)){
//                 seenDigit = true;
//             }
//             else if(ch == '+' || ch == '-'){
//                 if(countPlusMinus == 2 ||
//                   i == n-1 ||
//                   (i > 0 && (s.charAt(i-1) == '+' || s.charAt(i-1) == '-')) ||
//                   (i > 0 && s.charAt(i-1) != 'e' &&  s.charAt(i-1) != 'E')){
//                     return false;
//                 }
//                 countPlusMinus++;
//             }
//             else if(ch == 'e' || ch == 'E'){
//                 if(seenE || i == n-1 || !seenDigit){
//                     return false;
//                 }
//                 seenE = true;
//             }
//             else if(ch == '.'){
//                 if(seenE || seenDot || (i == n-1 && !seenDigit)){
//                     return false;
//                 }
//                 seenDot = true;
//             }
//             else 
//                 return false;
//         }
//         return true;
//     }
// }

// class Solution {
//     public boolean isNumber(String s) {
//         int n = s.length();
//         if(n == 0) return true;
//         // 23E or 23e
//         if(s.charAt(n-1) == 'e' || s.charAt(n-1) == 'E') return false;
//         // check if we have more than one . or e
//         int dotCount = 0,eCount = 0;
//         for(int i = 0 ; i < n ; i++){
//             if(s.charAt(i) == '.')
//                 dotCount++;
//             if(s.charAt(i) == 'e' || s.charAt(i) == 'E')
//                 eCount++;
//         }
//         if(dotCount > 1 || eCount > 1) return false;
//         String []a = s.split("[e E]");//System.out.println("e : "+Arrays.toString(a));
//         if(a.length == 2){//System.out.println(isDecimal(a[0])+" "+ isInteger(a[1]));
//             return isDecimal(a[0]) && isInteger(a[1]); 
//         }
//         return isDecimal(a[0]);
//     }
    
//     boolean isInteger(String s){ 
//         int n = s.length();
//         if(n == 0) return false;
//         char ch = s.charAt(0);
//         if((ch == '+' || ch == '-') && n == 1) return false;
//         if(!(ch == '+' || ch == '-' || (ch >= '0' && ch <= '9'))) return false;
//         for(int i = 1 ; i < n ; i++){
//             ch = s.charAt(i);
//             if(ch < '0' || ch > '9') return false;
//         }
//         return true;
//     }
    
//     boolean isDecimal(String s){//System.out.println(s);
//         int n = s.length();
//         if(n == 0 || s.equals(".")) return false;
//         String []a = s.split("[.]");// System.out.println(""+Arrays.toString(a));
//         //check for second part    
//         if(a.length == 2){
//             // "."
//             if(a[0].length() == 0 && a[1].length() == 0) return false;
//             s = a[1];
//             for(int i = 0 ; i < s.length() ; i++){
//                 char ch = s.charAt(i);
//                 if(ch < '0' || ch > '9') return false;
//             }
//         }
//         s = a[0];
//         n = s.length();
//         if(n == 0) return true;
//         if(a.length == 1 && (s.equals("+") || s.equals("-"))) return false;
//         char ch = s.charAt(0);
//         //if((ch == '+' || ch == '-') && n == 1) return false;
//         if(!(ch == '+' || ch == '-' || (ch >= '0' && ch <= '9'))) return false;
//         for(int i = 1 ; i < n ; i++){
//             ch = s.charAt(i);
//             if(ch < '0' || ch > '9') return false;
//         }
//         return true;
//     }
// }

/*

d/i e/E i

+0.3e5 : valid
+23.4
-.45
+2.3e-6

2e5.6 : not valid

Regular expression
[+-][0-9]*.[0-9]+[e E][+ -][0-9]+

Number = part1 [e E] part2

part2 : Integer
[+ -] one or more digit[1-9]

"..2"
"+."
"+e5"
"+eo"
"1e."
".e2"
".3"
"2.e4"
"1.2"
"+.3"
"23.3"
"2e"
"0"
"e"
"."
".1"
".."
"4e+"
"005047e+6"

*/
