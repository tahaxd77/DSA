public class arrayInsert{
    public static void main(String[] args) {
        int A[]=new int[]{1,2,3,4,5,6,7,8,9};
        largestNumber(A);
        arrayInsert(A,5,10);
        arrayDelete(A,5);
    }
    public static void arrayInsert(int []A,int indexToInsert,int numberToInsert){
        if(A.length<A.length+1) {
            int newArray[] = new int[A.length + 1];
            for (int i = 0; i < indexToInsert; i++) {
                newArray[i] = A[i];
            }
            newArray[indexToInsert] = numberToInsert;
            for (int j = indexToInsert; j < A.length; j++) {
                newArray[j + 1] = A[j];
            }
            A=newArray;
        }
        else {
            for (int i = A.length - 1; i > indexToInsert; i--) {
                A[i] = A[i - 1];
            }


            A[indexToInsert] = numberToInsert;
        }
        for(int element:A){
            System.out.println(element+ "");
        }
    }
    public static void arrayDelete(int []A,int indexToDelete){
        if(indexToDelete>=0 && indexToDelete<A.length){
            for(int i=indexToDelete;i<A.length-1;i++){
                A[i]=A[i+1];
            }
            int newArray[] = new int[A.length-1];
            for(int i=0;i<newArray.length;i++){
                newArray[i]=A[i];
            }
            A=newArray;
            for(int element:A){
                System.out.println(element+"");
            }
        }
        else {
            System.out.println("Invalid Index");
        }
    }
    public static void largestNumber(int []A){
        int largest = A[0];
        for(int k=0;k<A.length;k++){
            if(A[k]>largest){
                largest=A[k];
            }
        }
        System.out.println("Largest Number="+largest);
    }
}
