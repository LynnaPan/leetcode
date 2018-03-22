package io.lynna.leetcode;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lynna on 2018/1/16.
 */
public class CityOutline {
    public List<List<Integer>> buildingOutline(int[][] buildings) {
        // write your code here
        int start = buildings[0][0];
        int end = start;
        int hight = 0;
        int nextStart = 0;
        List<List<Integer>> outline = new ArrayList<>();

        for(int i = 0; i<buildings.length-1; i++){
            //second start less than first end
            if(buildings[i+1][0]<buildings[i][1]){
                //second higher than first
                if(buildings[i+1][2]>=buildings[i][2]) {
                    nextStart = buildings [i+1][0];
                    end = buildings[i + 1][0];
                    hight = buildings[i][2];
                }
                else{
                    nextStart = buildings[i][1];
                    end = buildings[i][1];
                    hight = buildings[i][2];
                }

            }
            //second start larger than first start
            else {
                nextStart = buildings[i+1][0];
                end = buildings[i][1];
                hight = buildings[i][2];
            }

            outline = addTemp(outline, start, end, hight);
            start = nextStart;

        }
        end = buildings[buildings.length-1][2];
        hight = buildings[buildings.length-1][3];
        outline = addTemp(outline, start, end, hight);

        return outline;
    }

    private List<List<Integer>> addTemp(List<List<Integer>> source, int start, int end, int hight){
        List<Integer> tmp = new ArrayList<>();
        if(!source.isEmpty()){
            List<Integer> item =source.get(source.size()-1);
            if(item.get(2) == hight){
                start = item.get(0);
                source.remove(item);
            }
        }
        tmp.add(start);
        tmp.add(end);
        tmp.add(hight);
        source.add(tmp);
        return source;
    }
}
