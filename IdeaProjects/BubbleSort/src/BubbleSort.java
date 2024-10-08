public class BubbleSort {
    public static void main(String[] args) {
        int[] a={10,9,8,7,-10}; //array-->sort
        int n=a.length;

        System.out.println("Before sorting array content is ");
        printArrayContent(a);
        for (int i=0;i<n;i++) { //outer loop-1

            for (int j = 0; j < n - 1; j++) { //inner loop

                if (a[j] > a[j + 1]) {
                    //swap
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
        System.out.println("After sorting array content is ");
        printArrayContent(a);
    }
    static void printArrayContent(int[] a){
        for (int i=0;i<a.length;i++){
            System.out.print(a[i] +" ");
        }
    }
}
