package BinaryTree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTress_part_2 {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        Node subRoot = new Node(2);
        subRoot.left = new Node(4);
        subRoot.right = new Node(5);

        System.out.println(height(root));
        System.out.println(count(root));
        System.out.println(sum(root));
        System.out.println(diameter1(root));   // O(n^2)
        System.out.println(diameter2(root).diam);   // O(n)
        System.out.println(isSubtree(root, subRoot));
        topView(root);


    }

    static class Node {       // why static class, how does that constructor working
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // -----------------------------------------------------TopView------------------------------------------
    static class InfoTV{
        Node node;
        int hd;

        public InfoTV(Node node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }
    private static void topView(Node root) {
        Queue<InfoTV> q = new LinkedList<>();
        HashMap<Integer,Node> map = new HashMap<>();

        int min = 0, max = 0;
        q.add(new InfoTV(root,0));
        q.add(null);

        while (!q.isEmpty()){
            InfoTV curr = q.remove();
            if (curr == null){
                if (q.isEmpty()){
                    break;
                }else {
                    q.add(null);
                }
            }else {
                if (!map.containsKey(curr.hd)){
                    map.put(curr.hd,curr.node);
                }
                if (curr.node.left != null){
                    q.add(new InfoTV(curr.node.left,curr.hd-1));
                    min = Math.min(min,curr.hd-1);
                }
                if (curr.node.right != null){
                    q.add(new InfoTV(curr.node.right,curr.hd +1));
                    max = Math.max(max,curr.hd + 1);
                }
            }
        }
        for (int i = min; i <= max ; i++) {
            System.out.print(map.get(i).data+" ");
        }
        System.out.println();
    }
    //-------------------------------------------------------------------------------------------------

    //-------------------------------------------Comparing SubTree ------------------------------------

    public static boolean isSubtree(Node root, Node subRoot) {  // Revision needed
            if (root == null){
                return false;
            }

            if (root.data == subRoot.data ) {
                if (isIdentical(root, subRoot)){
                    return true;
                }
            }

            return isSubtree(root.left,subRoot) || isSubtree(root.right,subRoot);
    }

    private static boolean isIdentical(Node node, Node subRoot) {
        if (node == null && subRoot == null){
            return true;
        } else if (node == null || subRoot == null || node.data != subRoot.data) {
            return false;
        }

        if (!isIdentical(node.left,subRoot.left)) return false;
        if (!isIdentical(node.right,subRoot.right)) return false;

        return true;
    }
    //--------------------------------------------------------------------------------------------------

    //-----------------------------------------------Diameter Approach 2--------------------------------

    static class Info {
        int diam;
        int ht;

        public Info(int diam, int ht) {
            this.diam = diam;
            this.ht = ht;
        }
    }

    private static Info diameter2(Node root) {
        if (root == null) {
            return new Info(0, 0);
        }

        Info leftInfo = diameter2(root.left);
        Info rightInfo = diameter2(root.right);

        int finalHt = Math.max(leftInfo.ht, rightInfo.ht) + 1;
        int finalDiameter = Math.max(Math.max(leftInfo.diam, rightInfo.diam), (leftInfo.ht + rightInfo.ht + 1));


        return new Info(finalDiameter, finalHt);
    }
//--------------------------------------------------------------------------------------------------

//    ---------------------------------------------Diameter Approach 1-----------------------------------------------------


    private static int diameter1(Node root) {
        if (root == null) {
            return 0;
        }
        int leftDiam = diameter1(root.left);
        int rightDiam = diameter1(root.right);
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        int selfDiameter = leftHeight + rightHeight + 1;

        return Math.max(Math.max(leftDiam, rightDiam), selfDiameter);
    }

//    --------------------------------------------------------------------------------------------------

//    --------------------------------------------Height------------------------------------------------------

    public static int height(Node root) {
        if (root == null) {
            return 0;
        }
        int lh = height(root.left);
        int rh = height(root.right);

        return Math.max(lh, rh) + 1;
    }
//    --------------------------------------------------------------------------------------------------

//    ---------------------------------------------Count-----------------------------------------------------

    public static int count(Node root) {
        if (root == null) {
            return 0;
        }
        int lc = count(root.left);
        int rc = count(root.right);

        return lc + rc + 1;
    }
    //    --------------------------------------------------------------------------------------------------

//    ---------------------------------------------Sum-----------------------------------------------------

    public static int sum(Node root) {
        if (root == null) {
            return 0;
        }
        int ls = sum(root.left);
        int rs = sum(root.right);

        return ls + rs + root.data;
    }
}
