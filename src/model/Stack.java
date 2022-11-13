package model;

//TODO 01: Umsetzung der Klasse Stack gemäß der Dokumentations des Landes.
public class Stack<ContentType> {

    private class Node{
        private Node next;
        private ContentType content;

        public Node(ContentType content){
            next = null;
            this.content = content;
        }

        public Node getNext(){
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public ContentType getContent(){
            return content;
        }
    }

    private Node top;

    public Stack(){
        top = null;
    }

    public boolean isEmpty(){
        return top == null;
    }

    public void push(ContentType content){
        Node newNode = new Node(content);
        newNode.setNext(top);
        top = newNode;
    }

    public void pop(){
        if(!isEmpty()){
            top = top.getNext();
        }
    }

    public ContentType top(){
        if(!isEmpty()) {
            return top.getContent();
        }
        return null;
    }
}
