package minijira;

class TaskBST {
    private BSTNode root;

    public TaskBST() {
        this.root = null;
    }

    public BSTNode getRoot() {
        return root;
    }

    public void setRoot(BSTNode root) {
        this.root = root;
    }

    public void insert(Task task) {
        if (task == null) {
            return;
        }
        root = insertRec(root, task);
    }

    private BSTNode insertRec(BSTNode node, Task task) {
        if (node == null) {
            return new BSTNode(task);
        }

        if (task.getId() < node.getData().getId()) {
            node.setLeft(insertRec(node.getLeft(), task));
        } else if (task.getId() > node.getData().getId()) {
            node.setRight(insertRec(node.getRight(), task));
        }

        return node;
    }

    public Task search(int id) {
        return searchRec(root, id);
    }

    private Task searchRec(BSTNode node, int id) {
        if (node == null) {
            return null;
        }

        if (id == node.getData().getId()) {
            return node.getData();
        }

        if (id < node.getData().getId()) {
            return searchRec(node.getLeft(), id);
        }

        return searchRec(node.getRight(), id);
    }
}  