# LAB08 Trees and Graphs Solutions

## Definition of a Tree Node
``` java
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int n) {
            val = n;
            left = null;
            right = null;
        }
    }
```

## Problem 01: RECURSIVELY calculate the height of a tree.
``` java
    private int dfs(TreeNode root, int height) {
        if (root == null) return height;
        return Math.max(dfs(root.left, height), dfs(root.right, height + 1));
    }

    public int heightOfTree(TreeNode root) {
        return dfs(root, 0);
    }
```
## Problem 02: RECURSIVELY calculate the level of a Node in a tree.
``` java
    private int levelOfNodeHelper(TreeNode root, TreeNode target, int level) {
        if (root == null) return 0;
        if (root.val == target.val) return level;
        int leftSubtree = levelOfNodeHelper(root.left, target, level);
        if (leftSubtree > 0) return leftSubtree;
        int rightSubtree = levelOfNodeHelper(root.right, target, level);
        if (rightSubtree > 0) return rightSubtree;
        return 0;
    }

    public int levelOfNode(TreeNode root, TreeNode target) {
        // will return 0 if the target node is not present int the binary tree
        return levelOfNodeHelper(root, target, 1);
    }
```

## Problem 03: Print elements of all the Nodes of a tree using Pre-order Traversal.
``` java
    public void preOrderTraversal(TreeNode root) {
        if (root == null) return;
        System.out.print(root.val + " ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }
```

## Problem 04: Print elements of all the Nodes of a tree using In-order Traversal.
``` java
    public void inOrderTraversal(TreeNode root) {
        if (root == null) return;
        inOrderTraversal(root.left);
        System.out.print(root.val + " ");
        inOrderTraversal(root.right);
    }
```

## Problem 05: Print elements of all the Nodes of a tree using Post-order Traversal.
``` java
    public void postOrderTraversal(TreeNode root) {
        if (root == null) return;
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root.val + " ");
    }
```

## Problem 06: Write a method which will evaluate whether two trees are exactly same or not.
``` java
    public boolean sameTree(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return true;
        if (root1 == null || root2 == null) return false;
        return root1.val == root2.val && sameTree(root1.left, root2.left) && sameTree(root1.right, root2.right);
    }
```

## Problem 07: Write a method which will return a copy (new tree) of a given tree.
``` java
    private TreeNode copyTreeHelper(TreeNode root, TreeNode newRoot) {

    }

    public TreeNode copyTree(TreeNode root) {
        if (root == null) return null;
        TreeNode newRoot = new TreeNode(root.val);
    }
```

## Problem 08: An adjacency matrix is given below. Draw the equivalent graph.
