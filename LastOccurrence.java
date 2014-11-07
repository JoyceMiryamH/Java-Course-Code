/*
 * LastOccurrence
 *
 * Created on July 19th, 2014
 * Last updated on July 19th, 2014
 *
 * Name:        Joyce Habbouche
 * ID:          7433066
 * Course:      1121 X
 * Assignment:  3
 */

public class LastOccurrence {
  
  public static int lastOccurrence( int[] t, int searched ) {
    return lastOccurrence( t, searched, t.length-1 );
  }
  
  private static int lastOccurrence( int[] t, int searched, int k ) {
    int result = -1;
    if( t[k] == searched ) { // Base case
      result = k;
    }
    else { // General case
      k--;
      if ( k == 0 ) { 
        return result;
      } else {
        result = lastOccurrence( t, searched, k ); // recursive call
      }
    }
    return result;
  }
  
  public static void main (String[] args) {
    int[] array = {5, 3, 7, 2, 4, 3, 7, 8};
    int searched = 7;
    System.out.println("The last occurence of this number was at position "+lastOccurrence(array, searched)+".");
  }
}
