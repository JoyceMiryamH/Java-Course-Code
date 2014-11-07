/*
 * SumValuesArray
 *
 * Created on July 19th, 2014
 * Last updated on July 19th, 2014
 *
 * Course:      1121 X
 * Assignment:  3
 */

public class SumValuesArray {
  
  public static int sum( int[] t ) {
    return sum( t, 0 );
  }
  
  private static int sum( int[] t, int k ) {
    int s, result, length = t.length - k;
    if ( length == 1 ) { // Base case
      result = t[ k ];
    } else { // General case
      int k1 = k+1;
      s = sum( t, k1 );
      result = t[ k ] + s;
    }
    return result;
  }
  
  public static void main (String[] args) {
    int[] array = {5, 3, 4, 2, 3, 2, 8};
    System.out.println("The sum of all values stored in this array is "+ sum(array)+"." );
  }
}
