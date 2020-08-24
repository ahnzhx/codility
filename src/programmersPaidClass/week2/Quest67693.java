package programmersPaidClass.week2;

import java.util.LinkedList;
import java.util.Queue;

public class Quest67693 {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int totalSecond = 0;
        Queue<Integer> bridge = new LinkedList<>();
        int sum = 0;

        int i = 0 ;
        while(bridge.size() < bridge_length){
            if(sum + truck_weights[i] > weight){
                bridge.add(0); // 한칸 이동했다는 표시임
            }else {
                bridge.add(truck_weights[i]);
                sum += truck_weights[i];
            }
            totalSecond++;

            if(bridge.size() == bridge_length){
                sum -= bridge.poll();
                i++;
            }
            if(i > truck_weights.length){
                break;
            }
        }
        return totalSecond;
    }
}
