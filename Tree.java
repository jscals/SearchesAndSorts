public class Tree<T extends Comparable<T>>{	
	
    private Node<T> head;
    private int n; // the n-ary degree, defaults to binary if none given.
    
    public Tree(Node<T> head, int n){
        this.head = head;
        this.n = n;
    }
    public Tree(Node<T> head){
        this(head,2);
    }
    public Tree(int n){
        this(null,n);
    }
    public Tree(){
        this(null,2);
    }
    
    
    public Node<T> getHead(){
        return this.head;
    }
    
    public void setHead(Node<T> head){
        this.head = head;
    }
    
    public int getN(){
        return this.n;
    }

    
    /* 
    * Method that checks to see if tree contains target.
    * Uses recursive helper function cycleTree. 
    *
    * @param target: The target to check the tree for of type T. 
    * @return true - if the target is found.
    *         false - if target not found.
    */
    public boolean contains(Node<T> target){
            Node<T> result = cycleTree(head, target);
            return result != null;
    }
    
    
    /* 
    * Method that finds a target within the tree.
    * Uses recursive helper function cycleTree. 
    *
    * @param target: The target to search for of type T. 
    * @return returns the node if found.
    *         returns null value otherwise. 
    */
    public Node<T> find(Node<T> target){
            return cycleTree(head, target);
    }
    

    /* 
    * Recursive function that goes through each child of parameter parentNode 
    * and checks for target.
    * If child is not target, recursively calls function with it as new parentNode. 
    * 
    * @param parentNode The parent node to  start searching from.
    * @param target The target node to search for.
    * @return The Node if found, null if not. 
    */
    private Node<T> cycleTree(Node<T> parentNode, Node<T> target){
            Node<T> success = null;

            for(Node<T> node : parentNode.getChildren()){

                    if(node.getValue().equals(target.getValue())){
                            return node;
                    }
                    Node<T> result = cycleTree(node, target);
                    if(result != null){
                            success = result;
                    }
            }
            return success; 
    }	
}

