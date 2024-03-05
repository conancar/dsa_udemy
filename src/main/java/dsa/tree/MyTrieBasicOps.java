package dsa.tree;


import java.util.List;

public class MyTrieBasicOps {

	public static void main(String[] args) {


		MyTrieImpl trie=new MyTrieImpl();
		trie.insert("ivan");
		trie.insert("ivana");
		trie.insert("ivanov");
		trie.insert("iva");
		trie.insert("ivandana");
		trie.insert("beta");


		final List<String> suggestions = trie.autocomplete("b");
		System.out.println(suggestions);

	}




}
