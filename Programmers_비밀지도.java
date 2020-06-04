public class Programmers_비밀지도 {
	
	public static void main(String[] args) {
		int n = 5;
		int[] arr1 = {9, 20, 28, 18, 11};
		int[] arr2 = {30, 1, 21, 17, 28};
		String[] answer = solution(n, arr1, arr2);
		for(int i=0; i<n; i++) System.out.println(answer[i]);
	}
	
	static String[] solution(int n, int[] arr1, int[] arr2) {
		int[] line = new int[n];
		for(int i=0; i<n; i++) {
			line[i] = arr1[i]|arr2[i];
			System.out.println(line[i]);
		}
		
		String[] answer = new String[n];
		
		for(int i=0; i<n; i++) {
			int num = line[i];
			String s = "";
			for(int j=0; j<n; j++) {
				if(num%2==1) s = "#"+s;
				else s = " " + s;
				num /= 2;
			}
			answer[i] = s;
		}
		
		return answer;
	}
}
