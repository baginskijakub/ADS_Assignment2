package tests;

import binaryTree.BinaryTreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeNodeTest {
    public static BinaryTreeNode node;

    @BeforeAll
    public static void setup(){
        node = new BinaryTreeNode<>(1);
    }

    @org.junit.jupiter.api.Test
    void setElement() {
        node.setElement(2);
        Assertions.assertEquals(2, node.getElement());
    }

    @org.junit.jupiter.api.Test
    void getElement() {
        Assertions.assertEquals(1, node.getElement());
    }

    @org.junit.jupiter.api.Test
    void addLeftChild() {
        BinaryTreeNode node = new BinaryTreeNode(3);
        node.addLeftChild(node);
        Assertions.assertEquals(node, node.getLeftChild());
    }

    @org.junit.jupiter.api.Test
    void addRightChild() {
        BinaryTreeNode node = new BinaryTreeNode(3);
        node.addRightChild(node);
        Assertions.assertEquals(node, node.getRightChild());
    }

    @org.junit.jupiter.api.Test
    void getLeftChild() {
        BinaryTreeNode node = new BinaryTreeNode(3);
        node.addLeftChild(node);
        Assertions.assertEquals(node, node.getLeftChild());
    }

    @org.junit.jupiter.api.Test
    void getRightChild() {
        BinaryTreeNode node = new BinaryTreeNode(3);
        node.addRightChild(node);
        Assertions.assertEquals(node, node.getRightChild());
    }
}