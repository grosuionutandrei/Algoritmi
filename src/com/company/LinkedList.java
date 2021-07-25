package com.company;


public class LinkedList {
    Node firstElement;

    public LinkedList() {
        this.firstElement = null;
    }

    public Node getFirstElement() {
        return firstElement;
    }

    public void setFirstElement(Node firstElement) {
        this.firstElement = firstElement;
    }

    public static void main(String[] args) {


        Node node1 = new Node(10);
        Node node2 = new Node(123);
        Node node3 = new Node(124);
        Node node4 = new Node(12);
        Node node5 = new Node(34);
        Node node = new Node(45);
        Node node6 = new Node(890);
        Node node7 = new Node(7899);

        LinkedList linkedList = new LinkedList();
        linkedList.firstElement = node1;
        node1.setNextElement(node2);
        node2.setNextElement(node3);
        node3.setNextElement(node4);
        node4.setNextElement(node5);
        node5.setNextElement(null);

        print(linkedList);

        insertAtBeginning(node, linkedList);
        System.out.println();
        System.out.println("insert in the beginning");
        print(linkedList);

        insertAtTheEnd(node6, linkedList);
        System.out.println();
        System.out.println("insert at the end");
        print(linkedList);

        insertAtAnGivenElement(node7, node3, linkedList);
        System.out.println();
        System.out.println("insert in the middle");
        print(linkedList);

        deleteAtBeginning(linkedList);
        System.out.println();
        System.out.println("deleteAtBeginning");
        print(linkedList);

        deleteAtTheEnd(linkedList);
        System.out.println();
        System.out.println("delete at the end");
        print(linkedList);

        deleteInTheMiddle(node3, linkedList);
        System.out.println();
        System.out.println("delete in the middle");
        print(linkedList);

    }

    static void insertAtBeginning(Node node, LinkedList linkedList) {
        Node temp = linkedList.firstElement;
        linkedList.firstElement = node;
        node.setNextElement(temp);
    }


    static void insertAtTheEnd(Node node, LinkedList linkedList) {
        Node current = linkedList.firstElement;
        while (current != null) {
            if (current.nextElement == null) {
                current.setNextElement(node);
                break;
            }
            current = current.nextElement;
        }
    }

    static void insertAtAnGivenElement(Node node, Node given, LinkedList linkedList) {
        Node current = linkedList.firstElement;
        Node after = null;
        while (current != given) {
            current = current.nextElement;
            if (current.equals(given)) {
                after = given.nextElement;
            }
        }
        current.setNextElement(node);
        node.setNextElement(after);
    }


    static void deleteAtBeginning(LinkedList linkedList) {
        Node after = linkedList.firstElement.nextElement;
        linkedList.setFirstElement(null);
        linkedList.firstElement = after;
    }

    static void deleteAtTheEnd(LinkedList linkedList) {
        Node current = linkedList.firstElement;
        while (current != null) {
            if (current.nextElement.getNextElement() == null) {
                current.setNextElement(null);
                break;
            }
            current = current.nextElement;
        }
    }

    static void deleteInTheMiddle(Node given, LinkedList linkedList) {
        Node current = linkedList.firstElement;
        Node after = null;
        while (current != given) {
            current = current.nextElement;
            if (current == given) {
                after = current.nextElement.getNextElement();

            }
        }
        current.setNextElement(after);


    }

    static void print(LinkedList linkedList) {
        Node currentElement = linkedList.firstElement;
        while (currentElement != null) {
            System.out.println(currentElement.value);
            currentElement = currentElement.nextElement;
        }
    }


}

class Node {
    int value;
    Node nextElement;


    public Node(int value) {
        this.value = value;

    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getNextElement() {
        return nextElement;
    }

    public void setNextElement(Node nextElement) {
        this.nextElement = nextElement;
    }
}