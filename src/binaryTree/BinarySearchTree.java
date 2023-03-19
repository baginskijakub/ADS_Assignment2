package binaryTree;

import java.util.ArrayList;

public class BinarySearchTree<E extends Comparable<E>> extends BinaryTree<E> {

    private E element;

    public boolean insert(E element)
    {
        if (getRoot() == null)
        {
            setRoot(new BinaryTreeNode(element));
            size++;
            return true;
        }
        return insert(getRoot(), element);
    }

    private boolean insert(BinaryTreeNode<E> node, E element) {
        if (element.compareTo(node.getElement()) == 0) {
            return false; // Element already in the tree
        } else if (element.compareTo(node.getElement()) < 0) {
            if (node.getLeftChild() == null) {
                node.addLeftChild(new BinaryTreeNode(element));
                size++;
                return true;
            } else {
                return insert(node.getLeftChild(), element);

            }
        } else {
            if (node.getRightChild() == null) {
                node.addRightChild(new BinaryTreeNode(element));
                size++;
                return true;
            } else {
                return insert(node.getRightChild(), element);
            }
        }
    }

    public void rebalance() {
        // Create a list of all the elements in the tree
        ArrayList<E> elements = inOrder();

        // Rebuild the tree with the elements in the list
        setRoot(buildBalancedTree(elements, 0, elements.size() - 1));
    }
    private BinaryTreeNode<E> buildBalancedTree(ArrayList<E> elements, int start, int end) {
        if (start > end) {
            // Base case: no elements to add
            return null;
        }

        // Find the middle element and create a new node
        int mid = (start + end) / 2;
        BinaryTreeNode<E> node = new BinaryTreeNode<>(elements.get(mid));

        // Recursively build the left and right subtrees
        node.addLeftChild(buildBalancedTree(elements, start, mid - 1));
        node.addRightChild(buildBalancedTree(elements, mid + 1, end));
        return node;
    }

    public boolean removeElement(E element) {
        if (isEmpty()) {
            return false;
        }
        BinaryTreeNode<E> currentNode = getRoot();
        BinaryTreeNode<E> parentNode = null;
        boolean isLeftChild = false;

        // Traverse the tree to find the node to be removed
        while (currentNode != null && !currentNode.getElement().equals(element)) {
            parentNode = currentNode;
            if (element.compareTo(currentNode.getElement()) < 0) {
                currentNode = currentNode.getLeftChild();
                isLeftChild = true;
            } else {
                currentNode = currentNode.getRightChild();
                isLeftChild = false;
            }
        }

        // If the node is not found, return false
        if (currentNode == null) {
            return false;
        }

        // If the node has no children, simply remove it
        if (currentNode.getLeftChild() == null && currentNode.getRightChild() == null) {
            if (currentNode == getRoot()) {
                setRoot(null);
            } else if (isLeftChild) {
                parentNode.addLeftChild(null);
            } else {
                parentNode.addRightChild(null);
            }
        }
        // If the node has only one child, replace it with the child
        else if (currentNode.getLeftChild() == null) {
            if (currentNode == getRoot()) {
                setRoot(currentNode.getRightChild());
            } else if (isLeftChild) {
                parentNode.addLeftChild(currentNode.getRightChild());
            } else {
                parentNode.addRightChild(currentNode.getRightChild());
            }
        } else if (currentNode.getRightChild() == null) {
            if (currentNode == getRoot()) {
                setRoot(currentNode.getLeftChild());
            } else if (isLeftChild) {
                parentNode.addLeftChild(currentNode.getLeftChild());
            } else {
                parentNode.addRightChild(currentNode.getLeftChild());
            }
        }
        // If the node has two children, replace it with the inorder successor
        else {
            BinaryTreeNode<E> successor = getSuccessor(currentNode);
            successor.addLeftChild(currentNode.getLeftChild());
            if (currentNode == getRoot()) {
                setRoot(successor);
            } else if (isLeftChild) {
                parentNode.addLeftChild(successor);
            } else {
                parentNode.addRightChild(successor);
            }
        }
        return true;
    }

    private BinaryTreeNode<E> getSuccessor(BinaryTreeNode<E> node) {
        BinaryTreeNode<E> successor = null;
        BinaryTreeNode<E> successorParent = null;
        BinaryTreeNode<E> current = node.getRightChild();
        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.getLeftChild();
        }
        if (successor != node.getRightChild()) {
            successorParent.addLeftChild(successor.getRightChild());
            successor.addRightChild(node.getRightChild());
        }
        return successor;
    }

    public E findMin() {
        if (getRoot() == null) {
            return null;
        } else {
            return (E) findMin(getRoot());
        }
    }

    // Helper method to find the minimum element recursively
    private E findMin(BinaryTreeNode<E> node) {
        if (node.getLeftChild() == null) {
            return node.getElement();
        } else {
            return (E) findMin(node.getLeftChild());
        }
    }

    public E findMax() {
        if (getRoot() == null) {
            return null;
        } else {
            return (E) findMax(getRoot());
        }
    }

    // Helper method to find the minimum element recursively
    private E findMax(BinaryTreeNode<E> node) {
        if (node.getRightChild() == null) {
            return node.getElement();
        } else {
            return (E) findMax(node.getRightChild());
        }
    }
}
