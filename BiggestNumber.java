import java.util.*;

class Solution {
    
    static Comparator<String> compare = new Comparator<String>() {
		@Override
		public int compare(String s1, String s2) {
			return Integer.parseInt(s1+s2)-Integer.parseInt(s2+s1);
		}
	};
    
    public String solution(int[] numbers) {
		ArrayList<String> arr = new ArrayList<String>();
		for(int i=0; i<numbers.length; i++) arr.add(String.valueOf(numbers[i]));
		Collections.sort(arr, compare);
		String answer = "";
		
		for(int i=0; i<numbers.length; i++) answer = arr.get(i) + answer;
        
        if(answer.charAt(0)=='0') answer = "0";
        return answer;
    }
}
