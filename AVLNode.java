public class AVLNode {
    String Datime;
    String Power;
    String Voltage;
    AVLNode leftChild;
    AVLNode rightChild;
    int height;

    /**
     * constructor Creates new Node.
     * @param Datime
     * @param Power
     * @param Voltage
     */
    public AVLNode(String Datime, String Power, String Voltage ){
        this.Datime = Datime;
        this.Power = Power;
        this.Voltage = Voltage;

    }
    public AVLNode( AVLNode d , AVLNode left, AVLNode right){
        d.leftChild = left;
        d.rightChild = right;
    }

    /**
     *
     * @return
     */
    public String toString(){
        return "Date/Time: " + Datime + ", " + "Global_active_power: " + Power + ", " + "Voltage: " + Voltage;
    }

    public String getDatime() {
        return Datime;
    }


    public AVLNode getLeft() {
        return leftChild;
    }

    public AVLNode getRight() {
        return rightChild;
    }
}
