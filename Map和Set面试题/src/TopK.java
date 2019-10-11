import java.util.*;

/**
 * 求前K个出现频率最高的单词
 */
public class TopK {
    public static Map<String,Integer> calcCount(String[] words){
        Map<String,Integer> count = new TreeMap<>();
        for(String s:words){
            int i = count.getOrDefault(s, 0);
            count.put(s,i+1);
        }
        return count;
    }

    public static Map<Integer,List<String>> calcCountOfWords(Map<String,Integer> map){
        Map<Integer,List<String>> ret = new TreeMap<>();
        for(Map.Entry<String,Integer> e: map.entrySet()){
            String word = e.getKey();
            int count = e.getValue();
            if(!ret.containsKey(count)){
                ret.put(count,new ArrayList<String>());
            }
            ret.get(count).add(word);
        }
        return ret;
    }

    public static void main(String[] args) {
        String[] words = {"i", "love", "leetcode", "i", "love", "coding"};
        Map<String,Integer> mapCount = calcCount(words);
        System.out.println(mapCount);
        Map<Integer,List<String>> mapCountWords = calcCountOfWords(mapCount);
        System.out.println(mapCountWords);
        Set<Integer> counts = mapCountWords.keySet();
        List<Integer> countsList = new ArrayList<>(counts);
 /*       Collections.sort(countsList,new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });*/

         Collections.sort(countsList,(o1,o2)->o2-o1);
        System.out.println(countsList);

        List<String> result = new ArrayList<>();
        int n = 0;
        int i = 0;
        int k = 2;
        while(n < k){
            int count = countsList.get(i);
            i++;
            List<String> ws = mapCountWords.get(count);
            if(ws.size() < k-n){
                result.addAll(ws);
                n += ws.size();
            }else{
                result.addAll(ws.subList(0,k-n));
                n += (k-n);
            }
        }
        System.out.println(result);

    }
}
