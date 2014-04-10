import java.util.LinkedList; 
import java.util.Objects;

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
    
    @Override
    public boolean equals(Object obj){
        if(obj instanceof Node){
            Node<T> node = (Node<T>) obj;
            return this.value.equals(node.getValue());
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.value);
        hash = 89 * hash + Objects.hashCode(this.parent);
        hash = 89 * hash + Objects.hashCode(this.children);
        return hash;
    }
    
    @Override 
    public String toString(){
        return this.value.toString();
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