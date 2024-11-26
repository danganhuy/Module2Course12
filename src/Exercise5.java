import Tree.*;

public class Exercise5 {
    // [Optional] [Thực hành] Cài đặt cây tìm kiếm nhị phân
    public static void main(String[] args) {
        //create a BST
        BinarySearchTree<String> tree = new BinarySearchTree<String>();
        tree.insert("George");
        tree.insert("Michael");
        tree.insert("Tom");
        tree.insert("Adam");
        tree.insert("Jones");
        tree.insert("Peter");
        tree.insert("Daniel");
        //traverse tree
        System.out.println("Inorder (sorted): ");
        tree.inorder();
        System.out.println("The number of nodes is: " + tree.getSize());
    }
}
