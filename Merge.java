import java.util.*;
public class Merge{
  public static void mergesort(int[]data){
    int[] temp = new int[data.length]; int max = 80;
    //if (data.length < 20) {max = 4;}
    int l = max;
    for (int i = 0 ; i < data.length; i+=max){
      if (i+max <= data.length) {insertionSort(data,i,i+max);}
      else{insertionSort(data,i,data.length);}
    }
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
      }
      l*=2;
    }
    if(mergeTo != data){
      for (int i = 0; i< data.length; i++){
        data[i] = mergeTo[i];
      }
    }
  }
  public static void insertionSort(int[] ary,int lo, int hi){ //System.out.println(lo+":"+hi);
    for (int i = lo+1; i < hi; i++){
      int orig = ary[i];
      int x = i-1;
      while(x >= lo && ary[x] > orig){
        ary[x+1] = ary[x];
        x--;
      }
      ary[x+1] = orig;
    }//System.out.println(Arrays.toString(ary));
  }
  System.out.println();
}
}
}
