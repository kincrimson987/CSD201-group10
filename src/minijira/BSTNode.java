package minijira;

class BSTNode {
    private Task data;
    private BSTNode left;
    private BSTNode right;

    public BSTNode(Task data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public Task getData() {
        return data;
    }

    public void setData(Task data) {
        this.data = data;
    }

    public BSTNode getLeft() {
        return left;
    }

    public void setLeft(BSTNode left) {
        this.left = left;
    }

    public BSTNode getRight() {
        return right;
    }

    public void setRight(BSTNode right) {
        this.right = right;
    }
}