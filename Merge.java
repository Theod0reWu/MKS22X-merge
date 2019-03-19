import java.util.Arrays;
public class Merge{
  public static void mergesort(int[]data){
    int[] temp = new int[data.length]; int max = 2;
    int l = max;
    for (int i = 0; i < data.length; i+=max){
      if (i+max > data.length){insertionSort(data,i,data.length);}
      else{insertionSort(data,i,i+max);}
    }
    System.out.println(Arrays.toString(data));
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
    mergesort(temp, data, lo, middle+1);
    mergesort(temp, data, middle, hi);
    for (int one = lo, two = middle, i = lo ; !(one >= middle && two >= hi); i++){

      if(temp[one] < temp[two]){
        data[i] = temp[one]; one++;
      }
      else if (temp[two] < temp[one]){
        data[i] = temp[two]; two++;
      }
      else {
        data[i] = temp[one];one++; i++;
        data[i] = temp[two];two++;
      }
    }
  }
  public static void insertionSort(int[] ary,int lo, int hi){
		for (int i = lo+1; i < hi; i++){
			int orig = ary[i];
			int x = i-1;
			while(x >= 0 && ary[x] > orig){
				ary[x+1] = ary[x];
				x--;
			}
			ary[x+1] = orig;
		}
}
public static void main(String[] args){
  int[] data = new int[]{4,3,2,1};
  mergesort(data);
  System.out.println(Arrays.toString(data));
}
public static void mains(String[]args){
System.out.println("Size\t\tMax Value\tquick/builtin ratio ");
int[]MAX_LIST = {1000000000,500,10};
for(int MAX : MAX_LIST){
  for(int size = 31250; size < 2000001; size*=2){
    long qtime=0;
    long btime=0;
    //average of 5 sorts.
    for(int trial = 0 ; trial <=5; trial++){
      int []data1 = new int[size];
      int []data2 = new int[size];
      for(int i = 0; i < data1.length; i++){
        data1[i] = (int)(Math.random()*MAX);
        data2[i] = data1[i];
      }
      long t1,t2;
      t1 = System.currentTimeMillis();
      mergesort(data2);
      t2 = System.currentTimeMillis();
      qtime += t2 - t1;
      t1 = System.currentTimeMillis();
      Arrays.sort(data1);
      t2 = System.currentTimeMillis();
      btime+= t2 - t1;
      if(!Arrays.equals(data1,data2)){
        System.out.println("FAIL TO SORT!");
        System.exit(0);
      }
    }
    System.out.println(size +"\t\t"+MAX+"\t"+1.0*qtime/btime);
  }
  System.out.println();
}
}
}
