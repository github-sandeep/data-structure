package com.sandeep.misc;

public class Test {
   public static void main(String args[]) {
      Trie trie = new Trie();
      trie.insert("abc");
      trie.insert("abgl");
      trie.insert("cdf");
      trie.insert("abcd");
      System.out.println(trie.search("abcd"));
      System.out.println(trie.search("cdf"));
      System.out.println(trie.search("xyz"));
      System.out.println(trie.search("abcdefg"));
   }
}
