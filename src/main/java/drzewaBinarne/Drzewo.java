package drzewaBinarne;

public class Drzewo {
    private Wezel root;

    class Wezel {
        private Wezel left;
        private Wezel right;
        private Wezel parent;
        private int key;

        public Wezel(int key) {
            this.key = key;
            this.right = null;
            this.left = null;
            this.parent = null;
        }

        public Wezel getParent() {
            return parent;
        }

        public void setParent(Wezel parent) {
            this.parent = parent;
        }

        public Wezel getLeft() {
            return left;
        }
        public void setLeft(Wezel left) {
            this.left = left;
        }
        public Wezel getRight() {
            return right;
        }
        public void setRight(Wezel right) {
            this.right = right;
        }
        public int getKey() {
            return key;
        }
        public void setKey(int key) {
            this.key = key;
        }

    }

    public static void main(String[] args) {
        Drzewo tree = new Drzewo();
        tree.addWezel(10);
        tree.addWezel(5);
        tree.addWezel(20);
        tree.addWezel(2);
        tree.addWezel(8);
        tree.addWezel(15);


        System.out.println("Wezel o wartości 10: " + tree.getWezel(10).getKey());
        System.out.println("Maksymalna wartość w drzewie: " + tree.getMax(tree.getRoot()).getKey());
        System.out.println("Minimalna wartość w drzewie: " + tree.getMin(tree.getRoot()).getKey());
        System.out.println("Następnik korzenia: " + tree.successor(tree.getRoot()).getKey());
        System.out.println("Poprzednik korzenia: " + tree.predecessor(tree.getRoot()).getKey());
        System.out.println("Wartość korzenia: " + tree.getRoot().getKey());
        System.out.println("Usuwam aktualny korzeń - klucz " + tree.getRoot().getKey());
        tree.removeWezel(10);
        System.out.println("Wartość korzenia: " +tree.getRoot().getKey());
        System.out.println("Rekurencyjne wyszukiwaie: " + tree.getWezel(tree.getRoot(), 5).getKey());
    }

    public Wezel getWezel(int key) {
        Wezel current = getRoot();
        while(current != null && current.getKey() != key) {
            if(key > current.getKey()) {
                current = current.getRight();
            }else {
                current = current.getLeft();
            }
        }

        if(current == null) {
            throw new NullPointerException("Nie znaleziono węzła z kluczem " + key);
        }

        return current;
    }

    public Wezel getWezel(Wezel node, int key) {
        if (key > node.getKey()){
            return getWezel(node.getRight(), key);
        }else if(key < node.getKey()) {
            return getWezel(node.getLeft(), key);
        }else {
            return node;
        }
    }

    public boolean addWezel(int key){
        Wezel parent = null;
        Wezel current = getRoot();
        while(current != null) {
            parent = current;
            if(current.getKey() == key) {
                return false;
            }

            if(key > current.getKey()) {
                current = current.getRight();
            }else if(key < current.getKey()) {
                current = current.getLeft();
            }
        }

        Wezel tmp = new Wezel(key);
        if(parent == null) {
            setRoot(tmp);
        }else if(key > parent.getKey()) {
            parent.setRight(tmp);
            tmp.setParent(parent);
        }else if(key < parent.getKey()) {
            parent.setLeft(tmp);
            tmp.setParent(parent);
        }

        return true;
    }

    public void removeWezel(int key) {
        Wezel toDelete = getWezel(key);
        Wezel tmp,pred = null;

        if(toDelete.getLeft() == null || toDelete.getRight() == null) {
            //usuwamy liść lub element z jednym poddrzewem
            tmp = toDelete;
        }else {
            //usuwamy węzeł, z dwoma potomkami - szukamy następnika
            //można też znalezc poprzednik
            tmp = successor(toDelete);
        }

        if(tmp.getLeft() != null) {
            pred = tmp.getLeft();
        }else {
            pred = tmp.getRight();
        }

        if(pred != null) {
            pred.setParent(tmp.getParent());
        }

        if(tmp.getParent() == null) {
            setRoot(pred);
        }else {
            if(tmp == tmp.getParent().getLeft()) {
                tmp.getParent().setLeft(pred);
            }else {
                tmp.getParent().setRight(pred);
            }
        }

        if(tmp.getKey() != toDelete.getKey()) {
            toDelete.setKey(tmp.getKey());
        }
    }

    public Wezel predecessor(Wezel w) {
        if(w.getLeft() != null) {
            return getMax(w.getLeft());
        }

        Wezel tmp = w.getParent();
        while(w != null && w.getRight().getKey() != tmp.getKey()) {
            tmp = w;
            w = w.getRight();
        }

        return w;
    }

    public Wezel successor(Wezel w) {
        if(w.getRight() != null) {
            return getMin(w.getRight());
        }

        Wezel tmp = w.getParent();
        while(w != null && w.getLeft().getKey() != tmp.getKey()) {
            tmp = w;
            w = w.getLeft();
        }

        return w;
    }


    public Wezel getMin(Wezel w) {
        Wezel current = w;
        while(current.getLeft() != null) {
            current = current.getLeft();
        }

        return current;
    }

    public Wezel getMax(Wezel w) {
        Wezel current = w;
        while(current.getRight() != null) {
            current = current.getRight();
        }

        return current;
    }


    public Wezel getRoot() {
        return root;
    }

    public void setRoot(Wezel root) {
        this.root = root;
    }

}