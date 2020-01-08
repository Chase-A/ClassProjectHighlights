package highlights;

/*
 * Student First Name: Chase
 * Student Last Name: Almy
 * Student BU Number: U64493103
 * Honor Code: Honor Code: I pledge that this program represents my own program code and that I have coded on my own. 
 * I have also read the collaboration policy on the course syllabus for
 * CS 112 and my program adheres and is consistent with the course syllabus.
 */

import java.util.LinkedList;


public class DirectoryTree {
	// TODO nothing here is implemented, these are just empty
	// shells so the compiler doesn't complain
	// Implement private members, public methods,
	// and private helper methods, etc., as needed,
	// in order to get the behavior described on the pset
	// You will want to maintain two private members:
	// the root and the current directory.
	
	private Node root;
	private Node currentDirectory;
	private int tempNodeNumber;
	private String tempSubTree;
	private class Node{
		String name;
		Node parent;
		LinkedList<Node> children;
		public Node() {
			name = "";
			children = new LinkedList<Node>();
		}
	}
	
	public DirectoryTree() {
		root = new Node();
		currentDirectory = root;
		root.parent = null;
		tempNodeNumber = 1;
		tempSubTree = "";
	}
	public boolean mkdir (String name) {
		for(int i = 0; i < currentDirectory.children.size(); i++) {
			if (currentDirectory.children.get(i).name.equals(name)) {
				return false;
			}
		}
		Node added = new Node();
		added.name = name;
		added.parent = currentDirectory;
		currentDirectory.children.add(added);
		return true;
	}
	
	public boolean cd (String name) {
		Node added = new Node();
		added.name = name;
		for(int i = 0; i < currentDirectory.children.size(); i++) {
			if (currentDirectory.children.get(i).name.equals(name)) {
				currentDirectory = currentDirectory.children.get(i);
			return true;
			}
		}
		return false;
	}
	
	public boolean cdUp() {
		if(currentDirectory.parent == null) return false;
		currentDirectory = currentDirectory.parent;
		return true;
	}
	
	public boolean rmdir (String name) {
		for(int i = 0; i < currentDirectory.children.size(); i++) {
			if (currentDirectory.children.get(i).name.equals(name)) {
				currentDirectory.children.remove(i);
			}
		}
		return false;
	}

	public String ls () {
		String ret = "";
		for(int i = 0; i < currentDirectory.children.size(); i++) {
			ret = ret + currentDirectory.children.get(i).name + "\n";
		}
		return ret;
	}
	
	public String printSubTree() {
		tempSubTree = "";
		return __printSubTree(currentDirectory, 0);
	}
	private String __printSubTree(Node next, int depth) {
		if (next.name == "") return"";
		else {
			tempSubTree = tempSubTree + "  ".repeat(depth) + next.name + "\n";
			for(int i = 0; i < next.children.size(); i++) {
				
				__printSubTree(next.children.get(i), depth + 1);
			}
		}
		
		
		return tempSubTree;
	}
	
	public String pwd () {
		String ret = "";
		Node temp = currentDirectory;
		while (currentDirectory.parent != null) {
			ret = ret+ "/" + currentDirectory.name ;
			currentDirectory = currentDirectory.parent;
		}
		currentDirectory = temp;
		return ret;
	}
	
	public int numNodes() {
		tempNodeNumber = 1;
		return __numNodes(currentDirectory);
	}
	private int __numNodes(Node next) {
		if (next.children.isEmpty()) return tempNodeNumber;
		for(int i = 0; i < next.children.size(); i++) {
			tempNodeNumber++;
			__numNodes(next.children.get(i));
		}
		return tempNodeNumber;
	}
}
