public class Queue<T> {
    Node<T> first, last;


    public Queue(){
        first = last =null;
    }
    public void equeu(T data){
        Node<T> temp = new Node<>(data);
        if(isEmpty())
            first = last = temp;
        else{
            last.setNext(temp);
            last = last.getNext();
        }
    }
    public boolean isEmpty(){
        return first == null;
    }
    public T dequeue(){
        if(isEmpty())
            return null;

        T temp = first.getData();
        first = first.getNext();
        if(isEmpty())
            last = null;
        return temp;
    }
    
}
