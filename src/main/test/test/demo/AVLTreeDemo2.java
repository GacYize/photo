package test.dome;

/**
 * @author ghj
 * @Description
 * @date 2020/3/31 15:02
 */
public class AVLTreeDome2 {
    static class BTree {
        private int data;
        private BTree parent;
        private BTree leftNode;
        private BTree rightNode;
        private int height;
        private int balance;

        public BTree(int data) {
            this.data = data;
        }


        public void insert(BTree tree, int data) {
            int compare = tree.data - data;

            if (compare > 0) {
                if (tree.leftNode != null) {
                    this.height++;
                    insert(tree.leftNode, data);
                } else {
                    BTree bTree = new BTree(data);
                    tree.leftNode = bTree;
                    tree.leftNode.parent = tree;
                }
            }
            if (compare < 0) {
                if (tree.rightNode != null) {
                    this.height++;
                    insert(tree.rightNode, data);
                } else {
                    BTree bTree = new BTree(data);
                    tree.rightNode = bTree;
                    tree.rightNode.parent = tree;
                }
            }
        }
        //左旋

        //右旋

    }

    public static void main(String[] args) {
        BTree root = new BTree(10);
        root.insert(root, 15);
        root.insert(root, 52);
        root.insert(root, 3);
        root.insert(root, 19);
        root.insert(root, 9);
        System.out.println();
    }
}
