package io.lynna.leetcode;

/**
 * Created by lynna on 2017/11/25.
 */
public class DungeonGame {
    public static int calculateMinimumHP(int[][] dungeon) {
        int height = dungeon.length;
        int width = dungeon[0].length;
        int hpRecord[][] = new int[height][width];
        if(height==1 && width==1){
            if(dungeon[0][0]>=0)
                return 1;
            else
                return -dungeon[0][0]+1;
        }
        for(int i=height-1;i>=0; i--){
            for(int j=width-1; j>=0; j--){
                if(j==width-1 && i==height-1){
                    hpRecord[i][j]=dungeon[i][j]>=0?0:-dungeon[i][j];
                    continue;
                }
                int right=0,down=0;
                boolean hasNoRight=false,hasNoDown=false;

                if(j+1<=width-1)
                    if(dungeon[i][j] - hpRecord[i][j+1]<=0)
                        right = -(dungeon[i][j] - hpRecord[i][j+1]);
                    else
                        right = Math.max(-dungeon[i][j],0);
                else
                    hasNoRight=true;

                if(i+1<=height-1)
                    if(dungeon[i][j] - hpRecord[i+1][j]<=0)
                        down = -(dungeon[i][j] - hpRecord[i+1][j]);
                    else
                        down = Math.max(-dungeon[i][j],0);
                else
                    hasNoDown=true;

                if(hasNoRight)
                    hpRecord[i][j]=down;
                else if(hasNoDown)
                    hpRecord[i][j]=right;
                else
                    hpRecord[i][j] = Math.min(right, down);
            }
        }
        printArray(hpRecord);
        return hpRecord[0][0]+1;
    }

    public static void printArray(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for(int j=0; j<array[0].length; j++){
                System.out.print(array[i][j] + " ");
            }
            System.out.println('\n');
        }
    }

    public static void main(String args[]){
        int[][] dungeon = {{0, 0}, {-5, -4}};
        System.out.println(calculateMinimumHP(dungeon));
    }
}


