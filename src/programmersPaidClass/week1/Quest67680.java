package programmersPaidClass.week1;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

public class Quest67680 {

    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        Set<String> ending = new HashSet<>();

        char wordLastLetter = words[0].charAt(words[0].length()-1);
        ending.add(words[0]);

        for(int i =1 ; i< words.length; i++){
            if(ending.contains(words[i])){
                return checkLoser(answer, n, i);
            } else if(!words[i].startsWith(wordLastLetter + "")){
                return checkLoser(answer, n, i);
            }

//            if(!ending.contains(words[i]) && words[i].startsWith(wordLastLetter + ""))
            ending.add(words[i]);

            wordLastLetter = words[i].charAt(words[i].length()-1);
        }
        answer[0] = 0;
        answer[1] = 0;

        return answer;
    }

    // 종단 연산(collect,reduce,foreach) 가 없다면, 스트림에 사용된 (1,2,3,4) 원소는 직접 연산에 사용되지 않는다는 뜻입니다.
    public void test(){
        Stream.of(1,2,3,4).map(i -> i*3).filter( i -> i/2 == 0).toArray();
    }
    private int[] checkLoser(int[] answer, int n, int i){
        if((i+1) % n == 0){
            answer[0] = n;
            answer[1] = (i+1) / n;
        }else{
            answer[0] = (i+1) % n;
            answer[1] = (i+1) / n + 1;
        }
        return answer;
    }

    public static void main(String[] args) {
        String[] words = new String[]{"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};
        System.out.println(new Quest67680().solution(3, words));

//        String[] words = new String[]{"hello", "one", "even", "never", "now", "world", "draw"};
//        System.out.println(new Quest67680().solution(2, words));

    }
}
