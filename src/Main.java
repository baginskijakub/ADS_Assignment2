import binaryTree.BinarySearchTree;
import binaryTree.BinaryTreeNode;
import binaryTree.BinaryTreePrint;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree<>();
        tree.insert(17);
        tree.insert(12);
        tree.insert(26);
        tree.insert(40);
        tree.insert(45);
        tree.insert(47);
        ArrayList<Integer> arr2 = tree.inOrder();
        for(int elem : arr2){
            System.out.println(elem);
        }

        BinaryTreePrint print = new BinaryTreePrint();
        print.printTree(tree.getRoot());
        tree.rebalance();
        print.printTree(tree.getRoot());


    }

}