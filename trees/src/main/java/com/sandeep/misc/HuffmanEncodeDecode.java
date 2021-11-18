package com.sandeep.misc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Node {
    char val;
    Node left;
    Node right;
}

public class HuffmanEncodeDecode {
    static int index = 0;
    public Node createNode(char c) {
        Node node = new Node();
        node.val = c;
        node.left = null;
        node.right = null;
        return node;
    }

    public static String decodeMessage(Node root, String encodedMessage) {
        String ans = "";
        int n = encodedMessage.length();
        int currIndex = 0;
        Node temp = root;
        while(currIndex < n) {
            if(encodedMessage.charAt(currIndex) == '0') {
                temp = temp.left;
                if(temp.val != '*') {
                    ans = ans+ temp.val;
                    temp = root;
                }
            } else {
                temp = temp.right;
                if(temp.val != '*') {
                    ans = ans+ temp.val;
                    temp = root;
                }
            }
            currIndex++;
        }
        return ans;
    }
    public void preOrder(Node root) {
        if(root  != null) {
            System.out.print(root.val);
            preOrder(root.left);
            preOrder(root.right);
        }
    }
    public  Node constructTreeUtil(String preorder, int n) {
        if(index == n) {
            return null;
        }
        char curr = preorder.charAt(index);
        Node node = createNode(curr);
        index++;
        if(curr == '*') {
            node.left = constructTreeUtil(preorder, n);
            node.right = constructTreeUtil(preorder, n);
        }
        return node;
    }
    public  Node constructTree(String preorder) {
        return constructTreeUtil(preorder,  preorder.length());
    }
    public boolean getEncodedStringUtil(Node root, char curr, List<Character> ans) {
        if(root == null) {
            return false;
        }
        if(root.val == curr)
            return true;

        if(root.left!= null) {
            ans.add('0');
            boolean left = getEncodedStringUtil(root.left, curr, ans);
            if(left) {
                return true;
            }
        }
        if(root.right!= null) {
            ans.add('1');
            boolean right = getEncodedStringUtil(root.right, curr, ans);
            if(right)
                return true;
        }
        ans.remove(ans.size()-1);
        return false;
    }
    public String getString(List<Character> ans) {
        String ret = "";
        for(int i=0; i < ans.size(); i++) {
            ret = ret + ans.get(i);
        }
        return ret;
    }
    public String getEncodedString(Node root, char curr) {
        List<Character> ans = new ArrayList<>();
        getEncodedStringUtil(root, curr, ans);
        return getString(ans);
    }

    public void printEncodingCount(String str,  Node root) {

        int n = str.length();
        HashMap<Character, String> map = new HashMap<>();

        for(int i =0; i < n; i++) {
            char curr = str.charAt(i);
            if(curr == '*' || map.containsKey(curr))
                continue;
            String ret = getEncodedString(root, curr);
            map.put(curr, ret);
        }

        for(Map.Entry<Character, String> entry : map.entrySet()){
            char key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key + " " + value + " " + value.length());
        }
    }
    public static void main(String args[]) {
        HuffmanEncodeDecode obj = new HuffmanEncodeDecode();
        String str = "*a**!*dc*rb";
        Node root = obj.constructTree(str);
        obj.preOrder(root);
        System.out.println();
        System.out.println(obj.decodeMessage(root, "0111110"));
        obj.printEncodingCount(str, root);
    }
}
