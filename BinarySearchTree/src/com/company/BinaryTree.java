package com.company;

public class BinaryTree {

    Node root;

    public void addNode(String name, int key){
        Node newNode = new Node(key,name);
        if(root == null){
            this.root = newNode;
        }else{
            Node focusNode = root;
            Node parent;
            while (true){
                parent = focusNode;
                if(key<focusNode.key){
                    focusNode = focusNode.leftChild;
                    if(focusNode == null){
                        parent.leftChild = newNode;
                        return;
                    }
                }else{
                    focusNode = focusNode.rightChild;
                    if(focusNode == null){
                        parent.rightChild = newNode;
                        return;
                    }
                }
            }
        }
    }

    private Node findNode(int key){
        Node focusNode = root;
        while (focusNode.key != key){
            if(key<focusNode.key){
                focusNode = focusNode.leftChild;
            }else{
                focusNode = focusNode.rightChild;
            }

            if (focusNode == null){
                return focusNode;
            }
        }
        return focusNode;
    }

    public void inOrderTraverse(Node focusNode){
        if(focusNode != null){
            inOrderTraverse(focusNode.leftChild);
            System.out.println(focusNode);
            inOrderTraverse(focusNode.rightChild);

        }
    }

    public void preOrderTraverse(Node focusNode){
        if(focusNode != null){
            System.out.println(focusNode);
            preOrderTraverse(focusNode.leftChild);
            preOrderTraverse(focusNode.rightChild);


        }
    }

    public void postOrderTraverse(Node focusNode){
        if(focusNode != null){
            postOrderTraverse(focusNode.leftChild);
            postOrderTraverse(focusNode.rightChild);
            System.out.println(focusNode);

        }
    }

    public void find(int key){
        if(findNode(key) == null){
            System.out.println("Key not found");
        }else{
            System.out.println(findNode(key));
        }
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        tree.addNode("Boss",50);
        tree.addNode("Vice President",25);
        tree.addNode("Office Manager",15);
        tree.addNode("Secretary",30);
        tree.addNode("Sales Manager",75);
        tree.addNode("Salesman",85);

//        tree.postOrderTraverse(tree.root);
//        System.out.println("====================");
//        tree.preOrderTraverse(tree.root);
//        System.out.println("====================");
//        tree.inOrderTraverse(tree.root);

      tree.find(85);


    }

    class Node{
        int key;
        String name;

        Node leftChild = null;
        Node rightChild = null;

        public Node(int key, String name) {
            this.key = key;
            this.name = name;
        }

        public String toString(){
            return name + " has a key " + key ;
        }
    }
}
