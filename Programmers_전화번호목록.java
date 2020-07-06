class Solution {
    public boolean solution(String[] phone_book) {
        int len = phone_book.length;
        for(int i=0; i<len; i++) {
            for(int j=0; j<len; j++) {
                if(i==j) continue;
                String num1 = phone_book[i];
                String num2 = phone_book[j];
                int compareLength = Math.min(num1.length(), num2.length());
                boolean compare = false;
                for(int k=0; k<compareLength; k++) {
                    if(num1.charAt(k)!=num2.charAt(k)) compare = true;                    
                }
                if(!compare) return compare;                
            }
        }
        return true;
    }
}
