import java.util.Arrays;
public class Merge{
  public static void mergesort(int[]data){
    int[] temp = new int[data.length];
    int l = 1;
    int [] current = temp; int [] mergeTo = data;
    while (l < data.length){
      if (current == data) {current = temp; mergeTo = data;}
      else {current = data; mergeTo = temp;}
      for (int i = 0; i < data.length;){
        int starting = i;
        for (int f = i, s = i + l ;i < starting + 2*l && i < current.length;i++){
          //System.out.println(f+":"+s+ "|" + starting);
          if(f >= starting + l || f >= current.length){mergeTo[i] = current[s]; s++;}
          else if(s >= starting + 2*l || s >= current.length){mergeTo[i] = current[f];f++;}
          else if (current[f] < current[s]) {
            mergeTo[i] = current[f]; f++;
          }
          else if (current[s] < current[f]){
            mergeTo[i] = current[s]; s++;
          }
          else{
            mergeTo[i] = current[f]; f++;
            i++;
            mergeTo[i] = current[s]; s++;
          }
        }
        //System.out.println("Next " + l + ":" +Arrays.toString(mergeTo));
        //System.out.println("current: " + Arrays.toString(current));
      }
      l*=2;
    }
    if(mergeTo != data){
      for (int i = 0; i< data.length; i++){
        data[i] = mergeTo[i];
      }
    }
  }
  public static void mergesortRecursion(int[]data){
    int[] temp = new int[data.length];
    for (int i = 0; i < data.length ; i++){
      temp[i] = data[i];
    }
    mergesort(data,temp, 0, data.length);
  }
  private static void mergesort(int[]data, int[]temp, int lo, int hi){
    if(lo == hi){
      return;
    }
    int middle = (hi-lo)/2;
    mergesort(data, temp, lo, middle+1);
    mergesort(data, temp, middle, hi);
    for (int one = lo, two = middle ; middle < hi;){
      if(temp[one] < temp[two]){}
    }
  }
  public static void main(String[] args){
    int[] data = new int[]{2,3,5,3,2,3,5,6,7,44,54,5,2,2,4,5,657,67,3,2,52432,43,4,3,2,1};
    mergesort(data);
    //System.out.println();
    System.out.println(Arrays.toString(data));
  }
}
