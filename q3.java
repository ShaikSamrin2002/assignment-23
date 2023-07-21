public class repeating {
    public static void main(String[] args) {
        int[] arr= new int[]{10,20,20,10,10,30,50,10,20};
        System.out.println("Non Repeated arrays : ");
        boolean[] isRepeated=new boolean[arr.length];
        int notrepeatingcount=0;
        for(int i=0;i<arr.length;i++) {
            if(!isRepeated[i]) {
                boolean isUnique=true;
                for(int j=i+1;j<arr.length;j++) {
                if(arr[i]==arr[j]) {
                    isRepeated[j]= true;
                    isUnique= false;
                }
            }
            if(isUnique) {
                System.out.println(arr[i] + " ");
                notrepeatingcount++;

            }    

            }
        }
        System.out.println("Count of singular socks : "+notrepeatingcount);
    }
}
