import java.util.*;
class Solution {
    static ArrayList<Integer> tuple = new ArrayList<Integer>();
    static class StringComp implements Comparator<String> {
		@Override
		public int compare(String s1, String s2) {
			return s1.length() - s2.length();
		}
	}
    
    public int[] solution(String s) {
        String[] res = preprocessing(s);
		int[] answer = new int[res.length];
		
		for(int i=0; i<res.length; i++) {
			answer[i] = input(res[i]);
			System.out.println(answer[i]);
		}
        
        return answer;
    }
    
    public static String[] preprocessing(String s) {
	String[] res = s.substring(1, s.length()-1).split("\\},\\{");
	res[0] = res[0].substring(1, res[0].length());
	res[res.length-1] = res[res.length-1].substring(0, res[res.length-1].length()-1);
	
	Arrays.sort(res, new StringComp());
	return res;
    }
	
    public static int input(String s) {
	int tmp = 0;
	String[] arr = s.split(",");
	for(int i=0; i<arr.length; i++) {
		tmp = Integer.parseInt(arr[i]);
		if(!tuple.contains(tmp)) break;
	}
	tuple.add(tmp);
	return tmp;
    }	
}
