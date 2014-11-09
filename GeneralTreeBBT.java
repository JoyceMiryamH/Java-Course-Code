package assignment2;
import java.util.Iterator;


public class GeneralTreeBBT<E> implements Tree<E> {
  
  private LinkedBinaryTree<E> bTree = new LinkedBinaryTree(); // reference to the binary tree
  
  /**  Creates an empty  tree. */
  public GeneralTreeBBT() {
    bTree.root = null;  // start with an empty tree
  }
  
  
  /** Returns the number of nodes in the tree. */
  public int size() {
    return bTree.size();
  }
  
  
  /** Returns whether the tree is empty. */
  public boolean isEmpty() {
    return bTree.isEmpty();
  }
  
  
  /** Returns an iterable collection of the nodes. */
  public Iterable<Position<E>> positions(){
    return bTree.positions();
  }
  /** Returns an iterator of the elements stored in the tree. */
  public Iterator<E> iterator() {
    return bTree.iterator();
  }
  /** Replaces the element stored at a given node. */
  public E set(Position<E> v, E e)
    throws InvalidPositionException {
    return bTree.set(v, e);
    
  }
  
  /** Returns the root of the tree. */
  public Position<E> root() {
    return bTree.root();
    
  }
  
  /** Returns the root of the tree  */
  public Position<E> addRoot(E e) {
    return bTree.addRoot(e);
    
  }
  

  /** Returns the parent of a given node or the node itself if it is the root */
  public Position<E> parent(Position<E> v) {
    if(bTree.isRoot(v)) {
      System.out.print("The root of the tree is ");
      return (v);
    } 
    if (bTree.left(bTree.parent(v))!=null && bTree.right(bTree.parent(v))!=v )
    {
      return(bTree.parent(v));
    }
    else
    {
      v = bTree.parent(v);
      return(parent(v));
    }
  }
  
  
//creates a child of  v that comes to the right of the last child
  public Position<E>  insertChild(Position<E> v, E e) throws InvalidPositionException{
    Position<E> ww;
    if ((bTree.left(v))==null)
      ww=bTree.addLeft(v, e);
    else {
      ww=bTree.left(v);
      while ((bTree.right(ww))!=null){
        ww=bTree.right(ww);
      }
      ww= bTree.addRight(ww, e);
    }
    
    return(ww);
  }
