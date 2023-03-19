package binaryTree;

import java.util.Objects;

public class BinaryTreeNode<E>{
    private E element;
    private BinaryTreeNode rightChild;
    private BinaryTreeNode leftChild;

    public BinaryTreeNode(E element) {
        this.element = element;
    }

    public void setElement(E element){
        this.element = element;
    }

    public E getElement(){
        return element;
    }

    public void addLeftChild(BinaryTreeNode node){
        this.leftChild = node;
    }

    public void addRightChild(BinaryTreeNode node){
        this.rightChild = node;
    }

    public BinaryTreeNode getLeftChild(){
        return leftChild;
    }

    public BinaryTreeNode getRightChild(){
        return rightChild;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BinaryTreeNode<?> node = (BinaryTreeNode<?>) o;
        return element.equals(node.element);
    }

    @Override
    public int hashCode() {
        return Objects.hash(element);
    }
}
