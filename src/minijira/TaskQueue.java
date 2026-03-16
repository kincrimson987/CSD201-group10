    /*
     * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
     * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
     */
    package minijira;

    /**
     *
     * @author laptop
     */
   class TaskQueue {
    private Node front;
    private Node rear;

    public TaskQueue() {
        this.front = null;
        this.rear = null;
    }

    public Node getFront() {
        return front;
    }

    public void setFront(Node front) {
        this.front = front;
    }

    public Node getRear() {
        return rear;
    }

    public void setRear(Node rear) {
        this.rear = rear;
    }

    public void enqueue(Task task) {
        if (task == null) {
            return;
        }

        Node newNode = new Node(task);

        if (rear == null) {
            front = newNode;
            rear = newNode;
            return;
        }

        rear.setNext(newNode);
        rear = newNode;
    }

    public Task dequeue() {
        if (front == null) {
            return null;
        }

        Task task = front.getData();
        front = front.getNext();

        if (front == null) {
            rear = null;
        }

        return task;
    }

    public boolean isEmpty() {
        return front == null;
    }
}
