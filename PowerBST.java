import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * This class is creates a Binary Tree from the file.csv , in order to search for the desired items or print in order.
 */
public class PowerBST {

    public ReadingsNode[] readingsNodelist;
    private int counter = 0;
    private ReadingsNode root;
    int  Findfrequency = 0;
    int Insertfrequency = 0;

    /**
     * constructor
     * initializes a PowerBST object and creates the binary tree.
     */
    public PowerBST(int p)  {
        try {
            BufferedReader readin = new BufferedReader(new FileReader("cleaned_data.csv"));
            String line ;
            readingsNodelist = new ReadingsNode[500];
            while ((line = readin.readLine()) != null){
                if (line.substring(0,1).equals("D")){
                    continue;
                }
                String[] values = line.split(",");
                readingsNodelist[counter] = new ReadingsNode(values[0], values[1], values[3]);
                counter++;
            }
        }

        catch (Exception e ) {
            e.printStackTrace();}
            int i =0;
            for (ReadingsNode attach : readingsNodelist){
                if (i >= p){break;}
                addNode(attach);
                i++;
            }
    }

    /**
     * Adds the parameter to binary tree, if no tree exists, this will be the root Node.
     * @param temp of type ReadingsNode
     */
    public void addNode(ReadingsNode temp){
        ReadingsNode newNode = new ReadingsNode(temp.Datime, temp.Power, temp.Voltage);
        Insertfrequency = 0;
        if(root == null){
            root = newNode;
        }
        else{
            ReadingsNode tempRoot = root;
            ReadingsNode parent;
            while(true){
                parent = tempRoot;
                Insertfrequency++;
                if((tempRoot.Datime).compareTo(temp.Datime) > 0){
                    tempRoot = tempRoot.leftChild;
                    Insertfrequency++;
                    if(tempRoot == null){
                        parent.leftChild = newNode;
                        return;
                    }
                }
                else{
                    tempRoot = tempRoot.rightChild;
                    Insertfrequency++;
                    if(tempRoot == null){
                        parent.rightChild = newNode;
                        return;
                    }
                }
            }
        }
    }

    /**
     * This method will print all Readings in order of Date and time.
     * @param tempRoot Uses this Node as a reference to PrintAll in order.
     */
    public void inOrder( ReadingsNode tempRoot ){
        if (tempRoot != null){
            inOrder(tempRoot.getLeft ());
            System.out.println(tempRoot);
            inOrder(tempRoot.getRight ());
        }
    }

     /**
     * This method allows us to search for a desired Reading in the tree.
     * @param instring is the item we wish to find
     * @return ReadingsNode we were looking for.
     */
    public ReadingsNode find(String instring){
        Findfrequency = 0;
        if (root == null){
            return null;
        }
        else{
            return find (instring, root);
        }
    }

    /**
     * 
     * @param instring is the item we are looking for.
     * @param Reference 
     * @return
     */
    public ReadingsNode find(String instring, ReadingsNode Reference){
        Findfrequency++;
        if (instring.equals("")) return null;
        Findfrequency++;
        if (instring.compareTo(Reference.Datime) == 0){
            return Reference;
        }
        else
            Findfrequency++;
            if (instring.compareTo(Reference.Datime) < 0){
            return (Reference.getLeft() == null) ? null : find (instring, Reference.leftChild);
        }
        else{
            return (Reference.getRight() == null) ? null : find (instring, Reference.rightChild);
        }
    }

    public void FileIteratorFind(String File) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(File));
        String line;
        Performance outFIND = new Performance(0);
        while ((line = br.readLine()) != null){
         printDateTimeBST(line);
         outFIND.UpdatePerformance(this.Findfrequency);
        }
        System.out.println(outFIND.PrinterFIND());
        System.out.println("Insert Instrumentation: " + this.getInsertfrequency());
    }

    /**
     * Prints the found item.
     * @param input
     */
    public void printDateTimeBST (String input){
        System.out.println(find(input));
    }

    /**
     * Prints all items from the inOrder() method.
     */
    public void printAllDateTimesBST () {
        inOrder(root);
    }

    /**
     * @return the instrumentation.
     */
    public int getFindfrequency () {
        return Findfrequency;
    }

    public int getInsertfrequency() {
        return Insertfrequency;
    }
}



