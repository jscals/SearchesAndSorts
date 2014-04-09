import java.util.Stack;
import java.util.LinkedList;
import java.util.Queue;

public class TreeSearches<T extends Comparable<T>>{

    /*
    * Method that finds a given target in a generic tree using the 
    * Breadth First Search algorithm.
    *
    * Average, Worst - O(n) where n is the number of nodes in the tree.
    *
    * @param tree: The tree to search through.
    * @param target: The target node to find within the tree.
    * @return if found, returns the target node.
    *         if not found, returns null.
    *
    */
    public Node<T> BreadthFirstSearch(Tree<T> tree, Node<T> target){
    	Queue<Node<T>> nodes = new LinkedList<Node<T>>();
        nodes.add(tree.getHead());
        
        while(nodes.size() != 0){
            Node<T> current = nodes.poll();
            
            if(current.getValue().equals(target)){
                return current;
            }
            
            for(Node<T> child : current.getChildren()){
                nodes.add(child);
            }
        }
        return null;
    }
    
    /*
    * Method that finds a given target in a generic tree using the 
    * Depth First Search algorithm.
    *
    * Average, Worst - O(n) where n is the number of nodes in the tree.
    *
    * @param tree: The tree to search through.
    * @param target: The target node to find within the tree.
    * @return if found, returns the target node.
    *         if not found, returns null.
    */
    public Node<T> DepthFirstSeach(Tree<T> tree, Node<T> target){
    	Stack<Node<T>> nodes = new Stack<Node<T>>();
        nodes.add(tree.getHead());
        
        while(nodes.size() != 0){
            Node<T> current = nodes.pop();
            
            if(current.getValue().equals(target)){
                return current;
            }
            
            for(Node<T> child : current.getChildren()){
                nodes.add(child);
            }
        }
        return null;
    }
    
}
