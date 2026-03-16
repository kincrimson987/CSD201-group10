/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package minijira;
import java.util.Random;
/**
 *
 * @author laptop
 */

public class MiniJira {
    public static void main(String[] args) {
        TaskLinkedList todo = new TaskLinkedList();
        TaskLinkedList doing = new TaskLinkedList();
        TaskLinkedList done = new TaskLinkedList(); // hiện chưa dùng

        todo.add(new Task(1, "Design UI"));
        todo.add(new Task(2, "Build Backend"));
        todo.add(new Task(3, "Write Test"));

        System.out.println("=== LINKED LIST TEST ===");
        todo.display("TODO");

        Task movedTask = todo.removeById(2);
        if (movedTask != null) {
            doing.add(movedTask);
        }

        todo.display("TODO");
        doing.display("DOING");

        System.out.println("\n=== STACK (UNDO) TEST ===");
        TaskStack undoStack = new TaskStack();
        undoStack.push(movedTask);

        Task undoneTask = undoStack.pop();
        if (undoneTask != null) {
            todo.add(undoneTask);
        }

        todo.display("TODO after UNDO");

        System.out.println("\n=== QUEUE TEST ===");
        TaskQueue queue = new TaskQueue();
        queue.enqueue(new Task(4, "Deploy"));
        queue.enqueue(new Task(5, "Fix Bug"));

        System.out.println("Dequeue 1: " + queue.dequeue());
        System.out.println("Dequeue 2: " + queue.dequeue());
        System.out.println("Dequeue 3: " + queue.dequeue()); // null nếu rỗng

        System.out.println("\n=== BST TEST ===");
        TaskBST bst = new TaskBST();
        bst.insert(new Task(1, "Design UI"));
        bst.insert(new Task(2, "Build Backend"));
        bst.insert(new Task(3, "Write Test"));
        bst.insert(new Task(4, "Deploy"));
        bst.insert(new Task(5, "Fix Bug"));

        System.out.println("Search id=3: " + bst.search(3));
        System.out.println("Search id=99: " + bst.search(99));

        System.out.println("\n=== BENCHMARK LIST vs BST ===");
        int n = 10000;
        int targetId = 9999;

        TaskLinkedList bigList = new TaskLinkedList();
        TaskBST bigBST = new TaskBST();

        Random rand = new Random();

for (int i = 1; i <= n; i++) {
    int id = rand.nextInt(n) + 1;
    Task task = new Task(id, "Task " + id);

    bigList.add(task);
    bigBST.insert(task);
}
        

        for (int i = 0; i < 1000; i++) {
            bigList.searchById(targetId);
            bigBST.search(targetId);
        }

        long startList = System.nanoTime();
        Task foundInList = bigList.searchById(targetId);
        long endList = System.nanoTime();

        long startBST = System.nanoTime();
        Task foundInBST = bigBST.search(targetId);
        long endBST = System.nanoTime();

Graph graph = GraphLoader.loadFromFile("src/graph.txt");
if (graph == null) {
    System.out.println("Load graph failed!");
    return;
}


        System.out.println("Found in List: " + foundInList);
        System.out.println("Found in BST : " + foundInBST);
System.out.println("List search time: " + (endList - startList) + " ns");
System.out.println("BST  search time: " + (endBST - startBST) + " ns");
System.out.println("BFS:");
BFS.traverse(graph, 0);
System.out.println("\nDijkstra:");
Dijkstra.shortestPath(graph, 0);

        System.out.println("Queue test OK – No NullPointerException!");
    }
}

    
    

