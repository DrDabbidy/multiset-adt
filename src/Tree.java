import java.util.ArrayList;

public class Tree {

    /**
     * A recursive tree data structure, which provides services required of the
     * MultiSet ADT. See TreeMultiSet, which is the next class defined.
     * This is a simplified version of the Tree data structure
     * adapted from CSC148.
     */

    // The item stored at this tree's root, or null if empty.
    private Object root = null;
    // The list of all subtrees of this tree.
    private ArrayList<Tree> subtrees;

    public Tree(Object root, ArrayList<Tree> subtrees) {
        this.root = root;
        this.subtrees = new ArrayList<>(subtrees);
    }

    public Tree(Object root) {
        this.root = root;
        this.subtrees = new ArrayList<>();
    }

    public int length() {
        if (this.is_empty()) {
            return 0;
        } else {
            int size = 1;
            for (Tree subtree : this.subtrees) {
                size += subtree.length();
            }
            return size;
        }
    }

    @Override
    public String toString() {
        return this.stringIndented();
    }

    private String stringIndented(int depth) {
        if (this.is_empty()) {
            return "";
        } else {
            StringBuilder s = new StringBuilder();
            s.append("  ".repeat(depth));
            s.append(this.root.toString());
            s.append("\n");
            for (Tree subtree: this.subtrees) {
                s.append(subtree.stringIndented(depth + 1));
            }
            return s.toString();
        }
    }

    private String stringIndented() {
        return this.stringIndented(0);
    }
}
