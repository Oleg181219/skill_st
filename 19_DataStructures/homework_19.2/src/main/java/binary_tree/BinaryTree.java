package binary_tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTree {
    private Node root;

    public void addNode(String data) {
//        если root null создаем новый
        if (root == null) {
            root = new Node(data);
        } else {
//            присваиваем родительской ноде сущ root
            Node parent = root;

            while (true) {
//                если data < parent помещаем в левую ветку
                if (data.compareTo(parent.getData()) < 0) {
//                    если с лева ноды нет, создаем новую со связями
                    if (parent.getLeft() == null) {
                        Node newNode = new Node(data);
                        newNode.setParent(parent);
                        parent.setLeft(newNode);
                        break;
                    } else {
                        parent = parent.getLeft();
                    }
                } else {
//                    работаем с правой веткой ноды
                    if (parent.getRight() == null) {
                        Node newNode = new Node(data);
                        newNode.setParent(parent);
                        parent.setRight(newNode);
                        break;
                    } else {
                        parent = parent.getRight();
                    }
                }
            }
        }
    }

    public boolean isContains(String data) {
        List<Node> resultList = new ArrayList<>();
        if (root != null) {
            Node parent = root;
            while (true) {
                if (data.compareTo(parent.getData()) < 0) {
                    Node left = parent.getLeft();
                    if (left == null) {
                        break;
                    } else {
                        parent = left;
                        continue;
                    }
                }
                if (data.compareTo(parent.getData()) >= 0) {
                    if (data.equals(parent.getData())) resultList.add(parent);
                    Node right = parent.getRight();
                    if (right == null) {
                        break;
                    } else {
                        parent = right;
                    }
                }
            }
        }
        return !resultList.isEmpty();
    }

    public Node getRoot() {
        return root;
    }
}
