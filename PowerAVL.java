import java.io.BufferedReader;
import java.io.FileReader;

/**
 * This class represents the object of a AVL tree, some of the methods code comes from the CSC2001F slides.
 *
 */
public class PowerAVL {
    public AVLNode[] readingsNodelist;
    private int counter = 0;
    private AVLNode root;
    public int[] instrumentationBSTStore = new int[10];
    int FindFrequency = 0;
    int InsertFrequency = 0;

    /**
     * This generates a AVL tree
     * @param p
     */
    public PowerAVL( int p){
        try {
            BufferedReader readin = new BufferedReader(new FileReader("cleaned_data.csv"));
            String line ;
            readingsNodelist = new AVLNode[500];
            while ((line = readin.readLine()) != null){
                if (line.substring(0,1).equals("D")){
                    continue;
                }
                String[] values = line.split(",");
                readingsNodelist[counter] = new AVLNode(values[0], values[1], values[3]);
                counter++;
            }
        }

        catch (Exception e ) {
            e.printStackTrace();}
        int i = 0;
        for (AVLNode attach : readingsNodelist){
            if (i >= p){break;}
            insert(attach);
            i++;
        }
    }
    public void insert ( AVLNode newNode )
    {
        InsertFrequency = 0;
        root = insert (newNode, root);
    }

    public AVLNode insert ( AVLNode newNode, AVLNode node ){
        InsertFrequency++;
        if (node == null) {
            return new AVLNode (newNode.Datime, newNode.Power, newNode.Voltage);
        }
        InsertFrequency++;
        if (newNode.getDatime().compareTo(node.getDatime()) <= 0) {
            node.leftChild = insert (newNode, node.leftChild);
        } else {
            node.rightChild = insert (newNode, node.rightChild);
        }
        return balance (node);
    }

    public int height ( AVLNode node ){
        if (node != null)
            return node.height;
        return -1;
    }
    public AVLNode rotateRight( AVLNode pivot ) {
        AVLNode holder = pivot.leftChild;
        pivot.leftChild = holder.rightChild;
        holder.rightChild = pivot;
        fixHeight (pivot);
        fixHeight (holder);
        return holder;
    }
    public AVLNode rotateLeft( AVLNode holder ) {
        AVLNode pivot = holder.rightChild;
        holder.rightChild = pivot.leftChild;
        pivot.leftChild = holder;
        fixHeight (holder);
        fixHeight (pivot);
        return pivot;
    }

    public int balanceFactor ( AVLNode node ){
        return height (node.getRight()) - height (node.getLeft());
    }

    public AVLNode balance ( AVLNode p )
    {
        fixHeight (p);
        InsertFrequency++;
        if (balanceFactor (p) == 2)
        {
            InsertFrequency++;
            if (balanceFactor (p.rightChild) < 0)
                p.rightChild = rotateRight (p.rightChild);
            return rotateLeft (p);
        }
        InsertFrequency++;
        if (balanceFactor (p) == -2)
        {
            InsertFrequency++;
            if (balanceFactor (p.leftChild) > 0)
                p.leftChild = rotateLeft (p.leftChild);
            return rotateRight (p);
        }
        return p;
    }

    public void fixHeight ( AVLNode node ){
        node.height = Math.max (height (node.getLeft()),
                height (node.getRight())) + 1;
    }

    public AVLNode find(String instring){
        FindFrequency = 0;
        if (root == null){
            return null;
        }
        else{
            return find (instring, root);
        }
    }

    /**
     * 
     * @param instring
     * @param Reference
     * @return
     */
    public AVLNode find(String instring, AVLNode Reference){
        FindFrequency++;
        if (instring.equals("")) return null;
        FindFrequency++;
        if (instring.compareTo(Reference.Datime) == 0){
            return Reference;
        }
        else
            FindFrequency++;
        if (instring.compareTo(Reference.Datime) < 0){

            return (Reference.getLeft() == null) ? null : find (instring, Reference.leftChild);
        }
        else{
            FindFrequency++;
            return (Reference.getRight() == null) ? null : find (instring, Reference.rightChild);
        }
    }

    public void FileIteratorFind(String File) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(File));
        String line;
        Performance out = new Performance(0);
        while ((line = br.readLine()) != null){
            printDateTimeAVL(line);
            out.UpdatePerformance(this.FindFrequency);
        }
        System.out.println(out.PrinterFIND());
        System.out.println("Insert Instrumentation: " + this.getInsertFrequency());
    }

    public void inOrder( AVLNode tempRoot ){
        if (tempRoot != null){
            inOrder(tempRoot.getLeft ());
            System.out.println(tempRoot);
            inOrder(tempRoot.getRight ());
        }
    }

    public void printDateTimeAVL(String input){
        System.out.println(find(input));
    }

    public void printAllDateTimesAVL(){
        inOrder(root);
    }

    public int getFindFrequency(){
        return FindFrequency;
    }

    public int getInsertFrequency() { return InsertFrequency;}
}
