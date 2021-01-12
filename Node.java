public class Node{
 public Node(String _value){
   this.data = _value;
   }
 private String data;
 private Node next,prev;

 public String getData(){
    return data;
  }

  public Node getNext(){
    return next;
  }

  public Node getPrev(){
    return prev;
  }

  public void setData(String _data){
    this.data = _data;
  }

  public void setNext(Node _next){
    this.next = _next;
  }

  public void setPrev(Node _prev){
    this.prev = _prev;
  }
}
