package tests;

import binaryTree.BinarySearchTree;
import binaryTree.BinaryTreeNode;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeTest {

    public static BinarySearchTree<Integer> tree;

    @BeforeAll
    public static void setup(){
        tree = new BinarySearchTree<>();
        tree.insert(17);
        tree.insert(12);
        tree.insert(26);
        tree.insert(40);
        tree.insert(45);
        tree.insert(47);
    }

    @Test
    void getRoot() {
        assertEquals(17, tree.getRoot().getElement());
    }

    @Test
    void setRoot() {
        tree.setRoot(new BinaryTreeNode(16));
        assertEquals(16, tree.getRoot().getElement());
    }

    @Test
    void isEmpty() {
        assertEquals(false, tree.isEmpty());
    }

    @Test
    void size() {
        assertEquals(6, tree.size());
        tree.insert(1);
        assertEquals(7, tree.size());
    }

    @Test
    void contains() {
        assertEquals(true, tree.contains(12));
        assertEquals(false, tree.contains(13));
    }

    @Test
    void inOrder() {
        ArrayList<Integer> arr = new ArrayList();
        arr.add(12);
        arr.add(17);
        arr.add(26);
        arr.add(40);
        arr.add(45);
        arr.add(47);
        assertEquals(arr, tree.inOrder());
    }

    @Test
    void preOrder() {
        ArrayList<Integer> arr = new ArrayList();
        arr.add(17);
        arr.add(12);
        arr.add(26);
        arr.add(40);
        arr.add(45);
        arr.add(47);
        assertEquals(arr, tree.preOrder());
    }

    @Test
    void postOrder() {
        ArrayList<Integer> arr = new ArrayList();
        arr.add(12);
        arr.add(47);
        arr.add(45);
        arr.add(40);
        arr.add(26);
        arr.add(17);
        assertEquals(arr, tree.postOrder());
    }

    @Test
    void levelOrder() {
        ArrayList<Integer> arr = new ArrayList();
        arr.add(17);
        arr.add(12);
        arr.add(26);
        arr.add(40);
        arr.add(45);
        arr.add(47);
        assertEquals(arr, tree.levelOrder());
    }

    @Test
    void height() {
        assertEquals(5, tree.height());
        tree.insert(49);
        assertEquals(6, tree.height());
    }

    @Test
    void insert() {
        tree.insert(49);
        assertEquals(true, tree.contains(49));
    }

    @Test
    void rebalance() {
        ArrayList<Integer> arr = new ArrayList();
        arr.add(17);
        arr.add(12);
        arr.add(40);
        arr.add(47);
        arr.add(45);
        arr.add(26);
        tree.rebalance();
        assertEquals(arr, tree.postOrder());
    }

    @Test
    void removeElement() {
        assertEquals(true, tree.contains(17));
        tree.removeElement(17);
        assertEquals(false, tree.contains(17));
    }

    @Test
    void findMin() {
        assertEquals(12, tree.findMin());
    }

    @Test
    void findMax() {
        assertEquals(47, tree.findMax());
    }
}