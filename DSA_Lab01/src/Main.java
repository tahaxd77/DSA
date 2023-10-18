public class Main {
    public static void main(String[] args) {
        int A[] =new int[]{2,4,3,2,11,2,3,50,4,11,50};
        for(int i=0;i<= A.length;i++){
           int element = A[i];
           int count =0;
            for(int j=0;j<A.length;j++){
                if(i!=j && element == A[j]){
                    count++;
                }
            }
            boolean isUnique=true;
            for(int k=0;k<i;k++) {
                if (element == A[k]) {
                    isUnique = false;
                    break;
                }
            }
            if(isUnique){
                System.out.println("Element ="+element+" "+"No of Occurences="+count);
            }
        }
    }
}