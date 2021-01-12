public class MyLinkedList{
 private int size;
 private Node start,end;

 public MyLinkedList(){
   size = 0;
   start = null;
   end = null;}

 public int size(){
   return size;
 }

 public boolean add(String _value){
   Node extra = new Node(_value);
   if (size == 0) {
     start = extra;
     end = extra;
   } else {
     extra.setPrev(end);
     end.setNext(extra);
     end = extra;
   }
   size++;
   return true;
 }

 public void add(int index, String value){
   if (index < 0 || index > size){
     throw new IndexOutOfBoundsException("Index out of range!");
   }
   Node extra = new Node(value);
   Node temp = new Node(null);
   if (size==0){
     start=extra;
     end=extra;
   } else if(index == size){
     temp=end;
     temp.setNext(extra);
     extra.setPrev(temp);
     end=extra;
   } else if(index == 0){
     temp=start;
     extra.setNext(temp);
     start=extra;
     temp.setPrev(start);
   } else{
     Node newNext = getNode(index);
     Node newPrev = getNode(index-1);
     extra.setNext(newNext);
     extra.setPrev(newPrev);
     newPrev.setNext(extra);
     newNext.setPrev(extra);
   }
    size++;
 }

 public String get(int index){
   Node current = start;
    for (int i = 0; i < index; i++) {
      current = current.getNext();
      if (current == null) {
        return "null";
      }
    }
    return current.getData();
 }

 public String set(int _index, String _value){
    String previous = get(_index);
    getNode(_index).setData(_value);
    return previous;
 }

 public String toString(){
   Node current = start;
   if (size == 0){
     return "[]";
   }
   String returned = "[";
    while (current != null && current !=end) {
      returned += current.getData() + ", ";
      current = current.getNext();
    }
    return returned.substring(0, returned.length() - 1) + "]";
 }
 public String toStringReversed(){
   Node current = end;
   if (size == 0){
     return "[]";
   }
   String toString = "[";
   while (current != null) {
     toString += current.getData();
     current = current.getPrev();
     if(current != null && current != start){
       toString += ", ";
     }
   }
    return toString + "]";
 }

 public void extend(MyLinkedList other){
   if(size == 0){
     this.start = other.start;
       if(other.size <= 1){
         this.end = this.start;
       } else{
         this.end = other.end;
       }
   } else{
     this.end.setNext(other.start);
     if(other.size > 0){
       other.start.setPrev(this.end);
       this.end = other.end;
     }
   }
   this.size += other.size;
   other.end = null;
   other.start = null;
   other.size = 0;
 }

 public String remove(int index) {
   if (index < 0 || index >= size) {
    throw new IndexOutOfBoundsException("Index out of Range!");
   }
   String returned = get(index);
   Node before = getNode(index-1);
   Node after = getNode(index+1);
   if(size == 1){
     start = null;
   } else if(index == 0){
     start = after;
   } else if(index == size()-1){
     end = before;
   } else {
     before.setNext(after);
     after.setPrev(before);
   }
   size();
   return returned;
 }


 //Any helper method that returns a Node object MUST BE PRIVATE!

 private Node getNode(int _index) {
        Node current = start;
        for (int i = 0; i < _index; i++) {
            current = current.getNext();
        }

        return current;
    }
}
