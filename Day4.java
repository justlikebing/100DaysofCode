public class Day4{
    public static void main(String[] args){

    } 
    class tVf{
        public static int MajorityElement(int[] v){
            int n = v.length;
            int count = 0;
            int ele = 0;

            for(int i = 0 ; i < n ; i++){
                if(count == 0){
                    count = 1;
                    ele = v[i];
                }
                else if(ele == v[i]){
                    count++;
                }
                else{
                    count --;
                }
            }
            int count1 = 0;
            for(int i = 0; i < n; i++){
                if(v[i] == ele){
                    count1++;
                }
            }
            if(count1 > (n/2)){
                return ele;
            }
            return -1;
        }
    }
}