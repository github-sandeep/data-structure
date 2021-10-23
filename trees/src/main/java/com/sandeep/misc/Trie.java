package com.sandeep.misc;

import java.util.HashMap;
import java.util.Map;

public class Trie {

   private class TrieNode {
      Map<Character, TrieNode> children;
      boolean endOfWord;

      public TrieNode() {

         children = new HashMap<>();
         endOfWord = false;
      }
   }

   private TrieNode root;
   public Trie() {
      root = new TrieNode();
   }

   public void insert(String word) {
      TrieNode curr = root;
      for(int i = 0; i < word.length(); i++) {
         Character ch = word.charAt(i);
         TrieNode node = curr.children.get(ch);
         if(node == null) {
            node = new TrieNode();
            curr.children.put(ch, node);
         }
         curr = node;
      }
      curr.endOfWord = true;
   }

   public boolean search(String word) {
      TrieNode curr = root;
      for(int i = 0; i < word.length(); i++) {
         Character ch = word.charAt(i);
         TrieNode node = curr.children.get(ch);
         if(node == null) {
            return false;
         }
         curr = node;
      }
      return curr.endOfWord;
   }
}
