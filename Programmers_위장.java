import java.util.*;
class Solution {
    public int solution(String[][] clothes) {

            HashMap<String, Integer> hm = new HashMap<>();

            for(String[] s : clothes) {
                String part = s[1];
                String detail = s[0];

                if(hm.containsKey(part)) {
                    hm.put(part, hm.get(part)+1);
                } else hm.put(part, 2);
            }
            int answer = 1;

            Iterator<String> keys = hm.keySet().iterator();
            while(keys.hasNext()) {
                String key = keys.next();
                answer *= hm.get(key);
            }

            return answer-1;
        }
}
