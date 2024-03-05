package dsa.tree;
import java.util.ArrayList;
import java.util.List;

public class MyTrieImpl {

	TrieNode root;

	public MyTrieImpl() {
		root=new TrieNode();
	}

	//O(M) Time, O(M) space , where M is length of word
	public void insert(String word) {
		TrieNode current = root;
		for (int i=0;i<word.length();i++) {
			char character=word.charAt(i);

			TrieNode child = current.getChildren().get(character);
			if(child==null){
				child=new TrieNode();
				current.children.put(character,child);
			}

			current=child; //loop to next letter
		}
		current.setEndOfString(true);
	}

	public boolean search(String word){
		TrieNode current = root;
		for (int i=0;i<word.length();i++) {
			char character=word.charAt(i);

			TrieNode child = current.getChildren().get(character);
			if(child==null){
				return false;
			}

			current=child; //loop to next letter
		}
		if(current.isEndOfString()){
			return true;
		}else{
			System.out.println("Word does not exists, but is prefix of another string");
		}
		return current.isEndOfString();
	}

	// Delete a String from Trie

	private boolean delete(TrieNode parentNode, String word, int index) {
		char ch = word.charAt(index);
		TrieNode currentNode = parentNode.children.get(ch);
		boolean canThisNodeBeDeleted;

		if (currentNode.children.size() > 1) {
			delete(currentNode, word, index+1);
			return false;
		}
		if (index == word.length() -1) {
			if (!currentNode.children.isEmpty()) {
				currentNode.endOfString = false;
				return false;
			} else {
				parentNode.children.remove(ch);
				return true;
			}
		}
		if (currentNode.endOfString) {
			delete(currentNode, word, index+1);
			return false;
		}
		canThisNodeBeDeleted = delete(currentNode, word, index+1);
		if (canThisNodeBeDeleted) {
			parentNode.children.remove(ch);
			return true;
		} else {
			return false;
		}
	}

	public void delete(String word) {
		if (search(word)) {
			delete(root, word, 0);
		}
	}

	private void dfs(TrieNode node, String prefix, List<String> suggestions) {
		if (node.isEndOfString()) {
			suggestions.add(prefix); // Add complete word to suggestions list
		}
		for (Character ch : node.children.keySet()) {
			dfs(node.children.get(ch), prefix + ch, suggestions); // Recursive call with updated prefix
		}
	}

	public List<String> autocomplete(String prefix) {
		TrieNode current = root;
		List<String> suggestions = new ArrayList<>();
		for (char ch : prefix.toCharArray()) {
			current = current.children.get(ch);
			if (current == null) {
				return suggestions; // No matching prefix found
			}
		}

		// Traverse trie and collect words with isEndOfWord flag set
		dfs(current, prefix, suggestions);
		return suggestions;
	}

}
