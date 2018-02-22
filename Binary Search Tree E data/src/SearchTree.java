
public class SearchTree<E extends Comparable <E>> {
	
	private SearchTreeNode<E> overallRoot;

	//post: constructs an empty tree
	public SearchTree(){
		overallRoot = null;
	}
	
	//post: value is added to overall tree so as to preserve the
	public void add(E value){
		overallRoot = add((SearchTreeNode<E>) overallRoot, value); 
	}
	//post: value is added to the given tree so as to preserve the
	//		binary search tree property
	private SearchTreeNode<E> add(SearchTreeNode<E> root, E value){
		if(root == null){
			root = new SearchTreeNode<E>(value);
		}
		int compare = ((Comparable<E>) value).compareTo((E) root.data);
		if(compare <= 0){
			root.left = add(root.left, value);
		}else{//value > root.data
			root.right = add(root.right, value);
		}
		return root;
	}
	
	//post: returns true if overall tree contains value
	public boolean contains(E value){
		return contains((SearchTreeNode<E>) overallRoot, value);
	}
	//post: returns true if the given tree contains value
	private boolean contains(SearchTreeNode<E> root, E value){
		if(root == null){
			return false;
		}else if(value.equals(root.data)){
			return true;
		}else if(value.compareTo((E) root.data) < 0){
			return contains(root.left, value);
		}else{//value > root.data
			return contains(root.right, value);
		}
	}
	//post: prints the tree contents using an inorder traversal
	public void print(){
		printInorder((SearchTreeNode<E>) overallRoot);
		System.out.println();
	}
	//post: prints contents of the tree with given root
	//		using an inorder traversal
	private void printInorder(SearchTreeNode<E> root){
		if(root != null){ //recursive case
			printInorder(root.left);		//left entire (subtree)
			System.out.print(root.data + " ");	//value of the root
			printInorder(root.right);		//right entire(subtree)
		}
	}
	
	// post: prints the tree contents, one per line, following an
	// 		inorder traversal and using indentation to indicate
	// 		node depth; prints right to left so that it looks
	// 		correct when the output is rotated.
	public void printSideways(){
		printSideways((SearchTreeNode<E>) overallRoot, 0);
	}
	// post: prints in reversed preorder the tree with given
	// 		root, indenting each line to the given level
	private void printSideways(SearchTreeNode<E> root, int level){
		if(root != null){
			printSideways(root.right, level + 1);
			for(int i = 0; i < level; i++){
				System.out.print("   ");
			}
			System.out.println(root.data);
			printSideways(root.left, level + 1);
		}
	}

}
