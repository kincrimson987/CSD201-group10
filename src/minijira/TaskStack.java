/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package minijira;

/**
 *
 * @author laptop
 */
class TaskStack {
    private Node top;

    public TaskStack() {
        this.top = null;
    }

    public Node getTop() {
        return top;
    }

    public void setTop(Node top) {
        this.top = top;
    }

    public void push(Task task) {
        if (task == null) {
            return;
        }

        Node newNode = new Node(task);
        newNode.setNext(top);
        top = newNode;
    }

    public Task pop() {
        if (top == null) {
            return null;
        }

        Task task = top.getData();
        top = top.getNext();
        return task;
    }

    public boolean isEmpty() {
        return top == null;
    }
}