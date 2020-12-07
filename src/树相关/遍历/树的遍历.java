package 树相关.遍历;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * 写树的遍历，包括层序前序和中序
 *
 */

public class 树的遍历 {

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

    // 层序遍历
    public static void order(TreeNode root){
        if(root == null){
            return;
        }
        // 用一个队列来存储
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode poll = queue.poll();
            System.out.println(poll);
            if(poll.left!=null){queue.offer(poll.left);};
            if(poll.right!=null){queue.offer(poll.right);};
        }
    }

    // 前序遍历    根节点  -> 左  -> 右
    public static void preOrder(TreeNode root){
        if(root==null) return;
        System.out.println(root);
        if(root.left!=null){preOrder(root.left);}
        if(root.right!=null){preOrder(root.right);}
    }

    // 中序遍历  左 -> 根 -> 右
    public static void midOrder(TreeNode root){
        if(root==null) return;
        if(root.left!=null){preOrder(root.left);}
        System.out.println(root);
        if(root.right!=null){preOrder(root.right);}
    }

    // 后续遍历  左 -> 右 -> 根
    public static void afterOrder(TreeNode root){
        if(root==null) return;
        if(root.left!=null){preOrder(root.left);}
        if(root.right!=null){preOrder(root.right);}
        System.out.println(root);
    }

    public static void main(String[] args) {
        // 层序遍历 1 -> 2 -> 3 -> 4
        System.out.println("层序遍历****************************");
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        order(treeNode1);

        // 前序遍历 1 ->2 ->4 ->3
        System.out.println("前序遍历***************************");
        preOrder(treeNode1);

        //中序遍历 2 -> 4 -> 1 -> 3
        System.out.println("中序遍历***************");
        midOrder(treeNode1);

        // 后续遍历 4 - > 2 -> 3 ->1
        System.out.println("后续遍历*********************");
        afterOrder(treeNode1);


    }
}
