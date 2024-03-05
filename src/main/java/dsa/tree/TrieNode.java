package dsa.tree;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {

	Map<Character,TrieNode> children; //key is parent and Trie Node children
	boolean endOfString;

	public TrieNode() {
		this.children = new HashMap<>();
		this.endOfString = false;
	}

	public Map<Character, TrieNode> getChildren() {
		return children;
	}

	public void setChildren(Map<Character, TrieNode> children) {
		this.children = children;
	}

	public boolean isEndOfString() {
		return endOfString;
	}

	public void setEndOfString(boolean endOfString) {
		this.endOfString = endOfString;
	}
}
