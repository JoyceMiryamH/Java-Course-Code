/*
 * SinglyLinkedList 
 *
 * Created on July 19th, 2014
 * Last updated on July 24th, 2014
 *
 * Course:      1121 X
 * Assignment:  3
 */

public class SinglyLinkedList {
  
  private Node head = null;
  
  
  /** A nested static class.  
    * Linked Nodes are used to store the elements of this singly linked list.
    */
  
  private static class Node {
    
    private double value;
    private Node next;
    
    private Node( double value, Node next ) {
      this.value = value;
      this.next = next;
    }
  }
  
  /**
   * size returns the size of the singly linked list.
   *
   * @return  int 
   */
  
  public int size() {
    return size(head);
  }
  
  private int size( Node current ) {
    if ( current == null ) {
      return 0; // an empty list has size 0
    } // a non-empty list has size 1 more than the rest of the list:
    return 1 + size( current.next );
  }
  
  /**
   * empty checks to see if the singly linked list contains any elements. 
   * It returns true if the queue is empty and false otherwise.
   *
   * @return  boolean
   */
  
  public boolean empty() {
    return (head.next == null);
  }
  
  /**
   * insertAt inserts an element at a given position (first position index is 0).
   *
   * @return  void
   */
  
  public void insertAt(int pos, double value) {
    head = insertAt(head, pos, value);
  }
  
  private Node insertAt(Node elem, int skip, double value) {
    if (skip == 0) {
      return new Node(value, elem);
    }
    if (elem == null) {  
      throw new IndexOutOfBoundsException("bad index");
    }
    elem.next = insertAt(elem.next, skip - 1, value);
    return elem;
  }
  
  /**
   * addAthead adds an element at the head of the list.
   *
   * @return  void
   */
  
  public void addAtHead(double value) {
    head = addAtHead(head, value);
  }
  
  private Node addAtHead(Node elem, double value) {
    if(elem == null) {
      return new Node(value, null);
    } else {
      Node temp = new Node(value, null);
      temp.next = head;
      head = temp;
      return head;
    }
  }
  
  /**
   * addAtEnd adds an element at the end of the list.
   *
   * @return  void
   */
  public void addAtEnd(double value) {
    head = addAtEnd(head, value);
  }
  
  private Node addAtEnd(Node elem, double value) {
    if(elem == null) {
      return new Node(value, null);
    }
    elem.next = addAtEnd(elem.next, value);
    return elem;
  }
  
  /**
   * replace takes two elements as an input, 
   * searches for the first and replaces it with the second. 
   *
   * @return  void
   */
  
  public void replace(double first, double second) {
    Node current = head;
    if ( current == null ) {
      throw new IllegalStateException();
    } else while(current != null) {
      if (current.value == first) {
        current.value = second;
        break;
      }
      current = current.next;
    }
  }
  
  /**
   * duplicate is a recursive method to duplicate every element in a linked list,
   * that is equal to a certain value. For example, if the linked list contains 4, 8, 4, 10
   * the element to duplicate is 4 the new list should contain 4,4,8,4,4, 10.
   *
   * @return  void
   */ 
  
  public void duplicate(double value) {
    if ( head == null ) {
      throw new IllegalStateException();
    } else { 
      duplicate(value, head);
    }
  }
  
  private boolean duplicate(double value, Node elem) {
    boolean result=false;
    if(elem.value==value)
    {
      Node temp=new Node(elem.value, elem.next);
      elem.next=temp;
      
      result=true;
      
      if(temp.next!=null)
      {
        
        return duplicate(value, temp.next);
      }
      else
      {
        return result;
      }
    }
    else if (elem.next==null)
    {
      return result;
    }
    else
    {
      return duplicate(value, elem.next);
    }
  }
  /**
   * reverse is a recursive method that prints out the data elements of a linked list in reverse order
   *
   * @return  void
   */
  
  public void reverse() {
    reverse(head);
  }
  
  private void reverse(Node elem) {
    if(elem.next != null) { 
      reverse(elem.next);  
    }
    System.out.println(elem.value);
  }
  
  /**
   * countGreaterThan is a recursive method that returns a count of
   * the number of elements greater than a given threshold value. 
   *
   * @return  void
   */
  
  public int countGreaterThan(double num) {
    return countGreaterThan(num, head);
  }
  
  private int countGreaterThan(double num, Node elem) {
    int count = 0;
    if (elem == null) {
      return count;
    }
    if (elem.value > num) {
      return 1 + countGreaterThan(num, elem.next);
    } else {
      return countGreaterThan(num, elem.next);
    }
  }
}
