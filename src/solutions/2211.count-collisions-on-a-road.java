package solutions;
/*
 * @lc app=leetcode id=2211 lang=java
 *
 * [2211] Count Collisions on a Road
 */

// @lc code=start

import java.util.Stack;

class Solution {
    public int countCollisions(String directions) {
        int res = 0;
        int flag = -1;
        for (char c : directions.toCharArray()) {
            if (c == 'L') {
                if (flag >= 0) {
                    res += flag + 1;
                    flag = 0;
                }
            } else if (c == 'S') {
                if (flag > 0) {
                    res += flag;
                }
                flag = 0;
            } else {
                if (flag >= 0) {
                    flag++;
                } else {
                    flag = 1;
                }
            }
        }
        return res;
    }
}

// class Solution {
//     public int countCollisions(String directions) {

//         Stack<Character> stack = new Stack<>();
//         int result = 0;
//         int n = directions.length();
//         // stack.push(directions.charAt(0));

//         for (int i = 0; i < n; i++) {
//             char c = directions.charAt(i);

//             if (stack.isEmpty()) {
//                 stack.push(c);
//                 continue;
//             }

//             char peek = stack.peek();

//             if (peek == 'R' && c == 'L') {
//                 result += 2;
//                 stack.pop();
//                 c = 'S';

//             } else if (peek == 'S' && c == 'L') {
//                 result++;
//                 c = 'S';

//             }

//             while (!stack.isEmpty() && (stack.peek() == 'R' && c == 'S')) {
//                 result++;
//                 stack.pop();
//             }

//             stack.push(c);
//         }

//         return result;
//     }
// }
// @lc code=end
