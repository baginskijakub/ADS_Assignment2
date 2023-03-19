package binaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree<E> {
    private BinaryTreeNode root;
    public int size = 0;
    private ArrayList utilityArray;

    public BinaryTreeNode getRoot(){
        return root;
    }

    public void setRoot(BinaryTreeNode node){
        this.root = node;
    }

    public boolean isEmpty(){
        if(root == null) return true;
        return false;
    }

    public int size(){
        return size;
    }

    public boolean contains(E element)
    {
        if (root.getElement() == element)
        {
            return true;
        }
        else
        {
            return contains(element, root.getLeftChild()) || contains(element, root.getRightChild());
        }
    }

    private boolean contains(E element, BinaryTreeNode node)
    {
        if (node == null)
            return false;
        if (node.getElement() == element)
        {
            return true;
        }
        else
        {
            return contains(element, node.getLeftChild()) || contains(element, node.getRightChild());
        }
    }

    public ArrayList<E> inOrder(){
        utilityArray = new ArrayList<E>();
        if(root.getLeftChild() != null){
            inOrder(root.getLeftChild());
        }
        if(root != null){
            utilityArray.add(root.getElement());
        }
        if(root.getRightChild() != null){
            inOrder(root.getRightChild());
        }
        return utilityArray;
    }

    private void inOrder(BinaryTreeNode node){
        if(node.getLeftChild() != null){
            inOrder(node.getLeftChild());
        }
        if(node != null){
            utilityArray.add(node.getElement());
        }
        if(node.getRightChild() != null){
            inOrder(node.getRightChild());
        }
    }


    public ArrayList <E> preOrder(){
        utilityArray = new ArrayList<E>();
        if(root != null){
            System.out.println("co do chuja");
            utilityArray.add(root.getElement());
        }
        if(root.getLeftChild() != null){
            System.out.println("co do chuja2");
            preOrder(root.getLeftChild());
        }
        if(root.getRightChild() != null){
            preOrder(root.getRightChild());
        }
        return utilityArray;
    }

    private void preOrder(BinaryTreeNode node){
        if(node != null){
            utilityArray.add(node.getElement());
        }
        if(node.getLeftChild() != null){
            preOrder(node.getLeftChild());
        }
        if(node.getRightChild() != null){
            preOrder(node.getRightChild());
        }
    }

    public ArrayList <E> postOrder(){
        utilityArray = new ArrayList<E>();
        if(root.getLeftChild() != null){
            postOrder(root.getLeftChild());
        }
        if(root.getRightChild() != null){
            postOrder(root.getRightChild());
        }
        if(root != null){
            utilityArray.add(root.getElement());
        }
        return utilityArray;
    }

    private void postOrder(BinaryTreeNode node){
        if(node.getLeftChild() != null){
            postOrder(node.getLeftChild());
        }
        if(node.getRightChild() != null){
            postOrder(node.getRightChild());
        }
        if(node != null){
            utilityArray.add(node.getElement());
        }
    }

    public ArrayList <E> levelOrder(){
        utilityArray = new ArrayList<E>();
        Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            BinaryTreeNode tempNode = queue.poll();
            utilityArray.add(tempNode.getElement());
            /*add left child to the queue */
            if (tempNode.getLeftChild() != null) {
                queue.add(tempNode.getLeftChild());
            }

            /*add right child to the queue */
            if (tempNode.getRightChild() != null) {
                queue.add(tempNode.getRightChild());
            }
        }
        return utilityArray;
    }

    public int height(){
        if(root == null) {
            return 0;
        }
        else {
            int leftHeight = 0, rightHeight = 0;

            if(root.getLeftChild() != null)
                leftHeight = height(root.getLeftChild());

            if(root.getRightChild() != null)
                rightHeight = height(root.getRightChild());

            int max = (leftHeight > rightHeight) ? leftHeight : rightHeight;

            return (max + 1);
        }
    }

    public int height(BinaryTreeNode node){
            int leftHeight = 0, rightHeight = 0;

            if(node.getLeftChild() != null)
                leftHeight = height(node.getLeftChild());

            if(node.getRightChild() != null)
                rightHeight = height(node.getRightChild());

            int max = (leftHeight > rightHeight) ? leftHeight : rightHeight;

            return (max + 1);
    }
}
