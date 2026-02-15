// User function Template for Java

class Solution {
    boolean allZero(int[] arr){
        for(int ch:arr){
            if(ch!=0) return false;
        }
        return true;
    }
    int search(String pat, String txt) {
        // BRUTE FORCE
        // HashMap<Character, Integer> hm = new HashMap<>();
        // for(int i=0;i<pat.length();i++){
        //     char ch= pat.charAt(i);
        //     if(hm.containsKey(ch)) hm.put(ch, hm.get(ch)+1);
        //     else  hm.put(ch, 1);
        // }
        
        // int l=0;
        // int r=0;
        // int k= pat.length();
        // int count=0;
        
        // while(r<txt.length()){
        //     if(r-l+1 ==k){
        //         HashMap<Character, Integer> win = new HashMap<>();
        //         for(int i = l; i <= r; i++){
        //             char ch=txt.charAt(i);
        //             if(win.containsKey(ch)) win.put(ch, win.get(ch)+1);
        //             else  win.put(ch, 1);
        //             if(win.equals(hm)) count++;
        //         }
        //         l++;
        //     }
            
        //     r++;
        // }
        // return count;
        
        int[] freq= new int[26];
        
        for(int i=0;i<pat.length();i++){
            char ch= pat.charAt(i);
            freq[ch-'a']++;
        }
        
        int l=0;
        int r=0;
        int k= pat.length();
        int count=0;
        while(r<txt.length()){
        
            freq[ txt.charAt(r) -'a']--;  // dcreseing the count of rth char from freq array
            
            //checking if the window equals to pat
            if(r-l+1 == k){
                if(allZero(freq)){ //if all zero then yes its a match
                    count++;
                }
                
                freq[ txt.charAt(l)-'a' ]++; //new shrinking the window by refetching the decresed freq 
                l++;// lshift by 1 
            }
            r++;
        }
        return count;
        

        
    }
}