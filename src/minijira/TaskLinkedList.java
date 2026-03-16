/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package minijira;

/**
 *
 * @author laptop
 */
class TaskLinkedList {
    private Node head;

    public TaskLinkedList() {
        this.head = null;
    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public void add(Task task) {
        if (task == null) {
            return;
        }

        Node newNode = new Node(task);

        if (head == null) {
            head = newNode;
            return;
        }

        Node current = head;
        while (current.getNext() != null) {
            current = current.getNext();
        }

        current.setNext(newNode);
    }

    public Task removeById(int id) {
        if (head == null) {
            return null;
        }

        if (head.getData().getId() == id) {
            Task removed = head.getData();
            head = head.getNext();
            return removed;
        }

        Node prev = head;
        Node current = head.getNext();

        while (current != null) {
            if (current.getData().getId() == id) {
                prev.setNext(current.getNext());
                return current.getData();
            }
            prev = current;
            current = current.getNext();
        }

        return null;
    }

    public Task searchById(int id) {
        Node current = head;

        while (current != null) {
            if (current.getData().getId() == id) {
                return current.getData();
            }
            current = current.getNext();
        }

        return null;
    }

    public void display(String label) {
        System.out.print(label + ": ");
        Node current = head;

        while (current != null) {
            System.out.print(current.getData() + " -> ");
            current = current.getNext();
        }

        System.out.println("NULL");
    }

    public boolean isEmpty() {
        return head == null;
    }
}