package dynamicProgramming.RobotCircle;

public class Solution {
    public boolean judgeCircle(String moves) {
        int row = 0, col = 0;
        char[] command = moves.toCharArray();
        for (char instruct: command){
            switch (instruct){
                case 'U':{
                    ++col; break;
                }
                case 'D':{
                    --col; break;
                }
                case 'L':{
                    --row; break;
                }
                case 'R':{
                    ++row; break;
                }
            }
        }
        return row == 0 && col == 0;
    }
}
