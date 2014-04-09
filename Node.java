import java.util.LinkedList; 

class Node<T extends Comparable<T>>{
    private T value;
    private Node<T> parent;
    private LinkedList<Node<T>> children;

    public Node(T value){
            this.value = value;
            this.parent = null;
            this.children = new LinkedList<Node<T>>(); 
    }

    public T getValue(){
        return this.value;
    }
    
    public void setValue(T value){
        this.value = value;
    }
    
    public LinkedList<Node<T>> getChildren(){
        return this.children;
    }
    
    public boolean equals(Node<T> node){
        return this.value.equals(node.getValue());
    }

    public void addChild(Node<T> child){
            child.parent = this;
            this.children.add(child);
    }

    public boolean hasChild(Node<T> child){
            return this.children.contains(child);
    }

    public boolean hasChildren(){
            return (this.children.size() > 0);
    }

    public Node<T> getChild(Node<T> child){
            return this.children.get(this.children.indexOf(child));
    }
}