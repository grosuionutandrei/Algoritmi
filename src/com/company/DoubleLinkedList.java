package com.company;

public class DoubleLinkedList {
    NodeLinked firstElement;

    public DoubleLinkedList() {
        this.firstElement = null;
    }

    public NodeLinked getFirstElement() {
        return firstElement;
    }

    public void setFirstElement(NodeLinked firstElement) {
        this.firstElement = firstElement;
    }

    public static void main(String[] args) {
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        NodeLinked node = new NodeLinked(10);
        NodeLinked node1 = new NodeLinked(15);
        NodeLinked node2 = new NodeLinked(20);
        NodeLinked node3 = new NodeLinked(25);
        NodeLinked node4 = new NodeLinked(30);
        NodeLinked node5 = new NodeLinked(5);
        NodeLinked node6 = new NodeLinked(35);
        NodeLinked node7 = new NodeLinked(40);
        node.setPrevious(null);
        node.setNext(node1);
        node1.setPrevious(node);
        node1.setNext(node2);
        node2.setPrevious(node1);
        node2.setNext(node3);
        node3.setPrevious(node2);
        node3.setNext(node4);
        node4.setPrevious(node3);
        node4.setNext(null);

        doubleLinkedList.setFirstElement(node);
        printNext(doubleLinkedList);
        System.out.println();
        printPrevious(doubleLinkedList);

        insertAtBeginning(node5, doubleLinkedList);
        System.out.println();
        System.out.println("Insert at Beginning");
        printNext(doubleLinkedList);

        System.out.println();
        System.out.println("insert at the end");
        insertAtEnd(node6, doubleLinkedList);
        printNext(doubleLinkedList);

        System.out.println();
        System.out.println("insert at middle");
        insertAtMiddle(node7, node2, doubleLinkedList);
        printNext(doubleLinkedList);

        System.out.println();
        System.out.println("delete at beginning");
        deleteAtBeginning(node5, doubleLinkedList);
        printNext(doubleLinkedList);
        System.out.println();
        System.out.println("delete at end");
        deleteAtEnd(node6, doubleLinkedList);
        printNext(doubleLinkedList);

        System.out.println();
        System.out.println("delete at middle");
        deleteAtMiddle(node7,node2,doubleLinkedList);
        printNext(doubleLinkedList);




    }


    static void printNext(DoubleLinkedList doubleLinkedList) {
        NodeLinked current = doubleLinkedList.firstElement;
        while (current != null) {
            System.out.println(current.value);
            current = current.next;
        }
    }

    static void printPrevious(DoubleLinkedList doubleLinkedList) {
        NodeLinked current = doubleLinkedList.firstElement;
        NodeLinked previuous = null;
        while (current != null) {
            if (current.next == null) {
                previuous = current;
            }
            current = current.next;
        }
        while (previuous != null) {
            previuous = previuous.previous;
        }
    }

    static void insertAtBeginning(NodeLinked node, DoubleLinkedList doubleLinkedList) {
        node.setPrevious(null);
        node.setNext(doubleLinkedList.firstElement);
        doubleLinkedList.firstElement.setPrevious(node);
        doubleLinkedList.firstElement = node;
    }

    static void insertAtEnd(NodeLinked node, DoubleLinkedList doubleLinkedList) {
        NodeLinked current = doubleLinkedList.firstElement;
        while (current != null) {

            if (current.next == null) {
                current.setNext(node);
                node.setPrevious(current);
                node.setNext(null);
            }
            current = current.next;
        }
    }

    static void insertAtMiddle(NodeLinked node, NodeLinked given, DoubleLinkedList doubleLinkedList) {
        NodeLinked current = doubleLinkedList.firstElement;
        NodeLinked next = null;
        while (current != null) {
            if (current == given) {
                next = current.getNext();
                current.setNext(node);
                node.setPrevious(current);
                node.setNext(next);
                next.setPrevious(node);
                break;
            }
            current = current.next;
        }
    }

    private static void deleteAtBeginning(NodeLinked node5, DoubleLinkedList doubleLinkedList) {
        doubleLinkedList.firstElement = node5.getNext();
        node5.setNext(null);
        doubleLinkedList.firstElement.setPrevious(null);
    }

    private static void deleteAtEnd(NodeLinked node, DoubleLinkedList doubleLinkedList) {
        NodeLinked current = doubleLinkedList.getFirstElement();
        while (current != null) {
            if (current.next.getNext() == null) {
                current.next.setPrevious(null);
                current.setNext(null);
                break;
            }
            current = current.next;
        }
    }

    static void deleteAtMiddle(NodeLinked node,NodeLinked given,DoubleLinkedList doubleLinkedList){
        NodeLinked current = doubleLinkedList.getFirstElement();
        NodeLinked next = null;
        while(current!=null){
            if(current==given){
                next=current.next.getNext();
                current.next.setNext(null);
                current.next.setPrevious(null);
                current.setNext(next);
                next.setPrevious(current);
            }
            current=current.next;
        }
    }
}

class NodeLinked {
    NodeLinked previous;
    int value;
    NodeLinked next;

    public NodeLinked(int value) {
        this.value = value;
    }

    public NodeLinked getPrevious() {
        return previous;
    }

    public void setPrevious(NodeLinked previous) {
        this.previous = previous;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public NodeLinked getNext() {
        return next;
    }

    public void setNext(NodeLinked next) {
        this.next = next;
    }
}

