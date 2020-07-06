import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
		
        HashMap<String, Integer> map = new HashMap<String, Integer>();

        for(String s : participant) {
            if(map.containsKey(s)) {
                map.put(s, map.get(s)+1);
            } else map.put(s, 1);
        }

        for(String s : completion) {
            map.put(s, map.get(s)-1);
        }

        Iterator<String> it = map.keySet().iterator();

        while(it.hasNext()) {
            String person = it.next();
            int complete = map.get(person);
            if(complete!=0) return person;
        }
        
		return "A";
    }
}
