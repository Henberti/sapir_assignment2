public class Queue<T> {
    private Node<T> first, last;

    public Queue(){
        first = last = null;
    }

    public boolean isEmpty(){
        return first == null;
    }
    public void enQueue(T data){
        Node<T> temp = new Node<>(data);

        if(isEmpty())
            first = last = temp;
        else{
            last.setNext(temp);
            last = last.getNext();
        }
    }
    public T deQueue(){
        if(isEmpty())
            return null;

        T temp = first.getData();
        first = first.getNext();
        if(isEmpty()){
            last = null;
        }
        return temp;
    }
    @Override
    public String toString() {
        if(!isEmpty())
            return first.toString();
        else 
        return "";
    }

}
