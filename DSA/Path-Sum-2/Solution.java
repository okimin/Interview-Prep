import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) { 
        this.val = val; 
    }
}

public class Solution {
    private List <List<Integer>> temp;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        temp = new ArrayList<>();
        if(root == null)
            return temp;
        helperDfs(root,new ArrayList<>(), root.val, targetSum);
        return temp;
    }

    public void helperDfs(TreeNode root, List<Integer> path, int total, int targetSum) {
        //Only works if leaf
        path.add(root.val);
        if (root.left == null && root.right == null && total == targetSum) {
            temp.add(new ArrayList<>(path));
            //System.out.println("Success " + total + temp);
        }
        //System.out.println(root.val + " " + total + temp);

        
        if (root.left != null) {
            helperDfs(root.left, path, total + root.left.val, targetSum);
        }

        if (root.right != null) {
            helperDfs(root.right, path, total + root.right.val, targetSum);
        }

        path.remove(path.size() - 1);

    }
}
