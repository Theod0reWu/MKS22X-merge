public class Merge{
  /*sort the array from least to greatest value. This is a wrapper function*/
  public static void mergesort(int[]data){
    int[] temp = new int[data.length];
    for (int i = 0; i < data.length ; i++){
      temp[i] = data[i];
    }
    mergesort(data,temp, 0, data.length);
  }
  public static void mergesortTest(int[]data){
    int[] temp = new int[data.length];
    for (int i = 0; i < data.length ; i++){
      temp[i] = data[i];
    }
    int l = 1;
    while (l < data.length){
      for (int i = 0; i < data.length; i+=l*2){
        int f = i;
        int s = i + l;
        for (int a = 0 ; a < l; a++){
          
        }
      }
      l*=2;
    }
  }
  private static void mergesort(int[]data, int[]temp, int lo, int hi){
    if(lo == hi){
      return;
    }
    int middle = (hi-lo)/2;
    mergesort(data, temp, lo, middle+1);
    mergesort(data, temp, middle, hi);
    for (int one = lo, two = middle ; middle < hi;){
      if(temp[one] < temp[two])
    }
  }
  public static void main(String[] args){

  }
}
