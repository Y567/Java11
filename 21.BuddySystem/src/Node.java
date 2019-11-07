public class Node {
    /**
     * 封装伙伴信息
     */
    public int id;    //分区编号
    public int status;//分区状态，1表示被分配，0表示为被分配
    public double size;  //分区大小，2的L次方到2的U次方
    public Node parent;//伙伴的父节点
    public Node left;  //左孩子
    public Node right; //右孩子

    public Node(int K){
        this.id = super.hashCode();
        this.status = 0;
        this.size = Math.pow(2,K);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "Node{" +
                "id=" + id +
                ", status=" + status +
                ", size=" + size +
                ", parent=" + parent +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
